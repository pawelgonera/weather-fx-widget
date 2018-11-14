package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather
{
    @JsonProperty("icon")
    private String weatherIconCode;
    @JsonProperty("code")
    private String weatherCode;
    @JsonProperty("description")
    private String textWeatherDescription;

    public Weather()
    {

    }

    public String getWeatherIconCode() {
        return weatherIconCode;
    }

    public void setWeatherIconCode(String weatherIconCode) {
        this.weatherIconCode = weatherIconCode;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getTextWeatherDescription() {
        return textWeatherDescription;
    }

    public void setTextWeatherDescription(String textWeatherDescription) {
        this.textWeatherDescription = textWeatherDescription;
    }
}

