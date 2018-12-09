package service;

import api.CityNamesApi;
import entity.City;
import get.factory.HttpConnectFactory;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class CityNamesApiImpl //implements CityNamesApi
{
    /*
    private static String QUERY_CITY_NAMES = "http://api.geonames.org/searchJSON?country=%s&maxRows=1000&orderby=population&username=%s";
    private JsonData jsonData;
    private HttpConnectFactory httpConnectFactory;
    private Jsonb jsonb;
    private List<City> apiCity;
    private String countryCodeRequest;

    public CityNamesApiImpl(String countryCodeRequest)
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
        this.countryCodeRequest = countryCodeRequest;
        getApiCity();
    }

    public CityNamesApiImpl(HttpConnectFactory httpConnectFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectFactory = httpConnectFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    private void getApiCity()
    {
        apiCity = jsonData.getJsonCities(httpConnectFactory, jsonb, QUERY_CITY_NAMES, countryCodeRequest);
    }

    @Override
    public String getLongitude() {
        return null;
    }

    @Override
    public String getLagitude() {
        return null;
    }

    @Override
    public long getPopulation() {
        return 0;
    }

    @Override
    public List<String> getCityName()
    {
        return apiCity.stream()
                        .map(City::getCityName)
                        .collect(Collectors.toList());
    }
    */
}
