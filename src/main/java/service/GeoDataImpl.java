package service;

import api.GeoData;
import util.CitiesFile;

import java.util.List;
import java.util.stream.Collectors;

public class GeoDataImpl implements GeoData
{
    private static GeoDataImpl instance = null;

    private List<String[]> geoData;

    private CitiesFile file = CitiesFile.getInstance();

    private GeoDataImpl()
    {
        geoData = file.getGeoData();
    }

    public static GeoDataImpl getInstance()
    {
        if(instance == null)
            instance = new GeoDataImpl();

        return instance;
    }

    @Override
    public List<Long> getDataId()
    {
        return geoData.stream()
                        .map(value -> Long.parseLong(value[0]))
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getCityName()
    {
        return geoData.stream()
                        .map(strings -> strings[1])
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getCountryCode()
    {

        return geoData.stream()
                        .map(strings -> strings[5])
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getCountryName()
    {
        return geoData.stream()
                .map(strings -> strings[6])
                .collect(Collectors.toList());
    }
}
