package slash.navigation.copilot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.FilenameUtils;
import slash.common.type.CompactCalendar;
import slash.navigation.base.*;
import slash.navigation.bcr.BcrFormat;
import slash.navigation.bcr.BcrRoute;
import slash.navigation.common.NavigationPosition;
import slash.navigation.csv.CsvFormat;
import slash.navigation.csv.CsvRoute;
import slash.navigation.excel.ExcelFormat;
import slash.navigation.excel.ExcelRoute;
import slash.navigation.gopal.GoPalRoute;
import slash.navigation.gopal.GoPalRouteFormat;
import slash.navigation.gpx.GpxFormat;
import slash.navigation.gpx.GpxRoute;
import slash.navigation.itn.TomTomRoute;
import slash.navigation.itn.TomTomRouteFormat;
import slash.navigation.kml.BaseKmlFormat;
import slash.navigation.kml.KmlRoute;
import slash.navigation.nmea.BaseNmeaFormat;
import slash.navigation.nmea.NmeaRoute;
import slash.navigation.nmn.NmnFormat;
import slash.navigation.nmn.NmnRoute;
import slash.navigation.photo.PhotoFormat;
import slash.navigation.tcx.TcxFormat;
import slash.navigation.tcx.TcxRoute;

import java.util.ArrayList;
import java.util.List;

// Properties introduced by getters of parent
@JsonIgnoreProperties({"format", "characteristics", "name", "positionCount", "positions", "description", "time", "distance"})
public class CoPilot10Root extends BaseRoute<CoPilot10Stop, CoPilot10Format> {

    public static final String DATA_VERSION = "GRD_NT.EU.2024.01.1.2.1.1";
    public static final String SOFTWARE_VERSION = "10.28.1.136";

    @JsonProperty("Data Version:")
    public String dataVersion;
    @JsonProperty("Software Version:")
    public String softwareVersion;
    @JsonProperty("Trip")
    public CoPilot10Trip trip;

    // NoParam Constructor for JSON-mapper
    public CoPilot10Root(){
        super(new CoPilot10Format(), RouteCharacteristics.Route);
    };

    public <P extends NavigationPosition> CoPilot10Root(CoPilot10Format format, RouteCharacteristics characteristics, String name, List<P> positions) {
        super(format, characteristics);
        this.softwareVersion = SOFTWARE_VERSION;
        this.dataVersion = DATA_VERSION;
        this.trip = new CoPilot10Trip();
        this.trip.name = name;
        this.trip.stops = createPositions(positions);
    }

    @Override
    public String getName() {
        if (trip != null && trip.name != null) {
            return FilenameUtils.getBaseName(trip.name);
        } else {
            return null;
        }
    }

    @Override
    public void setName(String name) {
        if (trip == null) {
            this.trip = new CoPilot10Trip();
        }
        this.trip.name = name;
    }

    @Override
    public List<String> getDescription() {
        return null;
    }

    @Override
    public List<CoPilot10Stop> getPositions() {
        if (trip != null && trip.stops != null) {
            return trip.stops;
        } else {
            return null;
        }
    }

    @Override
    public int getPositionCount() {
        if (trip != null && trip.stops != null) {
            return trip.stops.size();
        } else {
            return 0;
        }
    }

    @Override
    public void add(int index, CoPilot10Stop position) {
        if (trip == null) {
            this.trip = new CoPilot10Trip();
        }
        if (trip.stops == null) {
            this.trip.stops = new ArrayList<CoPilot10Stop>();
        }
        this.trip.stops.add(index,position);
    }

    public <P extends NavigationPosition> List<CoPilot10Stop> createPositions(List<P> positions) {
        ArrayList<CoPilot10Stop> stops = new ArrayList<>();
        for (P position : positions) {
            stops.add(new CoPilot10Stop(position.getLongitude(), position.getLatitude(), position.getElevation(), position.getSpeed(), position.getTime(), position.getDescription()));
        }
        return stops;
    }

    @Override
    public CoPilot10Stop createPosition(Double longitude, Double latitude, Double elevation, Double speed, CompactCalendar time, String description) {
        return new CoPilot10Stop(longitude, latitude, elevation, speed, time, description);
    }

    @Override
    protected BcrRoute asBcrFormat(BcrFormat format) {
        return null;
    }

    @Override
    protected CsvRoute asCsvFormat(CsvFormat format) {
        return null;
    }

    @Override
    protected ExcelRoute asExcelFormat(ExcelFormat format) {
        return null;
    }

    @Override
    protected GoPalRoute asGoPalRouteFormat(GoPalRouteFormat format) {
        return null;
    }

    @Override
    protected GpxRoute asGpxFormat(GpxFormat format) {
        return null;
    }

    @Override
    protected SimpleRoute asPhotoFormat(PhotoFormat format) {
        return null;
    }

    @Override
    protected KmlRoute asKmlFormat(BaseKmlFormat format) {
        return null;
    }

    @Override
    protected NmeaRoute asNmeaFormat(BaseNmeaFormat format) {
        return null;
    }

    @Override
    protected NmnRoute asNmnFormat(NmnFormat format) {
        return null;
    }

    @Override
    protected SimpleRoute asSimpleFormat(SimpleFormat format) {
        return null;
    }

    @Override
    protected TcxRoute asTcxFormat(TcxFormat format) {
        return null;
    }

    @Override
    protected TomTomRoute asTomTomRouteFormat(TomTomRouteFormat format) {
        return null;
    }

    // dynamic invoke "as{formatName}" in NavigationFormatConverter
    public CoPilot10Root asCoPilot10Format() {
        return asCoPilot10Format(this);
    }

    public CoPilot10Root asCoPilot10Format(BaseRoute route) {
        return new CoPilot10Root(getFormat(), getCharacteristics(), getName(), route.getPositions());
    }

}
