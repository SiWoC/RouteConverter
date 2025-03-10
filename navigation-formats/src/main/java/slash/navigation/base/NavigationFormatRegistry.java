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
package slash.navigation.base;

import slash.navigation.babel.*;
import slash.navigation.bcr.MTP0607Format;
import slash.navigation.bcr.MTP0809Format;
import slash.navigation.columbus.ColumbusGpsBinaryFormat;
import slash.navigation.columbus.ColumbusGpsType1Format;
import slash.navigation.columbus.ColumbusGpsType2Format;
import slash.navigation.columbus.GarbleColumbusGpsType1Format;
import slash.navigation.copilot.CoPilot6Format;
import slash.navigation.copilot.CoPilot7Format;
import slash.navigation.copilot.CoPilot8Format;
import slash.navigation.copilot.CoPilot9Format;
import slash.navigation.copilot.CoPilot10Format;
import slash.navigation.csv.CsvCommaFormat;
import slash.navigation.csv.CsvSemicolonFormat;
import slash.navigation.excel.MicrosoftExcel2008Format;
import slash.navigation.excel.MicrosoftExcel97Format;
import slash.navigation.fit.FitFormat;
import slash.navigation.fpl.GarminFlightPlanFormat;
import slash.navigation.geojson.GeoJsonFormat;
import slash.navigation.gopal.GoPal3RouteFormat;
import slash.navigation.gopal.GoPal5RouteFormat;
import slash.navigation.gopal.GoPal7RouteFormat;
import slash.navigation.gopal.GoPalTrackFormat;
import slash.navigation.gpx.GarbleGpx10Format;
import slash.navigation.gpx.GarbleGpx11Format;
import slash.navigation.gpx.Gpx10Format;
import slash.navigation.gpx.Gpx11Format;
import slash.navigation.itn.TomTom5RouteFormat;
import slash.navigation.itn.TomTom8RouteFormat;
import slash.navigation.itn.TomTom95RouteFormat;
import slash.navigation.klicktel.KlickTelRouteFormat;
import slash.navigation.kml.*;
import slash.navigation.lmx.NokiaLandmarkExchangeFormat;
import slash.navigation.mm.MagicMaps2GoFormat;
import slash.navigation.mm.MagicMapsIktFormat;
import slash.navigation.mm.MagicMapsPthFormat;
import slash.navigation.msfs.MSFSFlightPlanFormat;
import slash.navigation.nmea.GarbleNmeaFormat;
import slash.navigation.nmea.MagellanExploristFormat;
import slash.navigation.nmea.MagellanRouteFormat;
import slash.navigation.nmea.NmeaFormat;
import slash.navigation.nmn.*;
import slash.navigation.ovl.OvlFormat;
import slash.navigation.photo.PhotoFormat;
import slash.navigation.simple.*;
import slash.navigation.tcx.Tcx1Format;
import slash.navigation.tcx.Tcx2Format;
import slash.navigation.tour.TourFormat;
import slash.navigation.url.*;
import slash.navigation.viamichelin.ViaMichelinFormat;
import slash.navigation.wbt.WintecWbt201Tk1Format;
import slash.navigation.wbt.WintecWbt201Tk2Format;
import slash.navigation.wbt.WintecWbt202TesFormat;
import slash.navigation.zip.ZipFormat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

/**
 * Managed the navigation formats.
 *
 * @author Christian Pesch
 */

public class NavigationFormatRegistry {
    private final List<Class<? extends NavigationFormat>> formats = new ArrayList<>();

