/*
    This file is part of RouteConverter.

    RouteConverter is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    RouteConverter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with RouteConverter; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/
package slash.navigation.graphhopper;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.util.PointList;
import slash.navigation.common.BoundingBox;
import slash.navigation.common.LongitudeAndLatitude;
import slash.navigation.common.NavigationPosition;
import slash.navigation.common.SimpleNavigationPosition;
import slash.navigation.datasources.DataSource;
import slash.navigation.datasources.Downloadable;
import slash.navigation.datasources.File;
import slash.navigation.download.Download;
import slash.navigation.download.DownloadManager;
import slash.navigation.download.FileAndChecksum;
import slash.navigation.routing.DownloadFuture;
import slash.navigation.routing.RoutingResult;
import slash.navigation.routing.RoutingService;
import slash.navigation.routing.TravelMode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import static com.graphhopper.util.CmdArgs.read;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static slash.common.io.Directories.ensureDirectory;
import static slash.common.io.Directories.getApplicationDirectory;
import static slash.common.io.Files.removeExtension;
import static slash.navigation.common.Bearing.calculateBearing;
import static slash.navigation.download.Action.Copy;

/**
 * Encapsulates access to the GraphHopper.
 *
 * @author Christian Pesch
 */

public class GraphHopper implements RoutingService {
    private static final Preferences preferences = Preferences.userNodeForPackage(GraphHopper.class);
    private static final Logger log = Logger.getLogger(GraphHopper.class.getName());
    private static final String DIRECTORY_PREFERENCE = "directory";
    private static final String BASE_URL_PREFERENCE = "baseUrl";
    private static final TravelMode CAR = new TravelMode("Car");
    private static final List<TravelMode> TRAVEL_MODES = asList(new TravelMode("Bike"), CAR, new TravelMode("Foot"));

    private final DownloadManager downloadManager;
    private DataSource dataSource;

    private com.graphhopper.GraphHopper hopper;
    private java.io.File osmPbfFile = null;

    public GraphHopper(DownloadManager downloadManager) {
        this.downloadManager = downloadManager;
    }

    public String getName() {
        return "GraphHopper";
    }

    public synchronized boolean isInitialized() {
        return getDataSource() != null;
    }

    public synchronized DataSource getDataSource() {
        return dataSource;
    }

    public synchronized void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isDownload() {
        return true;
    }

    public boolean isSupportTurnpoints() {
        return false;
    }

    public boolean isSupportAvoidFerries() {
        return false;
    }

    public boolean isSupportAvoidHighways() {
        return false;
    }

    public boolean isSupportAvoidTolls() {
        return false;
    }

    public List<TravelMode> getAvailableTravelModes() {
        return TRAVEL_MODES;
    }

    public TravelMode getPreferredTravelMode() {
        return CAR;
    }

    public String getPath() {
        return preferences.get(DIRECTORY_PREFERENCE, "");
    }

    public void setPath(String path) {
        preferences.put(DIRECTORY_PREFERENCE, path);
    }

    private String getBaseUrl() {
        return preferences.get(BASE_URL_PREFERENCE, getDataSource().getBaseUrl());
    }

    private java.io.File getDirectory() {
        String directoryName = getPath();
        java.io.File f = new java.io.File(directoryName);
        if (!f.exists())
            directoryName = getApplicationDirectory(getDataSource().getDirectory()).getAbsolutePath();
        return ensureDirectory(directoryName);
    }

    private java.io.File createFile(String key) {
        return new java.io.File(getDirectory(), key);
    }

    public RoutingResult getRouteBetween(NavigationPosition from, NavigationPosition to, TravelMode travelMode) {
        if(osmPbfFile == null){
            log.warning(format("Cannot route between %s and %s since there is no OSM .pbf file", from, to));
            return new RoutingResult(asList(from, to), calculateBearing(from.getLongitude(), from.getLatitude(), to.getLongitude(), to.getLatitude()).getDistance(), 0L, false);
        }

        long start = currentTimeMillis();
        try {
            GHRequest request = new GHRequest(from.getLatitude(), from.getLongitude(), to.getLatitude(), to.getLongitude());
            request.setVehicle(travelMode.getName().toUpperCase());
            GHResponse response = hopper.route(request);
            return new RoutingResult(asPositions(response.getPoints()), response.getDistance(), response.getTime(), true);
        } catch (Exception e) {
            log.warning(format("Exception while routing between %s and %s: %s", from, to, e));
            return new RoutingResult(asList(from, to), calculateBearing(from.getLongitude(), from.getLatitude(), to.getLongitude(), to.getLatitude()).getDistance(), 0L, false);
        } finally {
            long end = currentTimeMillis();
            log.fine(getClass().getSimpleName() + ": routing took " + (end - start) + " milliseconds");
        }
    }

