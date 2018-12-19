package service;

import api.WeatherFewDailyForecast;
import entity.Data;
import entity.Weather;
import get.factory.HttpConnectFactory;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherFewDailyForecastImpl implements WeatherFewDailyForecast
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/forecast/3hourly?city=%s&key=%s&days=%d&lang=en";
    private HttpConnectFactory httpConnectFactory;
    private JsonData jsonData;
    private Jsonb jsonb;
    private List<Data> apiData;
    private String cityNameRequest;
    private int days;

    public WeatherFewDailyForecastImpl(String cityNameRequest, int days)
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
        this.cityNameRequest = cityNameRequest;
        this.days = days;
        getApiData();
    }

    public WeatherFewDailyForecastImpl(HttpConnectFactory httpConnectFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectFactory = httpConnectFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    private void getApiData()
    {
        apiData = jsonData.getJsonWeather(httpConnectFactory, jsonb, QUERY, cityNameRequest, days);
    }
    
    @Override
    public List<BigDecimal> getTemperatureForecast()
    {
        return apiData.stream()
                .map(Data::getTemperature)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getApparentTemperature()
    {
        return apiData.stream()
                .mapToDouble(Data::getApparentTemperature)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getDewPoint()
    {
        return apiData.stream()
                .mapToDouble(Data::getDewPoint)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getWindSpeed()
    {
        return apiData.stream()
                .mapToDouble(Data::getWindSpeed)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAbbreviatedWindDirection()
    {
        return apiData.stream()
                .map(Data::getAbbreviatedWindDirection)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getPressure()
    {
        return apiData.stream()
                .mapToDouble(Data::getPressure)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getHumidity()
    {
        return apiData.stream()
                .mapToInt(Data::getRelativeHumidity)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getAccumulatedLiquidEquivalentPrecipitation()
    {
        return apiData.stream()
                .mapToDouble(Data::getAccumulatedLiquidEquivalentPrecipitation)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getAccumulatedSnowfall()
    {
        return apiData.stream()
                .mapToDouble(Data::getAccumulatedSnowfall)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCityName()
    {
        return apiData.stream()
                .map(Data::getCityName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getCloudsCoverage()
    {
        return apiData.stream()
                .mapToInt(Data::getCloudCoverage)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getVisibility()
    {
        return apiData.stream()
                .mapToDouble(Data::getVisibility)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWeatherIconCode()
    {
        return apiData.stream()
                .map(Data::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getWeatherIconCode)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWeatherCode()
    {
        return apiData.stream()
                .map(Data::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getWeatherCode)
                .collect(Collectors.toList());

    }

    @Override
    public List<String> getDescription()
    {
        return apiData.stream()
                .map(Data::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getTextWeatherDescription)
                .collect(Collectors.toList());
    }


    @Override
    public List<Double> getUV()
    {
        return apiData.stream()
                .mapToDouble(Data::getUVIndex)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<LocalDateTime> getDateTime()
    {
        return apiData.stream()
                .map(Data::getCurrentCycleHour)
                .collect(Collectors.toList());
    }
}
