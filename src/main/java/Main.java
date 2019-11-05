import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);

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