    public NavigationFormatRegistry() {
        // native formats
        addFormat(NmnUrlFormat.class);
        addFormat(GoogleMapsUrlFormat.class);
        addFormat(KurvigerUrlFormat.class);
        addFormat(MotoPlanerUrlFormat.class);
        addFormat(GeoHackUrlFormat.class);
        addFormat(UrlFormat.class);
        addFormat(NmeaFormat.class);
        addFormat(MTP0809Format.class);
        addFormat(MTP0607Format.class);
        addFormat(TomTom95RouteFormat.class);
        addFormat(TomTom8RouteFormat.class);
        addFormat(TomTom5RouteFormat.class);
        addFormat(Igo8RouteFormat.class);
        addFormat(Kml22Format.class);
        addFormat(Kmz22Format.class);
        addFormat(Kml22BetaFormat.class);
        addFormat(Kmz22BetaFormat.class);
        addFormat(Kml21Format.class);
        addFormat(Kmz21Format.class);
        addFormat(Kml20Format.class);
        addFormat(Kmz20Format.class);
        addFormat(Gpx11Format.class);
        addFormat(Gpx10Format.class);
        addFormat(Nmn7Format.class);
        addFormat(Nmn6FavoritesFormat.class);
        addFormat(Nmn6Format.class);
        addFormat(Nmn5Format.class);
        addFormat(Nmn4Format.class);
        addFormat(WebPageFormat.class);
        addFormat(GpsTunerFormat.class);
        addFormat(HaicomLoggerFormat.class);
        addFormat(CoPilot7Format.class);
        addFormat(CoPilot9Format.class);
        addFormat(CoPilot8Format.class);
        addFormat(CoPilot10Format.class);
        addFormat(CoPilot6Format.class);
        addFormat(Route66Format.class);
        addFormat(KompassFormat.class);
        addFormat(GlopusFormat.class);
        addFormat(ColumbusGpsType1Format.class);
        addFormat(ColumbusGpsType2Format.class);
        addFormat(QstarzQ1000Format.class);
        addFormat(Iblue747Format.class);
        addFormat(SygicAsciiFormat.class);
        addFormat(SygicUnicodeFormat.class);
        addFormat(MagicMapsPthFormat.class);
        addFormat(GoPal7RouteFormat.class);
        addFormat(GoPal5RouteFormat.class);
        addFormat(GoPal3RouteFormat.class);
        addFormat(OvlFormat.class);
        addFormat(TourFormat.class);
        addFormat(ViaMichelinFormat.class);
        addFormat(MagicMapsIktFormat.class);
        addFormat(MagicMaps2GoFormat.class);
        addFormat(MagellanExploristFormat.class);
        addFormat(MagellanRouteFormat.class);
        addFormat(Tcx2Format.class);
        addFormat(Tcx1Format.class);
        addFormat(NokiaLandmarkExchangeFormat.class);
        addFormat(KlickTelRouteFormat.class);
        addFormat(GarminFlightPlanFormat.class);
        addFormat(WintecWbt201Tk1Format.class);
        addFormat(WintecWbt201Tk2Format.class);
        addFormat(ColumbusGpsBinaryFormat.class);
        addFormat(NavilinkFormat.class);
        addFormat(NavigonCruiserFormat.class);
        addFormat(GoRiderGpsFormat.class);
        addFormat(KienzleGpsFormat.class);
        addFormat(GroundTrackFormat.class);
        addFormat(OpelNaviFormat.class);
        addFormat(NavigatingPoiWarnerFormat.class);
        addFormat(NmnRouteFormat.class);
        addFormat(ApeMapFormat.class);
        addFormat(PhotoFormat.class);
        addFormat(MicrosoftExcel97Format.class);
        addFormat(MicrosoftExcel2008Format.class);
        addFormat(FitFormat.class);
        addFormat(GeoJsonFormat.class);
        addFormat(MSFSFlightPlanFormat.class);

        // kind of meta-format
        addFormat(ZipFormat.class);

        // GPSBabel-based formats
        addFormat(GarminMapSource6Format.class);
        addFormat(GarminMapSource5Format.class);
        addFormat(TourExchangeFormat.class);
        addFormat(NationalGeographicTopo3Format.class);
        addFormat(MagellanMapSendFormat.class);
        addFormat(AlanTrackLogFormat.class);
        addFormat(AlanWaypointsAndRoutesFormat.class);
        addFormat(OziExplorerRouteFormat.class);
        addFormat(OziExplorerTrackFormat.class);
        addFormat(OziExplorerWaypointFormat.class);
        addFormat(CompeGPSDataRouteFormat.class);
        addFormat(CompeGPSDataTrackFormat.class);
        addFormat(CompeGPSDataWaypointFormat.class);
        addFormat(GarminPcx5Format.class);
        addFormat(GeoCachingFormat.class);
        addFormat(GoPalTrackFormat.class);
        addFormat(TomTomPoiFormat.class);
        addFormat(HoluxM241BinaryFormat.class);
        addFormat(FlightRecorderDataFormat.class);
        addFormat(WintecWbt202TesFormat.class);

        // greedy native formats
        addFormat(CsvCommaFormat.class);
        addFormat(CsvSemicolonFormat.class);

        // second try for broken files
        addFormat(GarbleColumbusGpsType1Format.class);
        addFormat(GarbleNmeaFormat.class);
        addFormat(GarbleHaicomLoggerFormat.class);
        addFormat(GarbleGpx10Format.class);
        addFormat(GarbleGpx11Format.class);
        addFormat(GarbleKml21Format.class);
        addFormat(GarbleKml21LittleEndianFormat.class);
        addFormat(GarbleKmz21Format.class);
        addFormat(GarbleKmz21LittleEndianFormat.class);
        addFormat(GarbleKml22BetaFormat.class);
        addFormat(GarbleKml22Format.class);
        addFormat(GarbleNavilinkFormat.class);

        // greedy GPSBabel-formats
        addFormat(GarminPoiFormat.class);
        addFormat(Igo8TrackFormat.class);
        addFormat(GarminPoiDbFormat.class);
    }

