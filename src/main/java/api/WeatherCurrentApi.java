package api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

public interface WeatherCurrentApi
{
    BigDecimal getTemperature();
    String getWindDirection();
    String getAbbreviatedWindDirection();
    int getHumidity();
    String getPartOfTheDay();
    double getPressure();
    LocalDateTime getLastObservationTime();
    int getCloudsCoverage();
    double getVisibility();
    double getWindSpeed();
    double getApparentTemperature();
    double getDewPoint();
    double getUV();
    LocalDateTime getDateTime();
    double getAccumulatedLiquidEquivalentPrecipitation();
    double getAccumulatedSnowfall();
    String getCityName();
    LocalTime getSunrise();
    LocalTime getSunset();
    TimeZone getTimeZone();
    String getWeatherIconCode();
    String getWeatherCode();
    String getDescription();
}
