package entity;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class GeoData
{
    private long totalResultsCount;

    @JsonbProperty("geonames")
    private List<City> cities;

    public long getTotalResultsCount() {
        return totalResultsCount;
    }

    public void setTotalResultsCount(long totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
