package gui_fx;

import gui_fx.rotates.RotateArrow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import service.WeatherHourlyForecastApiImpl;
import util.SaveCityName;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hourly
{
    WeatherHourlyForecastApiImpl api;

    private SaveCityName saveCityName = SaveCityName.getInstance();

    private RotateArrow rotateArrow = RotateArrow.getInstance();

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    private static String CITY_REQUEST;
    protected static String CITY_NAME;
    private static int HOURS = 48;
    private static int INDEX = 0;

    private List<String> weatherCodeIcon;
    private List<BigDecimal> temp;
    private List<Double> appTemp;
    private List<Double> windSpeed;
    private List<String> windDirection;
    private List<Double> pressure;
    private List<Integer> humidity;
    private List<Double> rainFall;
    private List<Double> snowFall;
    private List<Integer> cloudsCoverage;
    private List<Double> uvIndex;
    private List<String> description;
    private List<LocalDateTime> time;
    private String cityName;

    private Parent current;
    private Parent threeHourly;
    private Parent daily;
    private Parent about;

    @FXML
    private AnchorPane hourly_anchorPane;
    @FXML
    private Label main_temp_label;
    @FXML
    private Label realFeel_temp_label;
    @FXML
    private Label wind_speed_label;
    @FXML
    private Label wind_direction_label;
    @FXML
    private ImageView wind_direction_icon;
    @FXML
    private Label pressure_label;
    @FXML
    private Label humidity_label;
    @FXML
    private Label rain_fall_label;
    @FXML
    private Label snowfall_label;
    @FXML
    private Label cityname_label;
    @FXML
    private Label clouds_label;
    @FXML
    private ImageView weather_icon;
    @FXML
    private Label uv_label;
    @FXML
    private Label description_label;
    @FXML
    private Label forecast_hour_label;
    @FXML
    private Pane menu_panel_pane;
    @FXML
    private ImageView menu_icon;

    private void setApi()
    {
        api = new WeatherHourlyForecastApiImpl(CITY_REQUEST, HOURS);
    }

    @FXML
    private void initialize()
    {
        loadCityName();

        if(CITY_REQUEST != null)
        {
            setApi();
            setTime();
            setTemp();
            setRealFeelTemp();
            setWindSpeed();
            setWindDirection();
            setPressure();
            setHumidity();
            setRainFall();
            setSnowFall();
            displayCityName();
            setCloudsCoverage();
            displayWindDirectionArrow();
            setWeatherIcon();
            setUV();
            setDescription();
        }
    }

    private void displayData()
    {
        displayTemp();
        displayCityName();
        displayRealFeelTemp();
        displayWindSpeed();
        displayHumidity();
        displayCloudsCoverage();
        displayRainFall();
        displaySnowFall();
        displayDescription();
        displayUV();
        displayPressure();
        displayWindDirection();
        displayWindDirectionArrow();
        displayWeatherIcon();
        displayTime();
    }

    public void swipeRight()
    {

    }

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


    public void plusHourOnClick()
    {
        if(INDEX < HOURS - 1)
        {
            INDEX++;
            displayData();
        }
    }

    public void minusHourOnClick()
    {
        if(INDEX > 0)
        {
            INDEX--;
            displayData();
        }
    }

    private void setTime()
    {
        time = api.getDateTime();
        displayTime();
    }

    private void setTemp()
    {
        temp = api.getTemperatureForecast();
        displayTemp();
    }

    private void setRealFeelTemp()
    {
        appTemp = api.getApparentTemperature();
        displayRealFeelTemp();
    }

    private void setWindSpeed()
    {
        windSpeed = api.getWindSpeed();
        displayWindSpeed();
    }

    private void setWindDirection()
    {
        windDirection = api.getAbbreviatedWindDirection();
        displayWindDirection();
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

    private void setCloudsCoverage()
    {
        cloudsCoverage = api.getCloudsCoverage();
        displayCloudsCoverage();
    }


    private void setWeatherIcon()
    {
        weatherCodeIcon = api.getWeatherIconCode();
        displayWeatherIcon();
    }

    private void setUV()
    {
        uvIndex = api.getUV();
        displayUV();
    }

    private void setDescription()
    {
        description = api.getDescription();
        displayDescription();
    }

    private void displayTime()
    {
        forecast_hour_label.setText(time.get(INDEX).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }

    private void displayWeatherIcon()
    {
        String iconUrl = String.format("icons_weather/%s.png", weatherCodeIcon.get(INDEX));

        weather_icon.setImage(new Image(iconUrl));
    }

    private void displayWindDirectionArrow()
    {
        int degree = rotateArrow.getRotateValue();
        wind_direction_icon.setRotate(degree);
    }


    private void displayCloudsCoverage()
    {
        clouds_label.setText(String.valueOf(cloudsCoverage.get(INDEX)));
    }

    private void displayCityName()
    {
        cityname_label.setText(CITY_NAME);
    }

    private void displaySnowFall()
    {
        snowfall_label.setText(FORMAT_PRECISION.format(snowFall.get(INDEX)));
    }

    private void displayRainFall()
    {
        rain_fall_label.setText(FORMAT_PRECISION.format(rainFall.get(INDEX)));
    }

    private void displayHumidity()
    {
        humidity_label.setText(String.valueOf(humidity.get(INDEX)));
    }

    private void displayPressure()
    {
        pressure_label.setText(FORMAT_PRECISION.format(pressure.get(INDEX)));
    }

    private void displayWindDirection()
    {
        Controller.WIND_DIRECTION = windDirection.get(INDEX);
        wind_direction_label.setText(Controller.WIND_DIRECTION);

    }

    private void displayWindSpeed()
    {
        wind_speed_label.setText(FORMAT_PRECISION.format(windSpeed.get(INDEX) * 3.6));

    }

    private void displayRealFeelTemp()
    {
        realFeel_temp_label.setText("/ " + String.valueOf(appTemp.get(INDEX)));
    }

    private void displayTemp()
    {
        main_temp_label.setText(String.valueOf(temp.get(INDEX)));
    }

    private void displayUV()
    {
        uv_label.setText(FORMAT_PRECISION.format(uvIndex.get(INDEX)));
    }


    private void displayDescription()
    {
        description_label.setText(description.get(INDEX));
    }

    public void switchToCurrent() throws IOException
    {
        current = FXMLLoader.load(getClass().getResource("/fxml/current.fxml"));
        hourly_anchorPane.getChildren().addAll(current);
    }

    public void switchToHourly() throws IOException
    {

    }

    public void switchToDaily() throws IOException
    {
        daily = FXMLLoader.load(getClass().getResource("/fxml/daily.fxml"));
        hourly_anchorPane.getChildren().addAll(daily);
    }

    public void aboutProgram() throws IOException
    {
        about = FXMLLoader.load(getClass().getResource("/fxml/widget.fxml"));
        hourly_anchorPane.getChildren().addAll(about);
    }

    private void loadCityName()
    {
        CITY_REQUEST = saveCityName.loadCityName();
    }
}