    private String getAvailableTravelModeNames() {
        StringBuilder result = new StringBuilder();
        List<TravelMode> availableTravelModes = getAvailableTravelModes();
        for(int i=0; i < availableTravelModes.size(); i++) {
            result.append(availableTravelModes.get(i).getName().toUpperCase());
            if(i < availableTravelModes.size() - 1)
                result.append(",");
        }
        return result.toString();
    }

    void initializeHopper(java.io.File osmPbfFile) {
        this.osmPbfFile = osmPbfFile;
        String[] args = new String[]{
                "osmreader.acceptWay=" + getAvailableTravelModeNames(),
                "osmreader.osm=" + osmPbfFile.getAbsolutePath()
        };
        try {
            if (hopper != null)
                hopper.close();
            hopper = new com.graphhopper.GraphHopper().forDesktop();
            hopper.setEncodingManager(new EncodingManager(getAvailableTravelModeNames()));
            hopper.init(read(args)); // TODO this takes a long time initially, how to signal to user
            hopper.setCHEnable(false).setEnableInstructions(false).setGraphHopperLocation(createPath(osmPbfFile));
            hopper.importOrLoad();
        } catch (Exception e) {
            log.warning("Cannot initialize GraphHopper: " + e);
        }
    }

    private String createPath(java.io.File osmPbfFile) {
        return removeExtension(removeExtension(osmPbfFile.getAbsolutePath()));
    }

    private List<NavigationPosition> asPositions(PointList points) {
        List<NavigationPosition> result = new ArrayList<>();
        for (int i = 0, c = points.getSize(); i < c; i++) {
            result.add(new SimpleNavigationPosition(points.getLongitude(i), points.getLatitude(i), points.getElevation(i), null));
        }
        return result;
    }

    public DownloadFuture downloadRoutingDataFor(List<LongitudeAndLatitude> longitudeAndLatitudes) {
        BoundingBox routeBoundingBox = createBoundingBox(longitudeAndLatitudes);
        Downloadable downloadableForSmallestBoundingBox = null;
        BoundingBox smallestBoundingBox = null;

        if(isInitialized()) {
            for (File file : getDataSource().getFiles()) {
                BoundingBox fileBoundingBox = file.getBoundingBox();
                if (fileBoundingBox != null && fileBoundingBox.contains(routeBoundingBox)) {
                    if (smallestBoundingBox == null || smallestBoundingBox.contains(fileBoundingBox)) {
                        downloadableForSmallestBoundingBox = file;
                        smallestBoundingBox = fileBoundingBox;
                    }
                }
            }
        }

        final Downloadable downloadable = downloadableForSmallestBoundingBox;
        return new DownloadFuture() {
            public boolean isRequiresDownload() {
                return downloadable != null && !createFile(downloadable.getUri()).exists();
            }
            public boolean isRequiresProcessing() {
                return downloadable != null;
            }
            public void download() {
                downloadAll(downloadable);
            }
            public void process() {
                assert downloadable != null;
                initializeHopper(createFile(downloadable.getUri()));
            }
        };
    }

    private BoundingBox createBoundingBox(List<LongitudeAndLatitude> longitudeAndLatitudes) {
        List<NavigationPosition> positions = new ArrayList<>();
        for (LongitudeAndLatitude longitudeAndLatitude : longitudeAndLatitudes) {
            positions.add(new SimpleNavigationPosition(longitudeAndLatitude.longitude, longitudeAndLatitude.latitude));
        }
        return new BoundingBox(positions);
    }

    private void downloadAll(Downloadable downloadable) {
        Download download = download(downloadable);
        downloadManager.waitForCompletion(singletonList(download));
    }

    private Download download(Downloadable downloadable) {
        String uri = downloadable.getUri();
        String url = getBaseUrl() + uri;
        return downloadManager.queueForDownload(getName() + " Routing Data: " + uri, url, Copy,
                null, new FileAndChecksum(createFile(downloadable.getUri()), downloadable.getLatestChecksum()), null);
    }
}
