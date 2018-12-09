package gui_fx;

import gui_fx.rotates.Rotate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import service.WeatherCurrentApiImpl;
import util.SaveCityName;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Controller
{
    private WeatherCurrentApiImpl api;

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    private static String CITY_REQUEST;

    private static String WIND_DIRECTION;

    private Parent main;

    private Parent about;

    private SaveCityName saveCityName = new SaveCityName();

    @FXML
    private Label top_welcome_label;
    @FXML
    private AnchorPane main_anchorPane;
    @FXML
    private AnchorPane about_anchorPane;
    @FXML
    private Button start_button;

    @FXML
    private Label main_temp_label = new Label();
    @FXML
    private Label realFeel_temp_label = new Label();
    @FXML
    private Label wind_speed_label = new Label();
    @FXML
    private Label wind_direction_label = new Label();
    @FXML
    private ImageView wind_direction_icon = new ImageView();
    @FXML
    private Label pressure_label = new Label();
    @FXML
    private Label humidity_label = new Label();
    @FXML
    private Label rain_fall_label = new Label();
    @FXML
    private Label snowfall_label = new Label();
    @FXML
    private Label cityname_label = new Label();
    @FXML
    private Label clouds_label = new Label();
    @FXML
    private Label refresh_time_label = new Label();
    @FXML
    private ImageView weather_icon = new ImageView();
    @FXML
    private TextField search_city_textField = new TextField();

    private void setApi()
    {
        api = new WeatherCurrentApiImpl(CITY_REQUEST);
    }

    public void setWelcomeTitle()
    {
        //top_welcome_label.setText("Welcome\nin\nWeather Widget");

    }

    public void clickOnAnchorPane()
    {
        search_city_textField.setPromptText("wyszukaj miasto");
    }

    public void setAvailableTextField()
    {

    }

    public void onEnterPressed()
    {


        search_city_textField.setOnKeyPressed((KeyEvent event) ->
        {
            if(event.getCode() == KeyCode.ENTER)
            {
                findCity();
            }
        });

    }

    private void findCity()
    {
        CITY_REQUEST = search_city_textField.getText();
        saveCityName();
        onClickRefreshData();
    }

    private void displayWeatherIcon()
    {
        String weatherCodeIcon = api.getWeatherIconCode();
        String iconUrl = String.format("icons_weather/%s.png", weatherCodeIcon);

        weather_icon.setImage(new Image(iconUrl));
    }

    private int getRotateValue()
    {
        String windDir = WIND_DIRECTION;

        switch(windDir)
        {
            case "N":
                return Rotate.N.getDegree();
            case "S":
                return Rotate.S.getDegree();
            case "E":
                return Rotate.E.getDegree();
            case "W":
                return Rotate.W.getDegree();
            case "NE":
                return Rotate.NE.getDegree();
            case "SE":
                return Rotate.SE.getDegree();
            case "SW":
                return Rotate.SW.getDegree();
            case "NW":
                return Rotate.NW.getDegree();
            case "NNE":
                return Rotate.NNE.getDegree();
            case "ENE":
                return Rotate.ENE.getDegree();
            case "ESE":
                return Rotate.ESE.getDegree();
            case "SSE":
                return Rotate.SSE.getDegree();
            case "SSW":
                return Rotate.SSW.getDegree();
            case "WSW":
                return Rotate.WSW.getDegree();
            case "WNW":
                return Rotate.WNW.getDegree();
            case "NNW":
                return Rotate.NNW.getDegree();
            default:
                return 0;
        }
    }

    private void displayWindDirectionArrow()
    {
        int degree = getRotateValue();
        wind_direction_icon.setRotate(degree);
    }

    private void displayLastObservationTime()
    {
        LocalDateTime time = api.getLastObservationTime();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(time, api.getTimeZone().toZoneId());
        String timeFormat = time.plusSeconds(zonedDateTime.getOffset().getTotalSeconds()).format(FORMATTER);
        refresh_time_label.setText(String.valueOf(timeFormat));
    }

    private void displayCloudsCoverage()
    {
        int clouds = api.getCloudsCoverage();
        clouds_label.setText(String.valueOf(clouds));
    }

    private void displayCityName()
    {
        String cityName = api.getCityName();
        cityname_label.setText(cityName);
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
        WIND_DIRECTION = api.getAabbreviatedWindDirection();
        wind_direction_label.setText(WIND_DIRECTION);

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
        double temp = api.getTemperature();
        main_temp_label.setText(String.valueOf(temp));
    }

    public void onMouseEntered()
    {
        setWelcomeTitle();
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
            displayCityName();
            displayCloudsCoverage();
            displayLastObservationTime();
            displayWindDirectionArrow();
            displayWeatherIcon();
        }
    }

    private void loadCityName()
    {
        try
        {
            CITY_REQUEST = saveCityName.loadCityName();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void saveCityName()
    {
        try
        {
            System.out.println(CITY_REQUEST);
            saveCityName.saveCityName(CITY_REQUEST);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void aboutProgram() throws IOException
    {
        about = FXMLLoader.load(getClass().getResource("/fxml/widget.fxml"));
        main_anchorPane.getChildren().addAll(about);
    }

    public void loadMain() throws IOException
    {
        main = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        about_anchorPane.getChildren().addAll(main);
    }

}
