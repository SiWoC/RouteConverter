package slash.navigation.copilot;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.FilenameUtils;
import slash.common.type.CompactCalendar;
import slash.navigation.base.BaseRoute;
import slash.navigation.base.RouteCharacteristics;
import slash.navigation.base.SimpleFormat;
import slash.navigation.base.SimpleRoute;
import slash.navigation.bcr.BcrFormat;
import slash.navigation.bcr.BcrRoute;
import slash.navigation.csv.CsvFormat;
import slash.navigation.csv.CsvRoute;
import slash.navigation.excel.ExcelFormat;
import slash.navigation.excel.ExcelRoute;
import slash.navigation.gopal.GoPalRoute;
import slash.navigation.gopal.GoPalRouteFormat;
import slash.navigation.gpx.GpxFormat;
import slash.navigation.gpx.GpxRoute;
import slash.navigation.itn.TomTom5RouteFormat;
import slash.navigation.itn.TomTomPosition;
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

public class CoPilot10Trip {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Options")
    public Options options;
    @JsonProperty("FeatureFlags")
    public List<String> featureFlags;
    @JsonProperty("Stops")
    public List<CoPilot10Stop> stops;
    @JsonProperty("Source")
    public Integer source;
    @JsonProperty("ManagedRouteParentTripActive")
    public boolean managedRouteParentTripActive;
    @JsonProperty("ManagedRouteParentTripID")
    public String managedRouteParentTripID;
    @JsonProperty("CurrentManagedLeg")
    public Integer currentManagedLeg;
    @JsonProperty("IsOutofRoute")
    public boolean isOutofRoute;
    @JsonProperty("TrafficDetourReason")
    public Integer trafficDetourReason;

