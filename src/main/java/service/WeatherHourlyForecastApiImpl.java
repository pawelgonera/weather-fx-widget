package service;

import api.WeatherHourlyForecastApi;
import entity.Data;
import entity.JsonBody;
import get.HttpConnection;
import util.ApiKey;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class WeatherHourlyForecastApiImpl implements WeatherHourlyForecastApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/forecast/hourly?city=%s&key=%s&hours=%d";

    private HttpConnection connection;
    private Jsonb jsonb;
    private int hours;

    public WeatherHourlyForecastApiImpl(String city, int hours)
    {
        this(new HttpConnection(setQUERY(city, hours)), JsonbBuilder.create());
        this.hours = hours;
    }

    public WeatherHourlyForecastApiImpl(HttpConnection connection, Jsonb jsonb)
    {
        this.connection = connection;
        this.jsonb = jsonb;
    }

    private static String setQUERY(String city, int hours)
    {
        StringBuilder response = new StringBuilder();
        try
        {
            response.append(String.format(QUERY, city, ApiKey.getApiKey(), hours));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return response.toString();
    }


    @Override
    public List<Data> getTemperatureForecast()
    {
        String response = connection.connect();
        JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
        List<Data> datas = new LinkedList<>();
        for(int i = 0; i < hours; i++)
            datas.add(jsonBody.getData().get(i));

        return datas;
    }
}
