package service;

import api.WeatherCurrentApi;
import entity.Data;
import entity.JsonBody;
import entity.Weather;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import util.ApiKey;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class WeatherCurrentApiImpl implements WeatherCurrentApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/current?city=%s&key=%s";

    private HttpConnection connection;
    private Jsonb jsonb;

    public WeatherCurrentApiImpl(String city)
    {
        this(HttpConnectFactory.getConnection(QueryFactory.setCurrentQuery(city, QUERY)), JsonbBuilder.create());
    }

    public WeatherCurrentApiImpl(HttpConnection connection, Jsonb jsonb)
    {
        this.connection = connection;
        this.jsonb = jsonb;
    }

    @Override
    public double getTemperature()
    {
        List<Data> data = JsonData.getJson(connection, jsonb, 1);

        return data.stream().mapToDouble(Data::getTemperature).sum();
    }
}
