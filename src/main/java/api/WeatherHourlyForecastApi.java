package api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.TimeZone;

public interface WeatherHourlyForecastApi
{
    List<BigDecimal> getTemperatureForecast();
    List<String> getAbbreviatedWindDirection();
    List<Integer> getHumidity();
    List<Double> getPressure();
    List<Integer> getCloudsCoverage();
    List<Double> getVisibility();
    List<Double> getWindSpeed();
    List<Double> getApparentTemperature();
    List<Double> getDewPoint();
    List<Double> getUV();
    List<LocalDateTime> getDateTime();
    List<Double> getAccumulatedLiquidEquivalentPrecipitation();
    List<Double> getAccumulatedSnowfall();
    List<String> getCityName();
    List<String> getWeatherIconCode();
    List<String> getWeatherCode();
    List<String> getDescription();

}

