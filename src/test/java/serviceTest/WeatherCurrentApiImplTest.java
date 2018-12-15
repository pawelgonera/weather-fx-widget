package serviceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import entity.JsonBody;
import get.factory.HttpConnectFactory;
import get.factory.QueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.WeatherCurrentApiImpl;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;

public class WeatherCurrentApiImplTest
{
    private static String QUERY_CURRENT_WEATHER = "https://api.weatherbit.io/v2.0/current?city=%s&lang=en&key=%s";
    private final static String CITY_NAME_REQUEST = "Wieliczka";
    private WeatherCurrentApiImpl api;
    private Jsonb jsonb;
    private JsonBody json;

    @BeforeEach
    void setUp()
    {
        api = new WeatherCurrentApiImpl(CITY_NAME_REQUEST);
        jsonb = JsonbBuilder.create();

        String query = new QueryFactory().setCurrentQuery(CITY_NAME_REQUEST, QUERY_CURRENT_WEATHER);
        String response = new HttpConnectFactory().getConnection(query).connect();

        //String response = "{\"data\":[{\"wind_cdir\":\"E\",\"rh\":95,\"pod\":\"n\",\"lon\":20.06473,\"pres\":958.2,\"timezone\":\"Europe\\/Warsaw\",\"ob_time\":\"2018-12-14 21:53\",\"country_code\":\"PL\",\"clouds\":0,\"vis\":10,\"solar_rad\":0,\"state_code\":\"77\",\"wind_spd\":1,\"lat\":49.98738,\"wind_cdir_full\":\"east\",\"slp\":998.4,\"datetime\":\"2018-12-14:22\",\"ts\":1544824380,\"station\":\"E6527\",\"h_angle\":-90,\"dewpt\":-2.3,\"uv\":0,\"dni\":0,\"wind_dir\":81,\"elev_angle\":-57.3136,\"ghi\":0,\"dhi\":0,\"precip\":null,\"city_name\":\"Wieliczka\",\"weather\":{\"icon\":\"c01n\",\"code\":\"800\",\"description\":\"Clear sky\"},\"sunset\":\"14:38\",\"temp\":-1.7,\"sunrise\":\"06:32\",\"app_temp\":-2.6}],\"count\":1}";

        json = jsonb.fromJson(response, JsonBody.class);
    }

    @Test
    public void getWeatherCodeTest()
    {
        final String weatherCodeTest = api.getWeatherCode();

        final String testValue = json.getData().get(0).getWeather().getWeatherCode();

        assertThat(weatherCodeTest, is(testValue));
    }

    @Test
    public void getWeatherIconCodeTest()
    {
        final String weatherIconCodeTest = api.getWeatherIconCode();

        final String testValue = json.getData().get(0).getWeather().getWeatherIconCode();

        assertThat(weatherIconCodeTest, is(testValue));
    }

    @Test
    public void getTemperatureTest()
    {
        final BigDecimal temperatureTest = api.getTemperature();

        final BigDecimal testValue = json.getData().get(0).getTemperature();

        assertThat(temperatureTest, is(testValue));
    }

    @Test
    public void getWindDirectionTest()
    {
        final String windDirectionTest = api.getWindDirection();

        final String testValue = json.getData().get(0).getVerbalWindDirection();

        assertThat(windDirectionTest, is(testValue));
    }

    @Test
    public void getAbbreviatedWindDirectionTest()
    {
        final String abbreviatedWindDirectionTest = api.getAbbreviatedWindDirection();

        final String testValue = json.getData().get(0).getAbbreviatedWindDirection();

        assertThat(abbreviatedWindDirectionTest, is(testValue));
    }

    @Test
    public void getHumidityTest()
    {
        final double humadityTest = api.getHumidity();

        final double testValue = json.getData().get(0).getRelativeHumidity();

        assertThat(humadityTest, is(testValue));
    }