    private void addFormat(Class<? extends NavigationFormat> format) {
        formats.add(format);
    }

    protected boolean includeReadFormat(NavigationFormat format) {
        return true;
    }

    private List<NavigationFormat> getFormatInstances(boolean includeReadableFormats, boolean includeWritableFormats) {
        List<NavigationFormat> result = new ArrayList<>();
        for (Class<? extends NavigationFormat> formatClass : formats) {
            try {
                NavigationFormat format = formatClass.getDeclaredConstructor().newInstance();
                if (includeReadableFormats && format.isSupportsReading() && includeReadFormat(format) ||
                        includeWritableFormats && format.isSupportsWriting())
                    result.add(format);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot instantiate " + formatClass, e);
            }
        }
        return result;
    }

    public List<NavigationFormat> getReadFormats() {
        return getFormatInstances(true, false);
    }

    public List<NavigationFormat> getWriteFormats() {
        return getFormatInstances(false, true);
    }

    private List<NavigationFormat> sortByName(List<NavigationFormat> formats) {
        NavigationFormat[] formatsArray = formats.toArray(new NavigationFormat[0]);
        sort(formatsArray, Comparator.comparing(f -> f.getName().toLowerCase()));
        return asList(formatsArray);
    }

    public List<NavigationFormat> getFormatsSortedByName() {
        return sortByName(getFormatInstances(true, true));
    }

    private List<NavigationFormat> filterByGarble(List<NavigationFormat> formats) {
        List<NavigationFormat> result = new ArrayList<>();
        for(NavigationFormat format : formats) {
            if(!(format instanceof GarbleNavigationFormat))
                result.add(format);
        }
        return result;
    }

    public List<NavigationFormat> getReadFormatsSortedByName() {
        return sortByName(filterByGarble(getReadFormats()));
    }

    public List<NavigationFormat> getWriteFormatsSortedByName() {
        return sortByName(filterByGarble(getWriteFormats()));
    }

    public List<BaseUrlParsingFormat> getUrlParsingFormats() {
        List<BaseUrlParsingFormat> result = new ArrayList<>();
        for(NavigationFormat format : getReadFormats()) {
            if(format instanceof BaseUrlParsingFormat)
                result.add((BaseUrlParsingFormat)format);
        }
        return result;
    }

    public List<NavigationFormat> getWriteFormatsWithPreferredFormats(List<NavigationFormat> preferredFormats) {
        List<NavigationFormat> formats = new ArrayList<>(getWriteFormatsSortedByName());
        formats.removeAll(preferredFormats);
        formats.addAll(0, preferredFormats);
        return formats;
    }

    public List<NavigationFormat> getReadFormatsPreferredByExtension(String preferredExtension) {
        List<NavigationFormat> preferredFormats = new ArrayList<>();
        for(NavigationFormat format : getReadFormats()) {
            if(format.getExtension().equals(preferredExtension))
                preferredFormats.add(format);
        }

        List<NavigationFormat> result = new ArrayList<>(getReadFormats());
        result.removeAll(preferredFormats);
        result.addAll(0, preferredFormats);
        return result;
    }

    public List<NavigationFormat> getReadFormatsWithPreferredFormat(NavigationFormat preferredFormat) {
        List<NavigationFormat> formats = new ArrayList<>(getReadFormats());
        if (preferredFormat != null) {
            formats.remove(preferredFormat);
            formats.add(0, preferredFormat);
        }
        return formats;
    }
}
