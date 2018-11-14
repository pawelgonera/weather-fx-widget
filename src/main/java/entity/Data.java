package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Data
{
    //private DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh");
    @JsonProperty("wind_cdir")
    private String abbreviatedWindDirection;

    @JsonProperty("rh")
    private int relativeHumidity;

    @JsonProperty("pod")
    private String partOfTheDay;

    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("pres")
    private double pressure;

    @JsonProperty("timezone")
    private String timmeZone;

    @JsonProperty("ob_time")
    private LocalDateTime lastObservationTime;

    @JsonProperty("country_code")
    private String countryAbbreviation;

    @JsonProperty("clouds")
    private int cloudCoverage;

    @JsonProperty("vis")
    private int visibility;

    @JsonProperty("wind_spd")
    private double windSpeed;

    @JsonProperty("wind_cdir_full")
    private String verbalWindDirection;

    @JsonProperty("app_temp")
    private double apparentTemperature;

    @JsonProperty("state_code")
    private String stateAbbreviation;

    @JsonProperty("ts")
    private long lastObservationTimeUnixTimestamp;

    @JsonProperty("h_angle")
    private int solarHourAngle;

    @JsonProperty("dewpt")
    private double dewPoint;

    @JsonProperty("weather")
    private List<Weather> weather;

    @JsonProperty("uv")
    private int UVIndex;

    @JsonProperty("station")
    private String sourceStationID;

    @JsonProperty("wind_dir")
    private int windDirection;

    @JsonProperty("elev_angle")
    private int solarElevationAngle;

    @JsonProperty("datetime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-hh")
    private LocalDateTime currentCycleHour;

    @JsonProperty("precip")
    private int accumulatedLiquidEquivalentPrecipitation;

    @JsonProperty("snow")
    private int accumulatedSnowfall;

    @JsonProperty("ghi")
    private double globalHorizontalSolarIrradiance;

    @JsonProperty("dni")
    private int directNormalSolarIrradiance;

    @JsonProperty("dhi")
    private int diffuseHorizontalSolarIrradiance;

    @JsonProperty("solar_rad")
    private int estimatedSolarRadiation;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("sunrise")
    private LocalTime sunriseTime;

    @JsonProperty("sunset")
    private LocalTime sunSet;

    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("slp")
    private double seaLevelPressure;

    public Data()
    {

    }

    public String getAbbreviatedWindDirection() {
        return abbreviatedWindDirection;
    }

    public void setAbbreviatedWindDirection(String abbreviatedWindDirection) {
        this.abbreviatedWindDirection = abbreviatedWindDirection;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getTimmeZone() {
        return timmeZone;
    }

    public void setTimmeZone(String timmeZone) {
        this.timmeZone = timmeZone;
    }

    public LocalDateTime getLastObservationTime() {
        return lastObservationTime;
    }

    public void setLastObservationTime(LocalDateTime lastObservationTime) {
        this.lastObservationTime = lastObservationTime;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public int getCloudCoverage() {
        return cloudCoverage;
    }

    public void setCloudCoverage(int cloudCoverage) {
        this.cloudCoverage = cloudCoverage;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getVerbalWindDirection() {
        return verbalWindDirection;
    }

    public void setVerbalWindDirection(String verbalWindDirection) {
        this.verbalWindDirection = verbalWindDirection;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public long getLastObservationTimeUnixTimestamp() {
        return lastObservationTimeUnixTimestamp;
    }

    public void setLastObservationTimeUnixTimestamp(long lastObservationTimeUnixTimestamp) {
        this.lastObservationTimeUnixTimestamp = lastObservationTimeUnixTimestamp ;
    }

    public int getSolarHourAngle() {
        return solarHourAngle;
    }

    public void setSolarHourAngle(int solarHourAngle) {
        this.solarHourAngle = solarHourAngle;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public int getUVIndex() {
        return UVIndex;
    }

    public void setUVIndex(int UVIndex) {
        this.UVIndex = UVIndex;
    }

    public String getSourceStationID() {
        return sourceStationID;
    }

    public void setSourceStationID(String sourceStationID) {
        this.sourceStationID = sourceStationID;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getSolarElevationAngle() {
        return solarElevationAngle;
    }

    public void setSolarElevationAngle(int solarElevationAngle) {
        this.solarElevationAngle = solarElevationAngle;
    }

    public LocalDateTime getCurrentCycleHour() {
        return currentCycleHour;
    }

    public void setCurrentCycleHour(LocalDateTime currentCycleHour) {
        this.currentCycleHour = currentCycleHour;
    }

    public int getAccumulatedLiquidEquivalentPrecipitation() {
        return accumulatedLiquidEquivalentPrecipitation;
    }

    public void setAccumulatedLiquidEquivalentPrecipitation(int accumulatedLiquidEquivalentPrecipitation) {
        this.accumulatedLiquidEquivalentPrecipitation = accumulatedLiquidEquivalentPrecipitation;
    }

    public int getAccumulatedSnowfall() {
        return accumulatedSnowfall;
    }

    public void setAccumulatedSnowfall(int accumulatedSnowfall) {
        this.accumulatedSnowfall = accumulatedSnowfall;
    }

    public double getGlobalHorizontalSolarIrradiance() {
        return globalHorizontalSolarIrradiance;
    }

    public void setGlobalHorizontalSolarIrradiance(double globalHorizontalSolarIrradiance) {
        this.globalHorizontalSolarIrradiance = globalHorizontalSolarIrradiance;
    }

    public int getDirectNormalSolarIrradiance() {
        return directNormalSolarIrradiance;
    }

    public void setDirectNormalSolarIrradiance(int directNormalSolarIrradiance) {
        this.directNormalSolarIrradiance = directNormalSolarIrradiance;
    }

    public int getDiffuseHorizontalSolarIrradiance() {
        return diffuseHorizontalSolarIrradiance;
    }

    public void setDiffuseHorizontalSolarIrradiance(int diffuseHorizontalSolarIrradiance) {
        this.diffuseHorizontalSolarIrradiance = diffuseHorizontalSolarIrradiance;
    }

    public int getEstimatedSolarRadiation() {
        return estimatedSolarRadiation;
    }

    public void setEstimatedSolarRadiation(int estimatedSolarRadiation) {
        this.estimatedSolarRadiation = estimatedSolarRadiation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalTime getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(LocalTime sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public LocalTime getSunSet() {
        return sunSet;
    }

    public void setSunSet(LocalTime sunSet) {
        this.sunSet = sunSet;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }
}
