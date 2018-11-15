import service.WeatherApiImpl;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        WeatherApiImpl weatherApi = new WeatherApiImpl("Kalisz");
        double temp = weatherApi.getTemperature();

        char asci = 23;
        System.out.println(temp + " stopni Celcjusza " + asci);
    }
}
