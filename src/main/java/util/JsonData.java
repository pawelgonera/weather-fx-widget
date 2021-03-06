package util;

import entity.*;
import exception.NotFoundDesiredJsonDataException;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import javax.json.bind.Jsonb;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class JsonData
{
    private static JsonData instance = null;

    public static JsonData getInstance()
    {
        if(instance == null)
            instance = new JsonData();

        return instance;
    }

    public List<Data> getJsonWeather(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setCurrentQuery(city, query)))
        {
            String response = connection.connect();
            JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
            data = Optional.ofNullable(jsonBody)
                            .map(JsonBody::getData)
                            .orElseThrow(() -> new NotFoundDesiredJsonDataException("Not found desired data"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public List<Data> getJsonWeather(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city, int quantity)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setForecastQuery(city, quantity, query)))
        {
            String response = connection.connect();
            JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
            for (int i = 0; i < quantity; i++)
                data.add(jsonBody.getData().get(i));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public List<DataDaily> getJsonWeatherForDaily(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city, int quantity)
    {
        List<DataDaily> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setForecastQuery(city, quantity, query)))
        {
            String response = connection.connect();
            JsonBodyDaily jsonBody = jsonb.fromJson(response, JsonBodyDaily.class);
            System.out.println(jsonBody.getData().size());
            for (int i = 0; i < quantity; i++)
                data.add(jsonBody.getData().get(i));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }


}
