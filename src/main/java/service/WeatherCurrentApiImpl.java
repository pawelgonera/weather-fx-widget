package service;

import api.WeatherCurrentApi;
import entity.Data;
import get.factory.HttpConnectFactory;
import util.JsonData;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;

public class WeatherCurrentApiImpl implements WeatherCurrentApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/current?city=%s&key=%s";
    private JsonData jsonData;
    private HttpConnectFactory httpConnectionFactory;
    private Jsonb jsonb;

    public WeatherCurrentApiImpl()
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
    }

    public WeatherCurrentApiImpl(HttpConnectFactory httpConnectionFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectionFactory = httpConnectionFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    @Override
    public double getTemperature(String city)
    {
        List<Data> data = jsonData.getJson(httpConnectionFactory, jsonb, QUERY, city);

        return data.stream()
                    .mapToDouble(Data::getTemperature)
                    .sum();
    }
}
