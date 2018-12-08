package gui_fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import service.WeatherCurrentApiImpl;

import java.io.IOException;
import java.text.DecimalFormat;

public class Controller
{
    private WeatherCurrentApiImpl api;

    private Parent main;
    @FXML
    private Label top_welcome_label;
    @FXML
    private AnchorPane main_pane;
    @FXML
    private Button start_button;

    @FXML
    private Label main_temp_label = new Label();
    @FXML
    private Label realFeel_temp_label;
    @FXML
    private Label wind_speed_label;
    @FXML
    private Label wind_direction_label;
    @FXML
    private ImageView wind_direction_icon;

    private void setApi()
    {
        api = new WeatherCurrentApiImpl("Kalisz");
    }

    public void setWelcomeTitle()
    {
        //top_welcome_label.setText("Welcome\nin\nWeather Widget");

    }

    private void displayWindDirection()
    {
        String windDirection = api.getAabbreviatedWindDirection();
        wind_direction_label.setText(windDirection);

    }

    private void displayWindSpeed()
    {
        String windSpeed = new DecimalFormat("#.00").format(api.getWindSpeed() * 3.6);
        //double windSpeed = Double.parseDouble("13,38");
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

    public void onMouseEnteredDisplayTemp()
    {
        setApi();
        displayTemp();
        displayRealFeelTemp();
        displayWindSpeed();
        displayWindDirection();
    }

    public void loadMain() throws IOException
    {
        main = FXMLLoader.load(getClass().getResource("/main.fxml"));
        main_pane.getChildren().addAll(main);
    }

}
