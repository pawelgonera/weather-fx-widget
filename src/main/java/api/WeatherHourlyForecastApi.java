package api;

import java.util.List;

public interface WeatherHourlyForecastApi
{
    List<Double> getTemperatureForecast(String city, int hours);
}