    public static class Options{
        @JsonProperty("RouteType")
        public Integer routeType;
        @JsonProperty("VehicleType")
        public Integer vehicleType;
        @JsonProperty("HubRouting")
        public Integer hubRouting;
        @JsonProperty("SeqType")
        public Integer seqType;
        @JsonProperty("FavorAvoid")
        public Integer favorAvoid;
        @JsonProperty("DistUnits")
        public Integer distUnits;
        @JsonProperty("RestrTrucks")
        public Integer restrTrucks;
        @JsonProperty("StateOrder")
        public Integer stateOrder;
        @JsonProperty("FerryMiles")
        public Integer ferryMiles;
        @JsonProperty("LoadedCost")
        public Integer loadedCost;
        @JsonProperty("EmptyCost")
        public Integer emptyCost;
        @JsonProperty("FirstStop")
        public Integer firstStop;
        @JsonProperty("HazType")
        public Integer hazType;
        @JsonProperty("BordersOpen")
        public Integer bordersOpen;
        @JsonProperty("CongestionZonesOpen")
        public Integer congestionZonesOpen;
        @JsonProperty("LowEmissionZonesOpen")
        public Integer lowEmissionZonesOpen;
        @JsonProperty("TollAvoid")
        public Integer tollAvoid;
        @JsonProperty("NationalNetwork")
        public Integer nationalNetwork;
        @JsonProperty("53FootRouting")
        public Integer _53FootRouting;
        @JsonProperty("AccessRule")
        public Integer accessRule;
        @JsonProperty("CountriesAsStates")
        public Integer countriesAsStates;
        @JsonProperty("ScenicRoute")
        public Integer scenicRoute;
        @JsonProperty("PropaneRestricted")
        public Integer propaneRestricted;
        @JsonProperty("TollAdjust")
        public Integer tollAdjust;
        @JsonProperty("TollType")
        public Integer tollType;
        @JsonProperty("TollDiscounts")
        public Integer tollDiscounts;
        @JsonProperty("Length")
        public Integer length;
        @JsonProperty("Width")
        public Integer width;
        @JsonProperty("Height")
        public Integer height;
        @JsonProperty("Weight")
        public Integer weight;
        @JsonProperty("WeightPrecise")
        public Integer weightPrecise;
        @JsonProperty("WeightPerAxle")
        public Integer weightPerAxle;
        @JsonProperty("WeightPerAxlePrecise")
        public Integer weightPerAxlePrecise;
        @JsonProperty("UseHighwayOnly")
        public Integer useHighwayOnly;
        @JsonProperty("TollClosed")
        public Integer tollClosed;
        @JsonProperty("FerryClosed")
        public Integer ferryClosed;
        @JsonProperty("RptCurrency")
        public Integer rptCurrency;
        @JsonProperty("RptConvRate")
        public Integer rptConvRate;
        @JsonProperty("Units")
        public Integer units;
        @JsonProperty("NumAxles")
        public Integer numAxles;
        @JsonProperty("RestrTrucksOnly")
        public Integer restrTrucksOnly;
        @JsonProperty("LCV")
        public Integer lCV;
        @JsonProperty("FuelUnit")
        public Integer fuelUnit;
        @JsonProperty("FuelCost")
        public Integer fuelCost;
        @JsonProperty("MaintenenceCostLoaded")
        public Integer maintenenceCostLoaded;
        @JsonProperty("MaintenenceCostEmpty")
        public Integer maintenenceCostEmpty;
        @JsonProperty("CostTimeLoaded")
        public Integer costTimeLoaded;
        @JsonProperty("CostTimeEmpty")
        public Integer costTimeEmpty;
        @JsonProperty("GreenHouseGas")
        public Integer greenHouseGas;
        @JsonProperty("MPGCostLoaded")
        public Integer mPGCostLoaded;
        @JsonProperty("MPGCostEmpty")
        public Integer mPGCostEmpty;
        @JsonProperty("Date")
        public Integer date;
        @JsonProperty("TimeZoneSelected")
        public Integer timeZoneSelected;
        @JsonProperty("DepartArrive")
        public Integer departArrive;
        @JsonProperty("HourFormat")
        public Integer hourFormat;
        @JsonProperty("RoadSpeeds")
        public Integer roadSpeeds;
        @JsonProperty("DisplayRestrictions")
        public Integer displayRestrictions;
        @JsonProperty("TollDiscounts2")
        public Integer tollDiscounts2;
        @JsonProperty("FavorOneWayDivided")
        public Integer favorOneWayDivided;
        @JsonProperty("ElevationAvoid")
        public Integer elevationAvoid;
        @JsonProperty("ElevationAltitudeLimit")
        public Integer elevationAltitudeLimit;
        @JsonProperty("HoursOfService")
        public Integer hoursOfService;
        @JsonProperty("TrailerType")
        public Integer trailerType;
        @JsonProperty("TrailerCount")
        public Integer trailerCount;
        @JsonProperty("TrailerAxleCount")
        public Integer trailerAxleCount;
        @JsonProperty("TrailerHeight")
        public Integer trailerHeight;
        @JsonProperty("TrailerWeight")
        public Integer trailerWeight;
        @JsonProperty("TrailerWeightPrecise")
        public Integer trailerWeightPrecise;
        @JsonProperty("TireCount")
        public Integer tireCount;
        @JsonProperty("PassengerCount")
        public Integer passengerCount;
        @JsonProperty("EmissionType")
        public Integer emissionType;
        @JsonProperty("Hybrid")
        public Integer hybrid;
        @JsonProperty("MinPollution")
        public Integer minPollution;
        @JsonProperty("DisabledEquipped")
        public Integer disabledEquipped;
        @JsonProperty("HOV")
        public Integer hOV;
        @JsonProperty("PersonFee")
        public Integer personFee;
        @JsonProperty("SoftwareVersion")
        public Integer softwareVersion;
        @JsonProperty("GovernorSpeed")
        public Integer governorSpeed;
        @JsonProperty("WrongSideOfStreetCostX1000")
        public Integer wrongSideOfStreetCostX1000;
        @JsonProperty("TOP_UseTrafficClosures")
        public Integer tOP_UseTrafficClosures;
        @JsonProperty("RptTollPaymentTypeEU")
        public Integer rptTollPaymentTypeEU;
        @JsonProperty("UseCustomExchangeRate")
        public Integer useCustomExchangeRate;
        @JsonProperty("UseSites")
        public Integer useSites;
        @JsonProperty("UseHistoricSpeed")
        public Integer useHistoricSpeed;
        @JsonProperty("IntersectionDelay")
        public Integer intersectionDelay;
        @JsonProperty("UltraLowEmissionZonesOpen")
        public Integer ultraLowEmissionZonesOpen;
        @JsonProperty("AvoidCrossStreetTurns")
        public Integer avoidCrossStreetTurns;
        @JsonProperty("GuidanceTrip")
        public Integer guidanceTrip;
        @JsonProperty("CO2EmissionType")
        public Integer cO2EmissionType;
        @JsonProperty("TripUnits")
        public TripUnits tripUnits;
    }

    public static class TripUnits{
        @JsonProperty("Length")
        public Integer length;
        @JsonProperty("Height")
        public Integer height;
        @JsonProperty("Width")
        public Integer width;
        @JsonProperty("Weight")
        public Integer weight;
        @JsonProperty("WeightPerAxle")
        public Integer weightPerAxle;
        @JsonProperty("Speed")
        public Integer speed;
        @JsonProperty("ReportedDistance")
        public Integer reportedDistance;
        @JsonProperty("Volume")
        public Integer volume;
    }

}
