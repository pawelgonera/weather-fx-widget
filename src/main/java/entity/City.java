package entity;

import javax.json.bind.annotation.JsonbProperty;

public class City
{
    @JsonbProperty("lng")
    private String longitude;

    @JsonbProperty("lat")
    private String latitude;

    @JsonbProperty("population")
    private long population;

    @JsonbProperty("toponymName")
    private String cityName;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
