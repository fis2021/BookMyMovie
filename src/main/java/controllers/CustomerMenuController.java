package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class CustomerMenuController extends ChangeController {
    @FXML

    public void handleBookSelectedAction(ActionEvent event) throws  IOException {
        changeScene(event, "booking.fxml");
    }
    @FXML
    public void handleBuySelectedAction(ActionEvent event) throws  IOException{
        changeScene(event, "buy.fxml");
    }
    @FXML
    public void handleGenreAction(ActionEvent event) throws  IOException{
        changeScene(event, "genre.fxml");
    }
    @FXML
    public void handleLogoutAction(ActionEvent event) throws  IOException{
        changeScene(event, "login.fxml");
    }

}