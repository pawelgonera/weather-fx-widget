package api;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;

public interface WeatherCurrentApi
{
    double getTemperature();
    String getWindDirection();
    String getAabbreviatedWindDirection();
    double getHumidity();
    String getPartOfTheDay();
    double getPressure();
    LocalDateTime getLastObservationTime();
    double getCloudsCoverage();
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
    ZoneId getTimeZone();
}
