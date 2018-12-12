package service;

import api.GeoData;
import util.CitiesFile;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GeoDataImpl implements GeoData
{
    private static GeoDataImpl instance = null;

    private List<String[]> geoData;

    private GeoDataImpl()
    {
        geoData = new LinkedList<>();
    }

    public static GeoDataImpl getInstance()
    {
        if(instance == null)
            instance = new GeoDataImpl();

        return instance;
    }


    @Override
    public List<String> getCityName()
    {
        geoData = CitiesFile.getGeoData();
        return geoData.stream()
                            .map(strings -> strings[1])
                            .collect(Collectors.toList());

        //for(String[] elements : geoData)
            //citiesList.add(elements[1]);
    }
}
