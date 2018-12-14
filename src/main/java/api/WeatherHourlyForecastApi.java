package api;

import java.math.BigDecimal;
import java.util.List;

public interface WeatherHourlyForecastApi
{
    List<BigDecimal> getTemperatureForecast(String city, int hours);
}

