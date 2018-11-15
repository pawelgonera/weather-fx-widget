package entity;

import javax.json.bind.annotation.JsonbProperty;

public class Weather
{
    @JsonbProperty("icon")
    private String weatherIconCode;
    @JsonbProperty("code")
    private String weatherCode;
    @JsonbProperty("description")
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

