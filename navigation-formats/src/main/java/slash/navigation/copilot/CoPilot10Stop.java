package slash.navigation.copilot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import slash.common.type.CompactCalendar;
import slash.navigation.base.BaseNavigationPosition;

// Properties introduced by getters of parent
@JsonIgnoreProperties({"time", "elevation", "description", "longitude", "latitude", "speed"})
public class CoPilot10Stop extends BaseNavigationPosition {

    protected static final double INTEGER_FACTOR = 1000000.0;

    @JsonProperty("Cost")
    public Integer cost;
    @JsonProperty("Time")
    public Integer stopTime;
    @JsonProperty("Loaded")
    public Integer loaded;
    @JsonProperty("OnDuty")
    public Integer onDuty;
    @JsonProperty("Type")
    public Integer type;
    @JsonProperty("TimeZoneOffset")
    public Integer timeZoneOffset;
    @JsonProperty("ActiveDriver")
    public Integer activeDriver;
    @JsonProperty("StopInfo")
    public StopInfo stopInfo;
    @JsonProperty("Warnings")
    public Integer warnings;

    public static class StopInfo{
        @JsonProperty("Name")
        public String name;
        @JsonProperty("Address")
        public String address;
        @JsonProperty("LocalArea")
        public String localArea;
        @JsonProperty("City")
        public String city;
        @JsonProperty("State")
        public String state;
        @JsonProperty("Jurisdiction")
        public String jurisdiction;
        @JsonProperty("Country")
        public String country;
        @JsonProperty("ZipCode")
        public String zipCode;
        @JsonProperty("Region")
        public String region;
        @JsonProperty("Longitude")
        public Integer longitude;
        @JsonProperty("Latitude")
        public Integer latitude;
        @JsonProperty("Version")
        public Integer version;
        @JsonProperty("TimeZone")
        public Integer timeZone;
        @JsonProperty("JurisdictionName")
        public String jurisdictionName;
        @JsonProperty("Grid 0")
        public Integer grid0;
        @JsonProperty("Link 0")
        public Integer link0;
        @JsonProperty("Distance 0")
        public Integer distance0;
        @JsonProperty("Percent 0")
        public Integer percent0;
        @JsonProperty("Grid 1")
        public Long grid1;
        @JsonProperty("Link 1")
        public Integer link1;
        @JsonProperty("Distance 1")
        public Integer distance1;
        @JsonProperty("Percent 1")
        public Integer percent1;
        @JsonProperty("Grid 2")
        public Long grid2;
        @JsonProperty("Link 2")
        public Integer link2;
        @JsonProperty("Distance 2")
        public Integer distance2;
        @JsonProperty("Percent 2")
        public Integer percent2;
        @JsonProperty("Grid 3")
        public Long grid3;
        @JsonProperty("Link 3")
        public Integer link3;
        @JsonProperty("Distance 3")
        public Integer distance3;
        @JsonProperty("Percent 3")
        public Integer percent3;
        @JsonProperty("Direction")
        public Integer direction;
        @JsonProperty("Code")
        public Integer code;
        @JsonProperty("POIType")
        public Integer pOIType;
        @JsonProperty("Type")
        public Integer type;
        @JsonProperty("Size")
        public Integer size;
        @JsonProperty("Show")
        public Integer show;
        @JsonProperty("Sequence")
        public Integer sequence;
        @JsonProperty("VehicleRestricted")
        public boolean vehicleRestricted;
    }

    public CoPilot10Stop() {

    }

    public CoPilot10Stop(Double longitude, Double latitude, Double elevation, Double speed, CompactCalendar time, String description) {
        setLongitude(longitude);
        setLatitude(latitude);
        setDescription(description);
    }

    @Override
    public Double getLongitude() {
        return stopInfo.longitude / INTEGER_FACTOR;
    }

    @Override
    public void setLongitude(Double longitude) {
        stopInfo.longitude = (int) (longitude * INTEGER_FACTOR);
    }

    @Override
    public Double getLatitude() {
        return stopInfo.latitude / INTEGER_FACTOR;
    }

    @Override
    public void setLatitude(Double latitude) {
        stopInfo.latitude = (int) (latitude * INTEGER_FACTOR);
    }

    @Override
    public Double getElevation() {
        return null;
    }

    @Override
    public void setElevation(Double elevation) {
        // nothing to do
    }

    @Override
    public CompactCalendar getTime() {
        return null;
    }

    @Override
    public void setTime(CompactCalendar time) {
        // nothing to do
    }

    @Override
    public Double getSpeed() {
        return null;
    }

    @Override
    public void setSpeed(Double speed) {
        // nothing to do
    }

    @Override
    public String getDescription() {
        if (stopInfo.name != null) {
            return stopInfo.name;
        }
        return (stopInfo.state != null ? stopInfo.state + (stopInfo.zipCode != null ? "-" : " ") : "") +
                (stopInfo.zipCode != null ? stopInfo.zipCode + " " : "") + (stopInfo.city != null ? stopInfo.city : "") +
                (stopInfo.country != null ? ", " + stopInfo.country : "") + (stopInfo.address != null ? ", " + stopInfo.address : "");
    }

    @Override
    public void setDescription(String description) {
        stopInfo.name = description;
    }

}
