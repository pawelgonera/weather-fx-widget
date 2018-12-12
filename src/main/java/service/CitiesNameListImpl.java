package service;

import api.CitiesNamesList;
import entity.Cities;
import exception.NotFoundDesiredJsonDataException;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CitiesNameListImpl implements CitiesNamesList
{
    private static CitiesNameListImpl instance = null;
    private JsonData jsonData = JsonData.getInstance();
    private Jsonb jsonb;
    private List<Cities> citiesList;

    public static CitiesNameListImpl getInstance()
    {
        if(instance == null)
            instance = new CitiesNameListImpl();

        return instance;
    }

    /*
    private CitiesNameListImpl()
    {
        jsonb = JsonbBuilder.create();
        getJsonCities(jsonb);
    }

    private void getJsonCities(Jsonb jsonb)
    {
        citiesList = jsonData.getJsonCities(jsonb);
    }
    */

    private NotFoundDesiredJsonDataException newRunTimeException()
    {
        return new NotFoundDesiredJsonDataException("Not found any desired value");
    }

    @Override
    public List<String> getCityName()
    {
        return citiesList.stream()
                            .map(Cities::getCityName)
                            .collect(Collectors.toList());
    }

    @Override
    public List<String> getCountryCode() {
        return null;
    }

    @Override
    public List<String> getCountryName() {
        return null;
    }

    @Override
    public List<String> getStateName()
    {
        return citiesList.stream()
                            .map(Cities::getStateName)
                            .collect(Collectors.toList());
    }
}
