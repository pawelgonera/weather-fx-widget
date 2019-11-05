package deserializeTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import entity.JsonBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;

public class JsonBodyTest
{
    private final static String JSONBODY_TEST_RESPONSE = "{\"data\":[{}],\"city_name\":\"Kalisz\",\"lon\":\"18.09102\",\"timezone\":\"Europe\\/Warsaw\",\"lat\":\"51.76109\",\"country_code\":\"PL\",\"state_code\":\"86\",\"count\":1}";

    private JsonBody jsonBody;

    @BeforeEach
    public void setUp()
    {
        jsonBody = JsonbBuilder.create().fromJson(JSONBODY_TEST_RESPONSE, JsonBody.class);
    }

    @Test
    public void getCityNameTest()
    {
        final String testingValue = jsonBody.getCityName();

        assertThat(testingValue, is("Kalisz"));
    }

    @Test
    public void getCount()
    {
        final int testingValue = jsonBody.getCount();

        assertThat(testingValue, is(1));
    }

    @Test
    public void getCountryCodeTest()
    {
        final String testingValue = jsonBody.getCountryAbbreviation();

            assertThat(testingValue, is("PL"));
    }

    @Test
    public void getStateCodeTest()
    {
        final String testingValue = jsonBody.getStateAbbreviation();

        assertThat(testingValue, is("86"));
    }

    @Test
    public void getTimeZoneTest()
    {
        final String testingValue = jsonBody.getLocalTimezone();

        assertThat(testingValue, is("Europe/Warsaw"));
    }

    @Test
    public void getLatitudeTest()
    {
        final BigDecimal testingValue = jsonBody.getLatitude();

        assertThat(testingValue, is(BigDecimal.valueOf(51.76109)));
    }

    @Test
    public void getLongitudeTest()
    {
        final BigDecimal testingValue = jsonBody.getLongitude();

        assertThat(testingValue, is(BigDecimal.valueOf(18.09102)));
    }

}




