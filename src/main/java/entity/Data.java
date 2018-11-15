package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Data
{
    //private DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh");
    @JsonbProperty("wind_cdir")
    private String abbreviatedWindDirection;

    @JsonbProperty("rh")
    private double relativeHumidity;

    @JsonbProperty("pod")
    private String partOfTheDay;

    @JsonbProperty("lon")
    private BigDecimal longitude;

    @JsonbProperty("pres")
    private double pressure;

    @JsonbProperty("timezone")
    private String timmeZone;

    @JsonbProperty("ob_time")
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastObservationTime;

    @JsonbProperty("country_code")
    private String countryAbbreviation;

    @JsonbProperty("clouds")
    private double cloudCoverage;

    @JsonbProperty("vis")
    private double visibility;

    @JsonbProperty("wind_spd")
    private double windSpeed;

    @JsonbProperty("wind_cdir_full")
    private String verbalWindDirection;

    @JsonbProperty("app_temp")
    private double apparentTemperature;

    @JsonbProperty("state_code")
    private String stateAbbreviation;

    @JsonbProperty("ts")
    private double lastObservationTimeUnixTimestamp;

    @JsonbProperty("h_angle")
    private double solarHourAngle;

    @JsonbProperty("dewpt")
    private double dewPoint;

    @JsonbProperty("weather")
    private Weather weather;

    @JsonbProperty("uv")
    private double UVIndex;

    @JsonbProperty("station")
    private String sourceStationID;

    @JsonbProperty("wind_dir")
    private double windDirection;

    @JsonbProperty("elev_angle")
    private double solarElevationAngle;

    @JsonbProperty("datetime")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:HH")
    @JsonbDateFormat(value = "yyyy-MM-dd:HH")
    private LocalDateTime currentCycleHour;

    @JsonbProperty("precip")
    private double accumulatedLiquidEquivalentPrecipitation;

    @JsonbProperty("snow")
    private double accumulatedSnowfall;

    @JsonbProperty("ghi")
    private double globalHorizontalSolarIrradiance;

    @JsonbProperty("dni")
    private double directNormalSolarIrradiance;

    @JsonbProperty("dhi")
    private double diffuseHorizontalSolarIrradiance;

    @JsonbProperty("solar_rad")
    private double estimatedSolarRadiation;

    @JsonbProperty("city_name")
    private String cityName;

    @JsonbProperty("sunrise")
    private LocalTime sunriseTime;

    @JsonbProperty("sunset")
    private LocalTime sunSet;

    @JsonbProperty("temp")
    private double temperature;

    @JsonbProperty("lat")
    private BigDecimal latitude;

    @JsonbProperty("slp")
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

    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
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

    public double getCloudCoverage() {
        return cloudCoverage;
    }

    public void setCloudCoverage(double cloudCoverage) {
        this.cloudCoverage = cloudCoverage;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
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

    public double getLastObservationTimeUnixTimestamp() {
        return lastObservationTimeUnixTimestamp;
    }

    public void setLastObservationTimeUnixTimestamp(double lastObservationTimeUnixTimestamp) {
        this.lastObservationTimeUnixTimestamp = lastObservationTimeUnixTimestamp ;
    }

    public double getSolarHourAngle() {
        return solarHourAngle;
    }

    public void setSolarHourAngle(double solarHourAngle) {
        this.solarHourAngle = solarHourAngle;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public double getUVIndex() {
        return UVIndex;
    }

    public void setUVIndex(double UVIndex) {
        this.UVIndex = UVIndex;
    }

    public String getSourceStationID() {
        return sourceStationID;
    }

    public void setSourceStationID(String sourceStationID) {
        this.sourceStationID = sourceStationID;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getSolarElevationAngle() {
        return solarElevationAngle;
    }

    public void setSolarElevationAngle(double solarElevationAngle) {
        this.solarElevationAngle = solarElevationAngle;
    }

    public LocalDateTime getCurrentCycleHour() {
        return currentCycleHour;
    }

    public void setCurrentCycleHour(LocalDateTime currentCycleHour) {
        this.currentCycleHour = currentCycleHour;
    }

    public double getAccumulatedLiquidEquivalentPrecipitation() {
        return accumulatedLiquidEquivalentPrecipitation;
    }

    public void setAccumulatedLiquidEquivalentPrecipitation(double accumulatedLiquidEquivalentPrecipitation) {
        this.accumulatedLiquidEquivalentPrecipitation = accumulatedLiquidEquivalentPrecipitation;
    }

    public double getAccumulatedSnowfall() {
        return accumulatedSnowfall;
    }

    public void setAccumulatedSnowfall(double accumulatedSnowfall) {
        this.accumulatedSnowfall = accumulatedSnowfall;
    }

    public double getGlobalHorizontalSolarIrradiance() {
        return globalHorizontalSolarIrradiance;
    }

    public void setGlobalHorizontalSolarIrradiance(double globalHorizontalSolarIrradiance) {
        this.globalHorizontalSolarIrradiance = globalHorizontalSolarIrradiance;
    }

    public double getDirectNormalSolarIrradiance() {
        return directNormalSolarIrradiance;
    }

    public void setDirectNormalSolarIrradiance(double directNormalSolarIrradiance) {
        this.directNormalSolarIrradiance = directNormalSolarIrradiance;
    }

    public double getDiffuseHorizontalSolarIrradiance() {
        return diffuseHorizontalSolarIrradiance;
    }

    public void setDiffuseHorizontalSolarIrradiance(double diffuseHorizontalSolarIrradiance) {
        this.diffuseHorizontalSolarIrradiance = diffuseHorizontalSolarIrradiance;
    }

    public double getEstimatedSolarRadiation() {
        return estimatedSolarRadiation;
    }

    public void setEstimatedSolarRadiation(double estimatedSolarRadiation) {
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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }
}
