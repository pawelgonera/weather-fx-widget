import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application
{
    public static void main(String[] args)
    {
        /*WeatherCurrentApiImpl weatherApi = new WeatherCurrentApiImpl();

        double temp = weatherApi.getTemperature("Kalisz");

        System.out.println(temp + " stopni Celcjusza");

        System.out.println("**********************************************");

        WeatherHourlyForecastApiImpl weatherHourlyForecastApi = new WeatherHourlyForecastApiImpl();

        List<Double> datas = weatherHourlyForecastApi.getTemperatureForecast("Kalisz", 48);

        int i = 1;
        for(Double temps : datas)
            System.out.println(temps + " Time: " + LocalTime.now().plusHours(i++));
            */

        //WeatherCurrentApiImpl api = new WeatherCurrentApiImpl("Kalisz");

        //ClientRequestValidation clientRequestValidation = ClientRequestValidation.getInstance();

        //System.out.println(api.getWeatherIconCode());

        /*try
        {
            System.out.println(clientRequestValidation.validateCityNameRequest("Chrząszczyżewoszyce"));
        } catch (WrongCityNameRequestException e) {
            e.printStackTrace();
        }
        */

        /*
        System.out.println("Temperaturta: " + api.getTemperature() + " C");
        System.out.println("Kierunek wiatru: " + api.getWindDirection());
        System.out.println("Wilgotność: " + api.getHumidity() + " %");
        System.out.println("Pora dnia: " + (api.getPartOfTheDay().equalsIgnoreCase("D") ? "Dzień " : " Noc"));
        System.out.println("Ciśnienie: " + api.getPressure() + " hPa");
        System.out.println("Ostatnia data obserwacji: " + api.getLastObservationTime());
        System.out.println("Zachmurzenie: " + api.getCloudsCoverage() + " %");
        System.out.println("Widoczność: " + api.getVisibility() + " km");
        System.out.println("Prędkość wiatru: " + new DecimalFormat("#.00").format(api.getWindSpeed() * 3.6) + " km/h");
        System.out.println("Temperatura odczuwalna: " + api.getApparentTemperature() + " C");
        System.out.println("Temperatura punktu rosy: " + api.getDewPoint() + " C");
        System.out.println("Promieniowanie UV: " + api.getUV());
        System.out.println("Aktualny czas: " + api.getDateTime().atZone(ZoneId.systemDefault()).withZoneSameInstant(api.getTimeZone()).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Opady deszczu: " + new DecimalFormat("#0.0").format(api.getAccumulatedLiquidEquivalentPrecipitation()) + " mm");
        System.out.println("Opady śniegu: " + new DecimalFormat("#0.0").format(api.getAccumulatedSnowfall()) + " mm");
        System.out.println("Nazwa miasta: " + api.getCityName());
        System.out.println("Wschód słońca: " + api.getSunrise());
        System.out.println("Zachód słońca: " + api.getSunset());
        */



        ///CityNamesApi cityApi = new CityNamesApiImpl("PL");

        //System.out.println(cityApi.getCityName());

        //CitiesNameListImpl citiesNameList = CitiesNameListImpl.getInstance();

        //System.out.println(citiesNameList.getStateName());

        //GeoDataImpl geoData = GeoDataImpl.getInstance();

        //List<Long> citiesList = geoData.getDataId();
        //List<String> countryName = geoData.getCountryName();


        //System.out.println(citiesList.contains("Wiel"));

        //System.out.println(citiesList.get(0));

        //FixCityName fixCityName = FixCityName.getInstance();

        //System.out.println(fixCityName.fixName("Łódź |"));


        /*for(int i = 0; i < citiesList.size(); i++)
        {
            citiesList.set(i, citiesList.get(i) + " | " +  countryName.get(i));
        }*/

        //System.out.println(citiesList);


        launch(args);

        //System.out.println(LocalDate.now());



    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/current.fxml"));
        primaryStage.setTitle("Weather Widget - welcome");
        primaryStage.setScene(new Scene(root, 400, 400, Color.rgb( 164, 248, 255)));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
