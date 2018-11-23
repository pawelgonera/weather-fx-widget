package util;

import entity.Data;
import entity.JsonBody;
import get.HttpConnection;

import javax.json.bind.Jsonb;
import java.util.LinkedList;
import java.util.List;

public class JsonData
{
    public static List<Data> getJson(HttpConnection connection, Jsonb jsonb, int hours)
    {
        String response = connection.connect();
        JsonBody jsonBody = jsonb.fromJson(response, JsonBody.class);
        List<Data> data = new LinkedList<>();
        for(int i = 0; i < hours; i++)
            data.add(jsonBody.getData().get(i));

        return data;
    }
}
