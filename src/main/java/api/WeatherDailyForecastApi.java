package api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface WeatherDailyForecastApi
{
    List<BigDecimal> getMaxTemperatureForecast();
    List<BigDecimal> getMinTemperatureForecast();
    List<String> getAbbreviatedWindDirection();
    List<Integer> getHumidity();
    List<Double> getPressure();
    List<Double> getWindSpeed();
    List<Double> getUV();
    List<LocalDate> getDateTime();
    List<Double> getAccumulatedLiquidEquivalentPrecipitation();
    List<Double> getAccumulatedSnowfall();
    List<String> getCityName();
    List<String> getWeatherIconCode();
    List<String> getWeatherCode();
    List<String> getDescription();
}
