package gui_fx;

import api.WeatherDailyForecastApi;
import gui_fx.rotates.RotateArrow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import service.WeatherDailyForecastImpl;
import util.SaveCityName;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Daily
{

    WeatherDailyForecastApi api;

    private SaveCityName saveCityName = SaveCityName.getInstance();

    private RotateArrow rotateArrow = RotateArrow.getInstance();

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    private static String CITY_REQUEST;
    protected static String CITY_NAME;
    private static int DAYS = 16;
    private static int INDEX = 0;

    private List<String> weatherCodeIcon;
    private List<BigDecimal> maxTemp;
    private List<BigDecimal> minTemp;
    private List<Double> windSpeed;
    private List<String> windDirection;
    private List<Double> pressure;
    private List<Integer> humidity;
    private List<Double> rainFall;
    private List<Double> snowFall;
    private List<String> description;
    private List<LocalDate> time;
    private String cityName;

    private Parent current;
    private Parent hourly;
    private Parent threeHourly;
    private Parent about;

    @FXML
    private AnchorPane daily_anchorPane;
    @FXML
    private Label min_temp_label;
    @FXML
    private Label max_temp_label;
    @FXML
    private Label wind_speed_label;
    @FXML
    private ImageView wind_direction_icon;
    @FXML
    private Label pressure_label;
    @FXML
    private Label rain_fall_label;
    @FXML
    private ImageView weather_icon;
    @FXML
    private Label description_label;
    @FXML
    private Label day_time_label;
    @FXML
    private Label day_of_week_label;
    @FXML
    private Label min_temp_label1;
    @FXML
    private Label max_temp_label1;
    @FXML
    private Label wind_speed_label1;
    @FXML
    private ImageView wind_direction_icon1;
    @FXML
    private Label pressure_label1;
    @FXML
    private Label rain_fall_label1;
    @FXML
    private ImageView weather_icon1;
    @FXML
    private Label description_label1;
    @FXML
    private Label day_time_label1;
    @FXML
    private Label day_of_week_label1;
    @FXML
    private Label min_temp_label2;
    @FXML
    private Label max_temp_label2;
    @FXML
    private Label wind_speed_label2;
    @FXML
    private ImageView wind_direction_icon2;
    @FXML
    private Label pressure_label2;
    @FXML
    private Label rain_fall_label2;
    @FXML
    private ImageView weather_icon2;
    @FXML
    private Label description_label2;
    @FXML
    private Label day_time_label2;
    @FXML
    private Label day_of_week_label2;
    @FXML
    private Label min_temp_label3;
    @FXML
    private Label max_temp_label3;
    @FXML
    private Label wind_speed_label3;
    @FXML
    private ImageView wind_direction_icon3;
    @FXML
    private Label pressure_label3;
    @FXML
    private Label rain_fall_label3;
    @FXML
    private ImageView weather_icon3;
    @FXML
    private Label description_label3;
    @FXML
    private Label day_time_label3;
    @FXML
    private Label day_of_week_label3;
    @FXML
    private Pane menu_panel_pane;
    @FXML
    private Label cityname_label;
    @FXML
    private Label snowfall_label;
    @FXML
    private ImageView menu_icon;
    @FXML

    private void setApi()
    {
        api = new WeatherDailyForecastImpl(CITY_REQUEST, DAYS);
    }

    /*
    @FXML
    private void initialize()
    {
        loadCityName();

        if(CITY_REQUEST != null)
        {
            setApi();
            setTime();
            setMaxTemp();
            setMinTemp();
            setWindSpeed();
            setWindDirection();
            setPressure();
            setHumidity();
            setRainFall();
            setSnowFall();
            displayCityName();
            displayWindDirectionArrow();
            setWeatherIcon();
            setDescription();
        }
    }

    private void displayData()
    {
        displayMaxTemp();
        displayMinTemp();
        displayCityName();
        displayWindSpeed();
        displayHumidity();
        displayRainFall();
        displaySnowFall();
        displayDescription();
        displayPressure();
        displayWindDirectionArrow();
        displayWeatherIcon();
       // displayTime();
    }
*/
    public void showMenu()
    {
        menu_panel_pane.setLayoutX(270);
        menu_icon.setOpacity(0);
    }

    public void hideMenu()
    {
        menu_panel_pane.setLayoutX(370);
        menu_icon.setOpacity(100);
    }
/*
    private void setTime()
    {
        time = api.getDateTime();
        //displayTime();
    }

    private void setMaxTemp()
    {
        maxTemp = api.getMaxTemperatureForecast();
        displayMaxTemp();
    }

    private void setMinTemp()
    {
        minTemp = api.getMinTemperatureForecast();
        displayMinTemp();
    }

    private void setWindSpeed()
    {
        windSpeed = api.getWindSpeed();
        displayWindSpeed();
    }

    private void setWindDirection()
    {
        windDirection = api.getAbbreviatedWindDirection();
    }

    private void setPressure()
    {
        pressure = api.getPressure();
        displayPressure();
    }

    private void setHumidity()
    {
        humidity = api.getHumidity();
        displayHumidity();
    }

    private void setRainFall()
    {
        rainFall = api.getAccumulatedLiquidEquivalentPrecipitation();
        displayRainFall();
    }

    private void setSnowFall()
    {
        snowFall = api.getAccumulatedSnowfall();
        displaySnowFall();
    }


    private void setWeatherIcon()
    {
        weatherCodeIcon = api.getWeatherIconCode();
        displayWeatherIcon();
    }

    private void setDescription()
    {
        description = api.getDescription();
        displayDescription();
    }


    private void displayMaxTemp()
    {
        max_temp_label.setText(String.valueOf(maxTemp.get(0)));
        max_temp_label1.setText(String.valueOf(maxTemp.get(1)));
        max_temp_label2.setText(String.valueOf(maxTemp.get(2)));
        max_temp_label3.setText(String.valueOf(maxTemp.get(3)));
    }

    private void displayMinTemp()
    {
        min_temp_label.setText(String.valueOf(minTemp.get(0)));
        min_temp_label1.setText(String.valueOf(minTemp.get(1)));
        min_temp_label2.setText(String.valueOf(minTemp.get(2)));
        min_temp_label3.setText(String.valueOf(minTemp.get(3)));
    }

    private void displayTime()
    {
        day_time_label.setText(String.valueOf(time.get(0)));
        day_time_label1.setText(String.valueOf(time.get(1)));
        day_time_label2.setText(String.valueOf(time.get(2)));
        day_time_label3.setText(String.valueOf(time.get(3)));
    }

    private void displayWeatherIcon()
    {
        String iconUrl = String.format("icons_weather/%s.png", weatherCodeIcon.get(0));
        weather_icon.setImage(new Image(iconUrl));
        String iconUrl1 = String.format("icons_weather/%s.png", weatherCodeIcon.get(1));
        weather_icon1.setImage(new Image(iconUrl1));
        String iconUrl2 = String.format("icons_weather/%s.png", weatherCodeIcon.get(2));
        weather_icon2.setImage(new Image(iconUrl2));
        String iconUrl3 = String.format("icons_weather/%s.png", weatherCodeIcon.get(3));
        weather_icon3.setImage(new Image(iconUrl3));
    }
*/
    private int setWindArrow(int index)
    {
        Controller.WIND_DIRECTION = windDirection.get(index);
        return rotateArrow.getRotateValue();
    }

    private void displayWindDirectionArrow()
    {
        wind_direction_icon.setRotate(setWindArrow(0));
        wind_direction_icon1.setRotate(setWindArrow(1));
        wind_direction_icon2.setRotate(setWindArrow(2));
        wind_direction_icon3.setRotate(setWindArrow(3));
    }

    private void displayCityName()
    {
        cityname_label.setText(CITY_NAME);
    }

    private void displaySnowFall()
    {
        //snowfall_label.setText(FORMAT_PRECISION.format(snowFall.get(INDEX)));
    }
/*
    private void displayRainFall()
    {
        rain_fall_label.setText(FORMAT_PRECISION.format(rainFall.get(0)));
        rain_fall_label1.setText(FORMAT_PRECISION.format(rainFall.get(1)));
        rain_fall_label2.setText(FORMAT_PRECISION.format(rainFall.get(2)));
        rain_fall_label3.setText(FORMAT_PRECISION.format(rainFall.get(3)));
    }

    private void displayHumidity()
    {
        //humidity_label.setText(String.valueOf(humidity.get(INDEX)));
    }

    private void displayPressure()
    {
        pressure_label.setText(FORMAT_PRECISION.format(pressure.get(0)));
        pressure_label1.setText(FORMAT_PRECISION.format(pressure.get(1)));
        pressure_label2.setText(FORMAT_PRECISION.format(pressure.get(2)));
        pressure_label3.setText(FORMAT_PRECISION.format(pressure.get(3)));
    }

    private void displayWindSpeed()
    {
        wind_speed_label.setText(FORMAT_PRECISION.format(windSpeed.get(0) * 3.6));
        wind_speed_label1.setText(FORMAT_PRECISION.format(windSpeed.get(1) * 3.6));
        wind_speed_label2.setText(FORMAT_PRECISION.format(windSpeed.get(2) * 3.6));
        wind_speed_label3.setText(FORMAT_PRECISION.format(windSpeed.get(3) * 3.6));
    }

    private void displayDescription()
    {
        description_label.setText(description.get(0));
        description_label1.setText(description.get(1));
        description_label2.setText(description.get(2));
        description_label3.setText(description.get(3));
    }
*/
    public void switchToCurrent() throws IOException
    {
        current = FXMLLoader.load(getClass().getResource("/fxml/current.fxml"));
        daily_anchorPane.getChildren().addAll(current);
    }

    public void switchToHourly() throws IOException
    {
        hourly = FXMLLoader.load(getClass().getResource("/fxml/hourly.fxml"));
        daily_anchorPane.getChildren().addAll(hourly);
    }

    public void aboutProgram() throws IOException
    {
        about = FXMLLoader.load(getClass().getResource("/fxml/widget.fxml"));
        daily_anchorPane.getChildren().addAll(about);
    }

    public void switchToDaily()
    {

    }

    private void loadCityName()
    {
        CITY_REQUEST = saveCityName.loadCityName();
    }

}
