package deserializeTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

import entity.DataDaily;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class DataDailyTest
{
    private final static String DATA_TEST_RESPONSE = "{\"moonrise_ts\":1545427294,\"wind_cdir\":\"SSW\",\"rh\":91,\"pres\":1008.81,\"sunset_ts\":1545429783,\"ozone\":332.964,\"moon_phase\":0.990917,\"wind_gust_spd\":17.6,\"snow_depth\":0.0,\"clouds\":83,\"ts\":1545368460,\"sunrise_ts\":1545394456,\"app_min_temp\":3.9,\"wind_spd\":7.51514,\"pop\":15.0,\"wind_cdir_full\":\"północ-PółnocWest\",\"slp\":991.86,\"app_max_temp\":16.4,\"vis\":24.1,\"dewpt\":9.8,\"snow\":0,\"uv\":2.25071,\"valid_date\":\"2018-12-21\",\"wind_dir\":209.0,\"max_dhi\":0.0,\"clouds_hi\":0.0,\"precip\":1.0625,\"weather\":{\"icon\":\"c04d\",\"code\":804,\"description\":\"Overcast clouds\"},\"max_temp\":17.4,\"moonset_ts\":1545397201,\"datetime\":\"2018-12-21\",\"temp\":12,\"min_temp\":7,\"clouds_mid\":28.0,\"clouds_low\":77.0}";
    private DataDaily data;


    @BeforeEach
    public void setUp()
    {
        data = JsonbBuilder.create().fromJson(DATA_TEST_RESPONSE, DataDaily.class);
    }

    @Test
    public void deserializeTemperatureTest()
    {
        final BigDecimal testingValue = data.getTemperature();

        Assertions.assertEquals(testingValue, new BigDecimal(12));
        //assertThat(testingValue, is(-0.5));
    }

    @Test
    public void deserializeMaxTemperatureTest()
    {
        final BigDecimal testingValue = data.getMaxTemperature();

        Assertions.assertEquals(testingValue, new BigDecimal(17.4).round(new MathContext(3, RoundingMode.HALF_UP)));
        //assertThat(testingValue, is(-0.5));
    }

    @Test
    public void deserializeMinTemperatureTest()
    {
        final BigDecimal testingValue = data.getMinTemperature();

        Assertions.assertEquals(testingValue, new BigDecimal(7));
        //assertThat(testingValue, is(-0.5));
    }

    @Test
    public void deserializeVerbalWindDirectionTest()
    {
        final String testingValue = data.getVerbalWindDirection();

        assertEquals(testingValue, "północ-PółnocWest");
        //assertThat(testingValue, is("północ-PółnocWest"));
    }

    @Test
    public void deserializeRelativeHumidityTest()
    {
        final double testingValue = data.getRelativeHumidity();

        assertEquals(testingValue, 91);
        //assertThat(testingValue, is(91));
    }

    @Test
    public void deserializePressureTest()
    {
        final double testingValue = data.getPressure();

        assertEquals(testingValue, 1008.81);
        //assertThat(testingValue, is(1008.81));
    }

    @Test
    public void deserializeCloudsCoverageTest()
    {
        final double testingValue = data.getCloudCoverage();

        assertEquals(testingValue, 83.0);
        //assertThat(testingValue, is(84.0));
    }

    @Test
    public void deserializeVisibilityTest()
    {
        final double testingValue = data.getVisibility();

        assertEquals(testingValue, 24.1);
        //assertThat(testingValue, is(24.1));
    }

    @Test
    public void deserializeWindSpeedTest()
    {
        final double testingValue = data.getWindSpeed();

        assertEquals(testingValue, 7.51514);
        //assertThat(testingValue, is(2.18274));
    }

    @Test
    public void deserializeMaxApparentTemperatureTest()
    {
        final BigDecimal testingValue = data.getMaxApparentTemperature();

        assertEquals(testingValue, new BigDecimal(16.4).round(new MathContext(3, RoundingMode.HALF_UP)));
        //assertThat(testingValue, is(-5.6));
    }

    @Test
    public void deserializeMinApparentTemperatureTest()
    {
        final BigDecimal testingValue = data.getMinApparentTemperature();

        assertEquals(testingValue, new BigDecimal(3.9).round(new MathContext(2, RoundingMode.HALF_UP)));
        //assertThat(testingValue, is(-5.6));
    }

    @Test
    public void deserializeDewPointTest()
    {
        final double testingValue = data.getDewPoint();

        assertEquals(testingValue, 9.8);
        //assertThat(testingValue, is(-1.8));
    }

    @Test
    public void deserializeUVTest()
    {
        final double testingValue = data.getUVIndex();

        assertEquals(testingValue, 2.25071);
        //assertThat(testingValue, is(0.0));
    }

    @Test
    public void deserializeDateTimeTest()
    {
        final LocalDate testingValue = data.getCurrentCycleHour();

        assertEquals(testingValue, LocalDate.of(2018, 12, 21));
        //assertThat(testingValue, is(LocalDateTime.of(2018, 11, 27, 21, 0 )));
    }

    @Test
    public void deserializeAccumulatedLiquidEquivalentPrecipitationTest()
    {
        final double testingValue = data.getAccumulatedLiquidEquivalentPrecipitation();

        assertEquals(testingValue, 1.0625);
        //assertThat(testingValue, is(0.0068359375));
    }

    @Test
    public void deserializeAccumulatedSnowfallTest()
    {
        final double testingValue = data.getAccumulatedSnowfall();

        assertEquals(testingValue, 0.0);
        //assertThat(testingValue, is(0.13427734375));
    }

    @Test
    public void deserializeSunriseTest()
    {
        final long testingValue = data.getSunriseTimeUnixTimestamp();

        assertEquals(testingValue, 1545394456);
        //assertThat(testingValue, is(LocalTime.of(6, 21)));
    }

    @Test
    public void deserializeSunsetTest()
    {
        final long testingValue = data.getSunsetTimeUnixTimestamp();

        assertEquals(testingValue, 1545429783);
        //assertThat(testingValue, is(LocalTime.of(14, 39)));
    }
}
