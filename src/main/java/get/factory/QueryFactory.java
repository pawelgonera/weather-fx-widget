package get.factory;

import util.ApiKey;


public class QueryFactory
{
    private ApiKey apiKey = ApiKey.getInstance();

    public String setCurrentQuery(String city, String query)
    {
        StringBuilder response = new StringBuilder();

        response.append(String.format(query, city, apiKey.getApiKey()));

        return response.toString();
    }

    public String setForecastQuery(String city, int hours, String query)
    {
        StringBuilder response = new StringBuilder();

        response.append(String.format(query, city, apiKey.getApiKey(), hours));

        return response.toString();
    }

}