    @Test
    public void getPartOfTheDayTest()
    {
        final String partOfTheDayTest = api.getPartOfTheDay();

        final String testValue = json.getData().get(0).getPartOfTheDay();

        assertThat(partOfTheDayTest, is(testValue));
    }

    @Test
    public void getPressureTest()
    {
        final double pressureTest = api.getPressure();

        final double testValue = json.getData().get(0).getPressure();

        assertThat(pressureTest, is(testValue));
    }

    @Test
    public void getLastObservationTimeTest()
    {
        final LocalDateTime lastObservationTimeTest = api.getLastObservationTime();

        final LocalDateTime testValue = json.getData().get(0).getLastObservationTime();

        assertThat(lastObservationTimeTest, is(testValue));
    }

    @Test
    public void getCloudsCoverageTest()
    {
        final int cloudsCoverageTest = api.getCloudsCoverage();

        final int testValue = json.getData().get(0).getCloudCoverage();

        assertThat(cloudsCoverageTest, is(testValue));
    }

    @Test
    public void getVisibilityTest()
    {
        final double visibilityTest = api.getVisibility();

        final double testValue = json.getData().get(0).getVisibility();

        assertThat(visibilityTest, is(testValue));
    }

    @Test
    public void getWindSpeedTest()
    {
        final double windSpeedTest = api.getWindSpeed();

        final double testValue = json.getData().get(0).getWindSpeed();

        assertThat(windSpeedTest, is(testValue));
    }

    @Test
    public void getApparentTemperatureTest()
    {
        final double apparentTemperatureTest = api.getApparentTemperature();

        final double testValue = json.getData().get(0).getApparentTemperature();

        assertThat(apparentTemperatureTest, is(testValue));
    }

    @Test
    public void getDewPointTest()
    {
        final double dewPointTest = api.getDewPoint();

        final double testValue = json.getData().get(0).getDewPoint();

        assertThat(dewPointTest, is(testValue));
    }

    @Test
    public void getUVTest()
    {
        final double uvTest = api.getUV();

        final double testValue = json.getData().get(0).getUVIndex();

        assertThat(uvTest, is(testValue));
    }

    @Test
    public void getDateTimeTest()
    {
        final LocalDateTime dateTimeTest = api.getDateTime();

        final LocalDateTime testValue = json.getData().get(0).getCurrentCycleHour();

        assertThat(dateTimeTest, is(testValue));
    }

    @Test
    public void getAccumulatedLiquidEquivalentPrecipitationTest()
    {
        final double accumulatedLiquidEquivalentPrecipitationTest = api.getAccumulatedLiquidEquivalentPrecipitation();

        final double testValue = json.getData().get(0).getAccumulatedLiquidEquivalentPrecipitation();

        assertThat(accumulatedLiquidEquivalentPrecipitationTest, is(testValue));
    }

    @Test
    public void getAccumulatedSnowfallTest()
    {
        final double accumulatedSnowfallTest = api.getAccumulatedSnowfall();

        final double testValue = json.getData().get(0).getAccumulatedSnowfall();

        assertThat(accumulatedSnowfallTest, is(testValue));
    }

    @Test
    public void getCityNameTest()
    {
        final String cityNameTest = api.getCityName();

        final String testValue = json.getData().get(0).getCityName();

        assertThat(cityNameTest, is(testValue));
    }

    @Test
    public void getSunriseTest()
    {
        final LocalTime sunriseTest = api.getSunrise();

        final LocalTime testValue = json.getData().get(0).getSunriseTime();

        assertThat(sunriseTest, is(testValue));
    }

    @Test
    public void getSunsetTest()
    {
        final LocalTime sunsetTest = api.getSunset();

        final LocalTime testValue = json.getData().get(0).getSunSet();

        assertThat(sunsetTest, is(testValue));
    }

    @Test
    public void getTimeZoneTest()
    {
        final TimeZone timeZoneTest = api.getTimeZone();

        final TimeZone testValue = json.getData().get(0).getTimeZone();

        assertThat(timeZoneTest, is(testValue));
    }

}

