package controllers;

import controllers.ChangeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import services.UserService;

public class CinemaMenuController extends ChangeController {

    @FXML
    public void handleAddMovieAction(ActionEvent event) throws  IOException{
        changeScene(event, "addMovie.fxml");
    }
    @FXML
    public void handleDeleteMovieAction(ActionEvent event) throws  IOException {
        changeScene(event, "deleteMovie.fxml");
    }
    @FXML
    public void handleLogoutAction(ActionEvent event) throws  IOException {
        UserService.logout();
        changeScene(event, "login.fxml");
    }
}