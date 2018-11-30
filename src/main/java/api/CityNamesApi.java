package api;

import java.util.List;

public interface CityNamesApi
{
    String getLongitude();
    String getLagitude();
    long getPopulation();
    List<String> getCityName();
}
