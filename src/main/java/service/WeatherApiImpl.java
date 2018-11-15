package service;

import api.WeatherApi;
import entity.Data;
import entity.JsonBody;
import entity.Weather;
import get.HttpConnection;
import util.ApiKey;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class WeatherApiImpl implements WeatherApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/current?city=%s&key=%s";

    private HttpConnection connection;
    private Jsonb jsonb;

    public WeatherApiImpl(String city)
    {
        this(new HttpConnection(setQUERY(city)), JsonbBuilder.create());
    }

    public WeatherApiImpl(HttpConnection connection, Jsonb jsonb)
    {
        this.connection = connection;
        this.jsonb = jsonb;
    }


    private static String setQUERY(String city)
    {
        StringBuilder response = new StringBuilder();
        try
        {
            response.append(String.format(QUERY, city, ApiKey.getApiKey()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    @Override
    public double getTemperature()
    {
        String response = connection.connect();
        //System.out.println(response);
        JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
        Data data = jsonBody.getData().get(0);
        Weather weather = data.getWeather();
        //String weatherDescription = weather.getTextWeatherDescription();
        return data.getTemperature();

        //return weatherDescription;
    }
}
