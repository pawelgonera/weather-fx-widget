package get.factory;

import util.ApiKey;
import util.UserNameApi;

import java.io.FileNotFoundException;

public class QueryFactory
{
    public String setCurrentQuery(String city, String query)
    {
        StringBuilder response = new StringBuilder();
        try
        {
            response.append(String.format(query, city, ApiKey.getApiKey()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public String setForecastQuery(String city, int hours, String query)
    {
        StringBuilder response = new StringBuilder();
        try
        {
            response.append(String.format(query, city, ApiKey.getApiKey(), hours));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public String setCityNamesQuery(String countryCode, String query)
    {
        StringBuilder response = new StringBuilder();
        try
        {
            response.append(String.format(query, countryCode, UserNameApi.getUserName()));
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return response.toString();
    }
}
