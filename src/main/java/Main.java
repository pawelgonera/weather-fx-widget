
import service.WeatherCurrentApiImpl;
import service.WeatherHourlyForecastApiImpl;

import java.time.LocalTime;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        WeatherCurrentApiImpl weatherApi = new WeatherCurrentApiImpl();
        double temp = weatherApi.getTemperature("Kalisz");

        System.out.println(temp + " stopni Celcjusza");

        System.out.println("**********************************************");

        WeatherHourlyForecastApiImpl weatherHourlyForecastApi = new WeatherHourlyForecastApiImpl();

        List<Double> datas = weatherHourlyForecastApi.getTemperatureForecast("Kalisz", 48);

        int i = 1;
        for(Double temps : datas)
            System.out.println(temps + " Time: " + LocalTime.now().plusHours(i++));
    }
}
