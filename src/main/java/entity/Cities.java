package entity;

import javax.json.bind.annotation.JsonbProperty;

public class Cities
{
    @JsonbProperty("id")
    private long id;
    @JsonbProperty("city_name")
    private String cityName;
    @JsonbProperty("elevation")
    private int elevation;
    @JsonbProperty("state_code")
    private String  stateCode;
    @JsonbProperty("state_name")
    private String stateName;
    @JsonbProperty("country_code")
    private String countryCode;
    @JsonbProperty("country_name")
    private String countryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
