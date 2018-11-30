package util;

import entity.City;
import entity.Data;
import entity.GeoData;
import entity.JsonBody;
import exception.NotFoundDesiredJsonDataException;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import javax.json.bind.Jsonb;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class JsonData
{
    public List<Data> getJsonWeather(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setCurrentQuery(city, query)))
        {
            String response = connection.connect();
            JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
            //data.add(jsonBody.getData().get(0));
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

    public List<Data> getJsonWeather(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city, int hours)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setForecastQuery(city, hours, query)))
        {
            String response = connection.connect();
            JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
            for (int i = 0; i < hours; i++)
                data.add(jsonBody.getData().get(i));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public List<City> getJsonCities(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String countryCode)
    {
        List<City> cityList = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setCityNamesQuery(countryCode, query)))
        {
            String response = connection.connect();
            GeoData geoData = jsonb.fromJson(response, GeoData.class);
            for(int i = 0; i < 1000; i++)
                cityList.add(geoData.getCities().get(i));
        }

        return cityList;
    }

}
