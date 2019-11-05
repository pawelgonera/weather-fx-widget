package entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DataDaily
{
    @JsonbProperty("wind_gust_spd")
    private double windGustSpeed;

    @JsonbProperty("pop")
    private double probabilityOfPrecipitation;

    @JsonbProperty("snow_depth")
    private double snowDepth;

    @JsonbProperty("wind_cdir")
    private String abbreviatedWindDirection;

    @JsonbProperty("rh")
    private int relativeHumidity;

    @JsonbProperty("pod")
    private String partOfTheDay;

    @JsonbProperty("lon")
    private BigDecimal longitude;

    @JsonbProperty("pres")
    private double pressure;

    public BigDecimal getMaxApparentTemperature() {
        return maxApparentTemperature;
    }

    public void setMaxApparentTemperature(BigDecimal maxApparentTemperature) {
        this.maxApparentTemperature = maxApparentTemperature;
    }

    public BigDecimal getMinApparentTemperature() {
        return minApparentTemperature;
    }

    public void setMinApparentTemperature(BigDecimal minApparentTemperature) {
        this.minApparentTemperature = minApparentTemperature;
    }

    @JsonbProperty("clouds_low")
    private double lowLevelCloudCoverage;

    @JsonbProperty("clouds_mid")
    private double midLevelCloudCoverage;

    @JsonbProperty("clouds_hi")
    private double highLevelCloudCoverage;

    @JsonbProperty("ozone")
    private double averageOzone;

    @JsonbProperty("clouds")
    private int cloudCoverage;

    @JsonbProperty("vis")
    private double visibility;

    @JsonbProperty("wind_spd")
    private double windSpeed;

    @JsonbProperty("wind_cdir_full")
    private String verbalWindDirection;

    @JsonbProperty("ts")
    private double lastObservationTimeUnixTimestamp;

    @JsonbProperty("dewpt")
    private double dewPoint;

    @JsonbProperty("weather")
    private Weather weather;

    @JsonbProperty("uv")
    private double UVIndex;

    @JsonbProperty("wind_dir")
    private double windDirection;

    @JsonbProperty("datetime")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate currentCycleHour;

    @JsonbProperty("valid_date")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate validDate;

    @JsonbProperty("max_temp")
    private BigDecimal maxTemperature;

    @JsonbProperty("min_temp")
    private BigDecimal minTemperature;

    @JsonbProperty("max_dhi")
    private double maxDirectComponentOfSolarRadiation;

    @JsonbProperty("moon_phase")
    private double moonPhaseFraction;

    @JsonbProperty("moonrise_ts")
    private long moonriseTimeUnixTimestamp;

    @JsonbProperty("moonset_ts")
    private long moonsetTimeUnixTimestamp;

    @JsonbProperty("sunrise_ts")
    private long sunriseTimeUnixTimestamp;

    @JsonbProperty("sunset_ts")
    private long sunsetTimeUnixTimestamp;

    @JsonbProperty("app_max_temp")
    private BigDecimal maxApparentTemperature;

    @JsonbProperty("app_min_temp")
    private BigDecimal minApparentTemperature;

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxDirectComponentOfSolarRadiation() {
        return maxDirectComponentOfSolarRadiation;
    }

    public void setMaxDirectComponentOfSolarRadiation(double maxDirectComponentOfSolarRadiation) {
        this.maxDirectComponentOfSolarRadiation = maxDirectComponentOfSolarRadiation;
    }

    public double getMoonPhaseFraction() {
        return moonPhaseFraction;
    }

    public void setMoonPhaseFraction(double moonPhaseFraction) {
        this.moonPhaseFraction = moonPhaseFraction;
    }

    public long getMoonriseTimeUnixTimestamp() {
        return moonriseTimeUnixTimestamp;
    }

    public void setMoonriseTimeUnixTimestamp(long moonriseTimeUnixTimestamp) {
        this.moonriseTimeUnixTimestamp = moonriseTimeUnixTimestamp;
    }

    public long getMoonsetTimeUnixTimestamp() {
        return moonsetTimeUnixTimestamp;
    }

    public void setMoonsetTimeUnixTimestamp(long moonsetTimeUnixTimestamp) {
        this.moonsetTimeUnixTimestamp = moonsetTimeUnixTimestamp;
    }

    public long getSunriseTimeUnixTimestamp() {
        return sunriseTimeUnixTimestamp;
    }

    public void setSunriseTimeUnixTimestamp(long sunriseTimeUnixTimestamp) {
        this.sunriseTimeUnixTimestamp = sunriseTimeUnixTimestamp;
    }

    public long getSunsetTimeUnixTimestamp() {
        return sunsetTimeUnixTimestamp;
    }

    public void setSunsetTimeUnixTimestamp(long sunsetTimeUnixTimestamp) {
        this.sunsetTimeUnixTimestamp = sunsetTimeUnixTimestamp;
    }

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

    @JsonbProperty("temp")
    private BigDecimal temperature;

    @JsonbProperty("lat")
    private BigDecimal latitude;

    @JsonbProperty("slp")
    private double seaLevelPressure;

    public DataDaily()
    {

    }

    public double getWindGustSpeed() {
        return windGustSpeed;
    }

    public void setWindGustSpeed(double windGustSpeed) {
        this.windGustSpeed = windGustSpeed;
    }

    public double getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public void setProbabilityOfPrecipitation(double probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    public double getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(double snowDepth) {
        this.snowDepth = snowDepth;
    }

    public double getLowLevelCloudCoverage() {
        return lowLevelCloudCoverage;
    }

    public void setLowLevelCloudCoverage(double lowLevelCloudCoverage) {
        this.lowLevelCloudCoverage = lowLevelCloudCoverage;
    }

    public double getMidLevelCloudCoverage() {
        return midLevelCloudCoverage;
    }

    public void setMidLevelCloudCoverage(double midLevelCloudCoverage) {
        this.midLevelCloudCoverage = midLevelCloudCoverage;
    }

    public double getHighLevelCloudCoverage() {
        return highLevelCloudCoverage;
    }

    public void setHighLevelCloudCoverage(double highLevelCloudCoverage) {
        this.highLevelCloudCoverage = highLevelCloudCoverage;
    }

    public double getAverageOzone() {
        return averageOzone;
    }

    public void setAverageOzone(double averageOzone) {
        this.averageOzone = averageOzone;
    }

    public String getAbbreviatedWindDirection() {
        return abbreviatedWindDirection;
    }

    public void setAbbreviatedWindDirection(String abbreviatedWindDirection) {
        this.abbreviatedWindDirection = abbreviatedWindDirection;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
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

    public int getCloudCoverage() {
        return cloudCoverage;
    }

    public void setCloudCoverage(int cloudCoverage) {
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

    public double getLastObservationTimeUnixTimestamp() {
        return lastObservationTimeUnixTimestamp;
    }

    public void setLastObservationTimeUnixTimestamp(double lastObservationTimeUnixTimestamp) {
        this.lastObservationTimeUnixTimestamp = lastObservationTimeUnixTimestamp ;
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

    public LocalDate getCurrentCycleHour() {
        return currentCycleHour;
    }

    public void setCurrentCycleHour(LocalDate currentCycleHour) {
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

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
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
