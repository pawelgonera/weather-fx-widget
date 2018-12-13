package service;

import api.GeoData;
import exception.NotFoundDesiredJsonDataException;
import util.CitiesFile;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GeoDataImpl implements GeoData
{
    private static GeoDataImpl instance = null;

    private List<String[]> geoData;

    private GeoDataImpl()
    {
        geoData = CitiesFile.getGeoData();
    }


    public static GeoDataImpl getInstance()
    {
        if(instance == null)
            instance = new GeoDataImpl();

        return instance;
    }

    private NotFoundDesiredJsonDataException newRunTimeException()
    {
        return new NotFoundDesiredJsonDataException("Not found any desired value");
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

        //for(String[] elements : geoData)
            //citiesList.add(elements[1]);
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
