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
    private HttpConnectFactory httpConnectFactory;
    private QueryFactory queryFactory;

    public List<Data> getJson(Jsonb jsonb, String query, String city, int hours)
    {
        List<Data> data = new LinkedList<>();
        try(HttpConnection connection = httpConnectFactory.getConnection(queryFactory.setCurrentQuery(city,  query)))
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
