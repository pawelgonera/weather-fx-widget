package entity;

import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.util.List;

public class JsonBodyDaily
{
    @JsonbProperty("data")
    private List<DataDaily> data;

    @JsonbProperty("city_name")
    private String cityName;

    @JsonbProperty("country_code")
    private String countryAbbreviation;

    @JsonbProperty("state_code")
    private String stateAbbreviation;

    @JsonbProperty("timezone")
    private String localTimezone;

    @JsonbProperty("lat")
    private BigDecimal latitude;

    @JsonbProperty("lon")
    private BigDecimal longitude;

    public List<DataDaily> getData()
    {
        return data;
    }

    public void setData(List<DataDaily> data) {
        this.data = data;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLocalTimezone() {
        return localTimezone;
    }

    public void setLocalTimezone(String localTimezone) {
        this.localTimezone = localTimezone;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
