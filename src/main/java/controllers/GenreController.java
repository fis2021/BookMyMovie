package controllers;

import controllers.ChangeController;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class GenreController extends ChangeController {

    @FXML
    public void handleGenreAction(ActionEvent event) throws  IOException{
        changeScene(event, "genre.fxml");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}