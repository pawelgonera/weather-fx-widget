package deserializeTest;

import entity.Data;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.json.bind.JsonbBuilder;

public class DataTest
{
    private final static String TEST_RESPONSE = "{\"wind_cdir\":\"PóPóZ\",\"rh\":91,\"pod\":\"n\",\"pres\":1008.81,\"timezone\":\"Europe\\/Warsaw\",\"weather\":{\"icon\":\"s01n\",\"code\":600,\"description\":\"Niewielkie opady śniegu\"},\"country_code\":\"PL\",\"clouds\":84,\"ts\":1543355652.2301,\"solar_rad\":0,\"state_code\":\"86\",\"wind_spd\":2.18274,\"lat\":51.76109,\"wind_cdir_full\":\"północ-PółnocWest\",\"slp\":1026.09,\"vis\":24.1,\"lon\":18.09102,\"sunrise\":\"06:21\",\"datetime\":\"2018-11-27:21\",\"h_angle\":-90,\"dewpt\":-1.8,\"snow\":0.13427734375,\"uv\":0,\"wind_dir\":341,\"elev_angle\":-54.3451,\"ghi\":0,\"dhi\":0,\"dni\":0,\"city_name\":\"Kalisz\",\"precip\":0.0068359375,\"sunset\":\"14:39\",\"temp\":-0.5,\"station\":\"E5239\",\"ob_time\":\"2018-11-27 21:54\",\"app_temp\":-5.6}";
    private Data data;

    @BeforeEach
    public void setUp()
    {
        data = JsonbBuilder.create().fromJson(TEST_RESPONSE, Data.class);
    }

    @Test
    public void deserializeTemperatureTest()
    {
        final double testingValue = data.getTemperature();

        assertThat(testingValue, is(-0.5));
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

        assertThat(testingValue, is(91.0));
    }

}
