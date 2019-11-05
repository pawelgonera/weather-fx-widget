package api;

import java.util.List;
import java.util.OptionalInt;

public interface GeoData
{
    List<Long> getDataId();
    List<String> getCityName();
    List<String> getCountryCode();
    List<String> getCountryName();
}
