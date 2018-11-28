package service;

import api.WeatherCurrentApi;
import entity.Data;
import exception.NotFoundDesiredJsonDataException;
import exception.WrongCityNameRequestException;
import get.factory.HttpConnectFactory;
import util.JsonData;
import validator.ClientRequestValidation;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WeatherCurrentApiImpl implements WeatherCurrentApi
{
    private static String QUERY_CURRENT_WEATHER = "https://api.weatherbit.io/v2.0/current?city=%s&lang=pl&key=%s";
    private JsonData jsonData;
    private HttpConnectFactory httpConnectionFactory;
    private Jsonb jsonb;
    private ClientRequestValidation validation;
    private List<Data> apiData = new LinkedList<>();
    private String cityNameRequest;

    public WeatherCurrentApiImpl(String cityNameRequest)
    {
        this(new HttpConnectFactory(), JsonbBuilder.create(), new JsonData());
        this.cityNameRequest = cityNameRequest;
        validateCityNameRequest();
    }

    public WeatherCurrentApiImpl(HttpConnectFactory httpConnectionFactory, Jsonb jsonb, JsonData jsonData)
    {
        this.httpConnectionFactory = httpConnectionFactory;
        this.jsonb = jsonb;
        this.jsonData = jsonData;
    }

    private void validateCityNameRequest()
    {
        validation = ClientRequestValidation.getInstance();
        try
        {
            if(validation.validateCityNameRequest(cityNameRequest))
            {
                getApiData();
            }
        } catch (WrongCityNameRequestException e) {
            e.printStackTrace();
        }
    }

    private void getApiData()
    {
        apiData = jsonData.getJson(httpConnectionFactory, jsonb, QUERY_CURRENT_WEATHER, cityNameRequest);
    }

    private NotFoundDesiredJsonDataException newRunTimeException()
    {
        return new NotFoundDesiredJsonDataException("Not found any desired value");
    }

    @Override
    public double getTemperature()
    {

        return apiData.stream()
                        .mapToDouble(Data::getTemperature)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public String getWindDirection()
    {
        return apiData.stream()
                        .map(Data::getVerbalWindDirection)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getHumidity()
    {
        return apiData.stream()
                        .mapToDouble(Data::getRelativeHumidity)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public String getPartOfTheDay()
    {
        return apiData.stream()
                        .map(Data::getPartOfTheDay)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getPressure()
    {
        return apiData.stream()
                        .mapToDouble(Data::getPressure)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public LocalDateTime getLastObservationTime()
    {
        return apiData.stream()
                        .map(Data::getLastObservationTime)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getCloudsCoverage()
    {
        return apiData.stream()
                        .mapToDouble(Data::getCloudCoverage)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getVisibility()
    {
        return apiData.stream()
                        .mapToDouble(Data::getVisibility)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getWindSpeed()
    {
        return apiData.stream()
                        .mapToDouble(Data::getWindSpeed)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getApparentTemperature()
    {
        return apiData.stream()
                        .mapToDouble(Data::getApparentTemperature)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getDewPoint()
    {
        return apiData.stream()
                        .mapToDouble(Data::getDewPoint)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getUV()
    {
        return apiData.stream()
                        .mapToDouble(Data::getUVIndex)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public LocalDateTime getDateTime()
    {
        return apiData.stream()
                        .map(Data::getCurrentCycleHour)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getAccumulatedLiquidEquivalentPrecipitation()
    {
        return apiData.stream()
                        .mapToDouble(Data::getAccumulatedLiquidEquivalentPrecipitation)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public double getAccumulatedSnowfall()
    {
        return apiData.stream()
                        .mapToDouble(Data::getAccumulatedSnowfall)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public String getCityName()
    {
        return apiData.stream()
                        .map(Data::getCityName)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public LocalTime getSunrise()
    {
        return apiData.stream()
                        .map(Data::getSunriseTime)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public LocalTime getSunset()
    {
        return apiData.stream()
                        .map(Data::getSunSet)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }

    @Override
    public ZoneId getTimeZone()
    {
        return apiData.stream()
                        .map(Data::getTimeZone)
                        .findFirst()
                        .orElseThrow(this::newRunTimeException);
    }
}
