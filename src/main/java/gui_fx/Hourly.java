package gui_fx;

import gui_fx.rotates.RotateArrow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import service.WeatherHourlyForecastApiImpl;
import util.SaveCityName;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    public static String WIND_DIRECTION;
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
    private String cityName;

    private Parent current;
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
            //System.out.println(CITY_REQUEST);
            setApi();
            setTemp();
            setRealFeelTemp();
            /*setWindSpeed();
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
            */
            //setDescription();

        }
    }

    private void displayData()
    {
        displayTemp();
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
    }

    public void plusHourOnClick()
    {
        if(INDEX < HOURS - 1)
        {
            INDEX++;
            displayTemp();
            displayRealFeelTemp();
        }
    }

    public void minusHourOnClick()
    {
        if(INDEX > 0)
        {
            INDEX--;
            displayTemp();
            displayRealFeelTemp();
        }
    }

    private void setTemp()
    {
        temp = api.getTemperatureForecast();
        System.out.println(temp.size());
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
        cityName = api.getCityName().get(0);
        cityname_label.setText(cityName);
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
        WIND_DIRECTION = windDirection.get(INDEX);
        wind_direction_label.setText(WIND_DIRECTION);

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
        uv_label.setText(String.valueOf(uvIndex.get(INDEX)));
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

    public void switchToHourly()
    {

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
