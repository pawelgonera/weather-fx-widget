package api;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

public interface WeatherCurrentApi
{
    double getTemperature();
    String getWindDirection();
    String getAabbreviatedWindDirection();
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
}
