package deserializeTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import entity.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;

public class WeatherTest
{
    private final static String WEATHER_TEST_RESPONSE = "{\"icon\":\"c01n\",\"code\":800,\"description\":\"Przejrzyste niebo\"}";
    private Weather weather;
    private static WeatherTest instance = null;

    public static WeatherTest getInstance()
    {
        if(instance == null)
            instance = new WeatherTest();

        return instance;
    }

    @BeforeEach
    public void setUp()
    {
        weather = JsonbBuilder.create().fromJson(WEATHER_TEST_RESPONSE, Weather.class);
    }

    @Test
    public void getCodeTest()
    {
        final String testingValue = weather.getWeatherCode();

        assertThat(testingValue, is("800"));
    }

    @Test
    public void getIconTest()
    {
        final String testingValue = weather.getWeatherIconCode();

        assertThat(testingValue, is("c01n"));
    }

    @Test
    public void getDescriptionTest()
    {
        final String testingValue = weather.getTextWeatherDescription();

        assertThat(testingValue, is("Przejrzyste niebo"));
    }

}
