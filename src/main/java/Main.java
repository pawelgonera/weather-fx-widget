
import entity.JsonBody;
import get.HttpConnection;
import get.factory.HttpConnectFactory;
import service.WeatherCurrentApiImpl;
import service.WeatherHourlyForecastApiImpl;
import util.JsonData;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

public class Main
{
    private static String QUERY = "https://api.weatherbit.io/v2.0/current?city=Kalisz&key=c820ef242bee4a319736ef8537661f06";
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

    public static void main(String[] args)
    {
        /*WeatherCurrentApiImpl weatherApi = new WeatherCurrentApiImpl();

        double temp = weatherApi.getTemperature("Kalisz");

        System.out.println(temp + " stopni Celcjusza");

        System.out.println("**********************************************");

        WeatherHourlyForecastApiImpl weatherHourlyForecastApi = new WeatherHourlyForecastApiImpl();

        List<Double> datas = weatherHourlyForecastApi.getTemperatureForecast("Kalisz", 48);

        int i = 1;
        for(Double temps : datas)
            System.out.println(temps + " Time: " + LocalTime.now().plusHours(i++));
            */

        WeatherCurrentApiImpl api = new WeatherCurrentApiImpl("Kalisz");


        System.out.println("Temperaturta: " + api.getTemperature() + " C");
        System.out.println("Kierunek wiatru: " + api.getWindDirection());
        System.out.println("Wilgotność: " + api.getHumidity() + " %");
        System.out.println("Pora dnia: " + (api.getPartOfTheDay().equalsIgnoreCase("D") ? "Dzień " : " Noc"));
        System.out.println("Ciśnienie: " + api.getPressure() + " hPa");
        System.out.println("Ostatnia data obserwacji: " + api.getLastObservationTime());
        System.out.println("Zachmurzenie: " + api.getCloudsCoverage() + " %");
        System.out.println("Widoczność: " + api.getVisibility() + " km");
        System.out.println("Prędkość wiatru: " + new DecimalFormat("#.00").format(api.getWindSpeed() * 3.6) + " km/h");
        System.out.println("Temperatura odczuwalna: " + api.getApparentTemperature() + " C");
        System.out.println("Temperatura punktu rosy: " + api.getDewPoint() + " C");
        System.out.println("Promieniowanie UV: " + api.getUV());
        System.out.println("Aktualny czas: " + api.getDateTime().atZone(ZoneId.systemDefault()).withZoneSameInstant(api.getTimeZone()).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Opady deszczu: " + new DecimalFormat("#0.0").format(api.getAccumulatedLiquidEquivalentPrecipitation()) + " mm");
        System.out.println("Opady śniegu: " + new DecimalFormat("#0.0").format(api.getAccumulatedSnowfall()) + " mm");
        System.out.println("Nazwa miasta: " + api.getCityName());
        System.out.println("Wschód słońca: " + api.getSunrise());
        System.out.println("Zachód słońca: " + api.getSunset());


    }
}
