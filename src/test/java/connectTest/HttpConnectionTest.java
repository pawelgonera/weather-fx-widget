package connectTest;

import api.WeatherCurrentApi;
import exception.WrongServerStatusException;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.WeatherCurrentApiImpl;
import util.JsonData;

import javax.json.bind.JsonbBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class HttpConnectionTest
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/current?city=Kalisz&key=c820ef242bee4a319736ef8537661f06";
    private static Pattern JSON_REGEX = Pattern.compile("\\{\\\"data\"\\:\\[\\{\\\"wind_cdir\\\"\\:.*\\\"rh\\\"\\:.*\\\"pod\\\"\\:.*\\\"lon\\\"\\:.*\\\"pres\\\"\\:.*\\\"timezone\\\"\\:.*\\\"ob_time\\\"\\:.*\\\"country_code\\\"\\:.*\\\"clouds\\\"\\:.*\\\"vis\\\"\\:.*\\\"solar_rad\\\"\\:.*\\\"state_code\\\"\\:.*\\\"wind_spd\\\"\\:.*\\\"lat\\\"\\:.*\\\"wind_cdir_full\\\"\\:.*\\\"slp\\\"\\:.*\\\"datetime\\\"\\:.*\\\"ts\\\"\\:.*\\\"station\\\"\\:.*\\\"h_angle\\\"\\:.*\\\"dewpt\\\"\\:.*\\\"uv\\\"\\:.*\\\"dni\\\"\\:.*\\\"wind_dir\\\"\\:.*\\\"elev_angle\\\"\\:.*\\\"ghi\\\"\\:.*\\\"dhi\\\"\\:.*\\\"precip\\\"\\:.*\\\"city_name\\\"\\:.*\\\"weather\\\"\\:\\{\\\"icon\\\"\\:.*\\\"code\\\"\\:.*\\\"description\\\"\\:.*\\},\\\"sunset\\\"\\:.*\\\"temp\\\"\\:.*\\\"sunrise\\\"\\:.*\\\"app_temp\\\"\\:.*\\}\\]\\,\"count\\\"\\:.*\\}");
    private Matcher matcher;
    private WeatherCurrentApi api;
    private WrongServerStatusException exception;

    private HttpConnectFactory connectFactoryMock;

    private HttpConnection connectionMock;

    @BeforeEach
    public void setUp()
    {

        System.out.println("hey");
        /*connectFactoryMock = mock(HttpConnectFactory.class);
        connectionMock = mock(HttpConnection.class);
        when(connectFactoryMock.getConnection(anyString())).thenReturn(connectionMock);
        //when(connectFactoryMock.getConnection("wrong_url")).thenThrow(exception);
        api = new WeatherCurrentApiImpl(connectFactoryMock, JsonbBuilder.create(), new JsonData());
        connectionMock = connectFactoryMock.getConnection(QUERY);
        */
        connectFactoryMock = new HttpConnectFactory();
        connectionMock = connectFactoryMock.getConnection(QUERY);

        //String response = connectionMock.connect();
        //System.out.println(response);

        matcher = JSON_REGEX.matcher(connectionMock.connect());

        api = new WeatherCurrentApiImpl(connectFactoryMock, JsonbBuilder.create(), new JsonData());

    }

    @Test
    public void test1()
    {

        //connectFactoryMock = new HttpConnectFactory();
        //connectionMock = new HttpConnection(QUERY);
        //api = new WeatherCurrentApiImpl(connectFactoryMock, JsonbBuilder.create(), new JsonData());


        //when(connectionMock.connect()).thenReturn(matcher.toString());
        //when(connectFactoryMock.getConnection("wrong_url")).thenThrow(exception);

        String response = connectionMock.connect();
        api.getTemperature();

        //verify(connectFactoryMock).getConnection(QUERY);

        Assertions.assertEquals(response, matcher.toString());

    }
}
