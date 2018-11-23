package service;

import api.WeatherHourlyForecastApi;
import entity.Data;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import util.JsonData;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherHourlyForecastApiImpl implements WeatherHourlyForecastApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/forecast/hourly?city=%s&key=%s&hours=%d";
    private HttpConnection connection;
    private Jsonb jsonb;
    private int hours;

    public WeatherHourlyForecastApiImpl(String city, int hours)
    {
        this(HttpConnectFactory.getConnection(QueryFactory.setForecastQuery(city, hours, QUERY)), JsonbBuilder.create());
        this.hours = hours;
    }

    public WeatherHourlyForecastApiImpl(HttpConnection connection, Jsonb jsonb)
    {
        this.connection = connection;
        this.jsonb = jsonb;
    }

    @Override
    public List<Double> getTemperatureForecast()
    {
        List<Data> data = JsonData.getJson(connection, jsonb, hours);
        return data.stream()
                    .map(Data::getTemperature)
                    .collect(Collectors.toList());
    }
}
