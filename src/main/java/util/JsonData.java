package util;

import entity.Data;
import entity.JsonBody;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import javax.json.bind.Jsonb;
import java.util.LinkedList;
import java.util.List;

public class JsonData
{
    public List<Data> getJson(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(new QueryFactory().setCurrentQuery(city, query)))
        {
            String response = connection.connect();
            JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
            data.add(jsonBody.getData().get(0));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public List<Data> getJson(HttpConnectFactory httpConnectFactory, Jsonb jsonb, String query, String city, int hours)
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

}
