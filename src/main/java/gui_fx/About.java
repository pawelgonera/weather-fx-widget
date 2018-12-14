package gui_fx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class About
{
    private Parent main;
    private Parent about;

    @FXML
    private AnchorPane about_anchorPane;


    public void loadMain() throws IOException
    {
        main = FXMLLoader.load(getClass().getResource("/fxml/current.fxml"));
        about_anchorPane.getChildren().addAll(main);

    }
}
