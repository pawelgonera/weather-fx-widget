package service;

import api.WeatherHourlyForecastApi;
import entity.Data;
import get.factory.HttpConnectFactory;
import util.JsonData;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherHourlyForecastApiImpl implements WeatherHourlyForecastApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/forecast/hourly?city=%s&key=%s&hours=%d";
    private HttpConnectFactory httpConnectFactory;
    private JsonData jsonData;
    private Jsonb jsonb;

    public WeatherHourlyForecastApiImpl()
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
    }

    public WeatherHourlyForecastApiImpl(HttpConnectFactory httpConnectFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectFactory = httpConnectFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    @Override
    public List<Double> getTemperatureForecast(String city, int hours)
    {
        List<Data> data = jsonData.getJson(httpConnectFactory, jsonb, QUERY, city, hours);
        return data.stream()
                    .map(Data::getTemperature)
                    .collect(Collectors.toList());
    }
}
