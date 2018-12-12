package gui_fx;

import gui_fx.rotates.RotateArrow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;
import service.GeoDataImpl;
import service.WeatherCurrentApiImpl;
import util.SaveCityName;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller
{
    private WeatherCurrentApiImpl api;
    private static Controller instance = null;
    //private CurrentWeatherHandler apiHandler;

    private RotateArrow rotateArrow = RotateArrow.getInstance();

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final static DecimalFormat FORMAT_PRECISION = new DecimalFormat("#0.0");

    private static String CITY_REQUEST;
    public static String WIND_DIRECTION;

    private Parent main;
    private Parent about;

    private SaveCityName saveCityName = SaveCityName.getInstance();
    private GeoDataImpl geoData = GeoDataImpl.getInstance();

    private List<String> citiesList;

    @FXML
    private Label top_welcome_label;
    @FXML
    private AnchorPane main_anchorPane;
    @FXML
    private AnchorPane about_anchorPane;
    @FXML
    private Button start_button;
    @FXML
    private Button refresh_button;
    @FXML
    protected Label main_temp_label;
    @FXML
    protected Label realFeel_temp_label;
    @FXML
    protected Label wind_speed_label;
    @FXML
    protected Label wind_direction_label;
    @FXML
    protected ImageView wind_direction_icon;
    @FXML
    protected Label pressure_label;
    @FXML
    protected Label humidity_label;
    @FXML
    protected Label rain_fall_label;
    @FXML
    protected Label snowfall_label;
    @FXML
    protected Label cityname_label;
    @FXML
    protected Label clouds_label;
    @FXML
    protected Label refresh_time_label;
    @FXML
    protected ImageView weather_icon;
    @FXML
    private TextField search_city_textField;

    private ListView listView = new ListView();
    private ContextMenu contextMenu;

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

    private void listView()
    {
        ObservableList<String> rawData= FXCollections.observableArrayList();
        FilteredList<String> filteredList= new FilteredList<>(rawData, data -> true);
        listView.setItems(filteredList);
        search_city_textField.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredList.setPredicate(data -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseSearch=newValue.toLowerCase();
                return Boolean.parseBoolean(String.valueOf(data.contains(lowerCaseSearch)));
            });
        }));


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

    public void searchingCity()
    {
        citiesList = geoData.getCityName();
        TextFields.bindAutoCompletion(search_city_textField, citiesList).setVisibleRowCount(10);
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
        Controller.WIND_DIRECTION = api.getAabbreviatedWindDirection();
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
        double temp = api.getTemperature();
        main_temp_label.setText(String.valueOf(temp));
    }


    private void loadCityName()
    {
        CITY_REQUEST = saveCityName.loadCityName();
    }

    private void saveCityName()
    {
        saveCityName.saveCityName(CITY_REQUEST);
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
