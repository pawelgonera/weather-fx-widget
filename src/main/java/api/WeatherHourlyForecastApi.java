package api;

import entity.Data;

import java.util.List;

public interface WeatherHourlyForecastApi
{
    List<Data> getTemperatureForecast();
}

