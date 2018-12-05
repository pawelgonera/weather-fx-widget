package gui_fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.WeatherCurrentApiImpl;

import java.io.IOException;

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

    private void setApi()
    {
        api = new WeatherCurrentApiImpl("Kalisz");
    }

    public void setWelcomeTitle()
    {
        //top_welcome_label.setText("Welcome\nin\nWeather Widget");

    }

    private void displayTemp()
    {
        double temp = api.getTemperature();
        System.out.println(temp);
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
    }

    public void loadMain() throws IOException
    {
        main = FXMLLoader.load(getClass().getResource("../../resources/main.fxml"));
        main_pane.getChildren().addAll(main);
    }

}
