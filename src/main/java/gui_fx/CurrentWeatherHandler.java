package gui_fx;

import gui_fx.rotates.RotateArrow;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.WeatherCurrentApiImpl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentWeatherHandler
{
    private WeatherCurrentApiImpl api;
    private RotateArrow rotateArrow = RotateArrow.getInstance();

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    private Controller controller = new Controller();

    private Label main_temp_label;
    Label realFeel_temp_label;
    Label wind_speed_label;
    Label wind_direction_label;
    ImageView wind_direction_icon ;
    Label pressure_label;
    Label humidity_label;
    Label rain_fall_label ;
    Label snowfall_label;
    Label cityname_label ;
    Label clouds_label;
    Label refresh_time_label ;
    ImageView weather_icon;

    private void setUp()
    {


    }

    public CurrentWeatherHandler(String cityNameRequest)
    {
        api = new WeatherCurrentApiImpl(cityNameRequest);

        main_temp_label = new Label();
        realFeel_temp_label = new Label();
        wind_speed_label = new Label();
        wind_direction_label = new Label();
        wind_direction_icon = new ImageView();
        pressure_label = new Label();
        humidity_label = new Label();
        rain_fall_label = new Label();
        snowfall_label = new Label();
        cityname_label = new Label();
        clouds_label = new Label();
        refresh_time_label = new Label();
        weather_icon = new ImageView();
    }

    public void displayWeatherIcon()
    {
        String weatherCodeIcon = api.getWeatherIconCode();
        String iconUrl = String.format("icons_weather/%s.png", weatherCodeIcon);

        weather_icon.setImage(new Image(iconUrl));
    }

    public void displayWindDirectionArrow()
    {
        int degree = rotateArrow.getRotateValue();
        wind_direction_icon.setRotate(degree);
    }

    public void displayLastObservationTime()
    {
        LocalDateTime time = api.getLastObservationTime();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(time, api.getTimeZone().toZoneId());
        String timeFormat = time.plusSeconds(zonedDateTime.getOffset().getTotalSeconds()).format(FORMATTER);
        refresh_time_label.setText(String.valueOf(timeFormat));
    }

    public void displayCloudsCoverage()
    {
        int clouds = api.getCloudsCoverage();
        clouds_label.setText(String.valueOf(clouds));
    }

    public void displayCityName()
    {
        String cityName = api.getCityName();
        cityname_label.setText(cityName);
    }

    public void displaySnowFall()
    {
        String snowfall = FORMAT_PRECISION.format(api.getAccumulatedSnowfall());
        snowfall_label.setText(snowfall);
    }

    public void displayRainFall()
    {
        String rainfall = FORMAT_PRECISION.format(api.getAccumulatedLiquidEquivalentPrecipitation());
        rain_fall_label.setText(rainfall);
    }

    public void displayHumidity()
    {
        int humidity = api.getHumidity();
        humidity_label.setText(String.valueOf(humidity));
    }

    public void displayPressure()
    {
        String pressure = FORMAT_PRECISION.format(api.getPressure());
        pressure_label.setText(String.valueOf(pressure));
    }

    public void displayWindDirection()
    {
        Controller.WIND_DIRECTION = api.getAbbreviatedWindDirection();
        wind_direction_label.setText(Controller.WIND_DIRECTION);

    }

    public void displayWindSpeed()
    {
        String windSpeed = FORMAT_PRECISION.format(api.getWindSpeed() * 3.6);
        wind_speed_label.setText(windSpeed);

    }

    public void displayRealFeelTemp()
    {
        double appTemp = api.getApparentTemperature();
        realFeel_temp_label.setText("/ " + String.valueOf(appTemp));
    }

    public void displayTemp()
    {
        BigDecimal temp = api.getTemperature();
        System.out.println("temp" + temp);
        main_temp_label.setText(String.valueOf(temp));
    }
}
