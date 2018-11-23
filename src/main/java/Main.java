
import api.WeatherHourlyForecastApi;
import entity.Data;
import service.WeatherCurrentApiImpl;
import service.WeatherHourlyForecastApiImpl;
import util.JsonData;

import java.time.LocalTime;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        WeatherCurrentApiImpl weatherApi = new WeatherCurrentApiImpl("Kalisz");
        double temp = weatherApi.getTemperature();

        System.out.println(temp + " stopni Celcjusza");

        System.out.println("**********************************************");

        WeatherHourlyForecastApiImpl weatherHourlyForecastApi = new WeatherHourlyForecastApiImpl("Kalisz", 48);

        List<Double> datas = weatherHourlyForecastApi.getTemperatureForecast();

        int i = 1;
        for(Double temps : datas)
            System.out.println(temps + " Time: " + LocalTime.now().plusHours(i++));
    }
}
