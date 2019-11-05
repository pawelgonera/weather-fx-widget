package service;

import api.WeatherDailyForecastApi;
import entity.Data;
import entity.DataDaily;
import entity.Weather;
import get.factory.HttpConnectFactory;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherDailyForecastImpl implements WeatherDailyForecastApi
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/forecast/daily?city=%s&key=%s&days=%d&lang=pl";
    private HttpConnectFactory httpConnectFactory;
    private JsonData jsonData;
    private Jsonb jsonb;
    private List<DataDaily> apiData;
    private String cityNameRequest;
    private int days;

    public WeatherDailyForecastImpl(String cityNameRequest, int days)
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
        this.cityNameRequest = cityNameRequest;
        this.days = days;
        getApiData();
    }

    public WeatherDailyForecastImpl(HttpConnectFactory httpConnectFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectFactory = httpConnectFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    private void getApiData()
    {
        apiData = jsonData.getJsonWeatherForDaily(httpConnectFactory, jsonb, QUERY, cityNameRequest, days);
    }

    @Override
    public List<BigDecimal> getMaxTemperatureForecast()
    {
        return apiData.stream()
                        .map(DataDaily::getMaxTemperature)
                        .collect(Collectors.toList());
    }

    @Override
    public List<BigDecimal> getMinTemperatureForecast()
    {
        return apiData.stream()
                        .map(DataDaily::getMinTemperature)
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> getAbbreviatedWindDirection()
    {
        return apiData.stream()
                .map(DataDaily::getAbbreviatedWindDirection)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getHumidity()
    {
        return apiData.stream()
                .mapToInt(DataDaily::getRelativeHumidity)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getPressure()
    {
        return apiData.stream()
                .mapToDouble(DataDaily::getPressure)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getWindSpeed()
    {
        return apiData.stream()
                .mapToDouble(DataDaily::getWindSpeed)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getUV()
    {
        return apiData.stream()
                .mapToDouble(DataDaily::getUVIndex)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<LocalDate> getDateTime()
    {
        //System.out.println("data " + apiData.get(0).getValidDate());
        return apiData.stream()
                .map(DataDaily::getValidDate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getAccumulatedLiquidEquivalentPrecipitation()
    {
        return apiData.stream()
                .mapToDouble(DataDaily::getAccumulatedLiquidEquivalentPrecipitation)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getAccumulatedSnowfall()
    {
        return apiData.stream()
                .mapToDouble(DataDaily::getAccumulatedSnowfall)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCityName()
    {
        return apiData.stream()
                .map(DataDaily::getCityName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWeatherIconCode()
    {
        return apiData.stream()
                .map(DataDaily::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getWeatherIconCode)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWeatherCode()
    {
        return apiData.stream()
                .map(DataDaily::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getWeatherCode)
                .collect(Collectors.toList());

    }

    @Override
    public List<String> getDescription()
    {
        return apiData.stream()
                .map(DataDaily::getWeather)
                .collect(Collectors.toList())
                .stream()
                .map(Weather::getTextWeatherDescription)
                .collect(Collectors.toList());
    }
}
