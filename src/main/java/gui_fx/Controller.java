package gui_fx;

import gui_fx.rotates.RotateArrow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.textfield.TextFields;
import service.GeoDataImpl;
import service.WeatherCurrentApiImpl;
import util.SaveCityName;
import validator.FixCityName;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller
{
    private WeatherCurrentApiImpl api;
    private static Controller instance = null;
    //private CurrentWeatherHandler apiHandler;

    private RotateArrow rotateArrow = RotateArrow.getInstance();

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    protected static String CITY_REQUEST;
    public static String WIND_DIRECTION;

    private Parent current;
    private Parent threeHourly;
    private Parent daily;
    private Parent hourly;
    private Parent about;

    private SaveCityName saveCityName = SaveCityName.getInstance();
    private GeoDataImpl geoData = GeoDataImpl.getInstance();
    private FixCityName fixCityName = FixCityName.getInstance();

    private List<String> citiesList;
    private List<String> countryList;
    private List<String> citiesMap = new LinkedList<>();

    @FXML
    private AnchorPane main_anchorPane;
    @FXML
    private Button refresh_button;
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
    private Label refresh_time_label;
    @FXML
    private ImageView weather_icon;
    @FXML
    private Label uv_label;
    @FXML
    private Label sunrise_label;
    @FXML
    private Label sunset_label;
    @FXML
    private Label description_label;
    @FXML
    private TextField search_city_textField;
    @FXML
    private Pane menu_panel_pane;
    @FXML
    private ImageView menu_icon;
    @FXML
    private Button daily_button;
    @FXML
    private Button hourly_button;
    @FXML
    private Button current_button;
    @FXML
    private ContextMenu searching_contexMenu;
    @FXML
    private MenuItem cities_menuItem;
    @FXML
    private ImageView refresh_icon;
    @FXML
    private Button about_button;


    public static Controller getInstance()
    {
        if(instance == null)
            instance = new Controller();

        return instance;
    }

    private void setApi()
    {
        api = new WeatherCurrentApiImpl(CITY_REQUEST);
    }

    @FXML
    private void initialize()
    {
        onClickRefreshData();
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

    public void onEnterPressed()
    {
        search_city_textField.setOnKeyPressed((KeyEvent event) ->
        {
            if(event.getCode() == KeyCode.ENTER)
            {
                foundCity();
            }
        });
    }

    private void foundCity()
    {
        CITY_REQUEST = search_city_textField.getText();
        saveCityName();
        onClickRefreshData();
    }

    @SuppressWarnings("unchecked")
    public void searchingCity()
    {
        citiesList = geoData.getCityName();
        countryList = geoData.getCountryName();
        for(int i = 0; i < citiesList.size(); i++)
        {
            citiesMap.add(citiesList.get(i) + " | " +  countryList.get(i));
        }

        TextFields.bindAutoCompletion(search_city_textField, citiesMap).setVisibleRowCount(10);
    }

    public void onClickRefreshData()
    {
        loadCityName();
        if(CITY_REQUEST != null)
        {
            setApi();
            displayTemp();
            displayRealFeelTemp();
            displayWindSpeed();
            displayWindDirection();
            displayPressure();
            displayHumidity();
            displayRainFall();
            displaySnowFall();
            try
            {
                displayCityName();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            displayCloudsCoverage();
            displayLastObservationTime();
            displayWindDirectionArrow();
            displayWeatherIcon();
            displayUV();
            displaySunrise();
            displaySunset();
            displayDescription();
        }
    }

    private void displayWeatherIcon()
    {
        String weatherCodeIcon = api.getWeatherIconCode();
        String iconUrl = String.format("icons_weather/%s.png", weatherCodeIcon);

        weather_icon.setImage(new Image(iconUrl));
    }

    private void displayWindDirectionArrow()
    {
        int degree = rotateArrow.getRotateValue();
        wind_direction_icon.setRotate(degree);
    }

    private void displayLastObservationTime()
    {
        LocalDateTime time = api.getLastObservationTime();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(time, api.getTimeZone().toZoneId());
        String timeFormat = time.plusSeconds(zonedDateTime.getOffset().getTotalSeconds()).format(FORMATTER);
        refresh_time_label.setText(timeFormat);
    }

    private void displayCloudsCoverage()
    {
        int clouds = api.getCloudsCoverage();
        clouds_label.setText(String.valueOf(clouds));
    }

    private void displayCityName() throws UnsupportedEncodingException
    {
        String cityName = api.getCityName();
        byte[] txtBytes = cityName.getBytes();
        String cityNameUTF8 = new String(txtBytes, "UTF-8");
        Hourly.CITY_NAME = cityNameUTF8;
        cityname_label.setText(cityNameUTF8);
    }

    private void displaySnowFall()
    {
        String snowfall = FORMAT_PRECISION.format(api.getAccumulatedSnowfall());
        snowfall_label.setText(snowfall);
    }

    private void displayRainFall()
    {
        String rainfall = FORMAT_PRECISION.format(api.getAccumulatedLiquidEquivalentPrecipitation());
        rain_fall_label.setText(rainfall);
    }

    private void displayHumidity()
    {
        int humidity = api.getHumidity();
        humidity_label.setText(String.valueOf(humidity));
    }

    private void displayPressure()
    {
        String pressure = FORMAT_PRECISION.format(api.getPressure());
        pressure_label.setText(String.valueOf(pressure));
    }

    private void displayWindDirection()
    {
        Controller.WIND_DIRECTION = api.getAbbreviatedWindDirection();
        wind_direction_label.setText(Controller.WIND_DIRECTION);
    }

    private void displayWindSpeed()
    {
        String windSpeed = FORMAT_PRECISION.format(api.getWindSpeed() * 3.6);
        wind_speed_label.setText(windSpeed);
    }

    private void displayRealFeelTemp()
    {
        double appTemp = api.getApparentTemperature();
        realFeel_temp_label.setText("/ " + String.valueOf(appTemp));
    }

    private void displayTemp()
    {
        BigDecimal temp = api.getTemperature();
        main_temp_label.setText(String.valueOf(temp));
    }

    private void displayUV()
    {
        double uvIndex = api.getUV();
        uv_label.setText(String.valueOf(FORMAT_PRECISION.format(uvIndex)));
    }

    private void displaySunrise()
    {
        LocalTime sunrise = api.getSunrise();
        sunrise_label.setText(String.valueOf(sunrise));
    }

    private void displaySunset()
    {
        LocalTime sunset = api.getSunset();
        sunset_label.setText(String.valueOf(sunset));
    }

    private void displayDescription()
    {
        String description = api.getDescription();
        description_label.setText(description);
    }

    private void loadCityName()
    {
        CITY_REQUEST = saveCityName.loadCityName();
    }

    private void saveCityName()
    {
        saveCityName.saveCityName(CITY_REQUEST);
    }

    public void switchToCurrent()
    {

    }

    public void switchToHourly() throws IOException
    {
        hourly = FXMLLoader.load(getClass().getResource("/fxml/hourly.fxml"));
        main_anchorPane.getChildren().addAll(hourly);
    }

    public void switchToDaily() throws IOException
    {
        daily = FXMLLoader.load(getClass().getResource("/fxml/daily.fxml"));
        main_anchorPane.getChildren().addAll(daily);
    }

    public void switchToThreeHourly() throws IOException
    {
        threeHourly = FXMLLoader.load(getClass().getResource("/fxml/three_hourly.fxml"));
        main_anchorPane.getChildren().addAll(threeHourly);
    }

    public void aboutProgram() throws IOException
    {
        about = FXMLLoader.load(getClass().getResource("/fxml/widget.fxml"));
        main_anchorPane.getChildren().addAll(about);
    }


}
