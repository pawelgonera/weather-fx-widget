
import api.WeatherHourlyForecastApi;
import entity.Data;
import service.WeatherCurrentApiImpl;
import service.WeatherHourlyForecastApiImpl;

import java.time.LocalTime;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        WeatherCurrentApiImpl weatherApi = new WeatherCurrentApiImpl("Kalisz");
        double temp = weatherApi.getTemperature();

        System.out.println(temp + " stopni Celcjusza");

        WeatherHourlyForecastApiImpl weatherHourlyForecastApi = new WeatherHourlyForecastApiImpl("Kalisz", 48);

        List<Data> datas = weatherHourlyForecastApi.getTemperatureForecast();

        int i = 1;
        for(Data data : datas)
            System.out.println(data.getTemperature() + " Time: " + LocalTime.now().plusHours(i++));
    }
}
