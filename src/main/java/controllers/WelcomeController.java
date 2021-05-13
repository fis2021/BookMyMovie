package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class WelcomeController extends ChangeController{

    @FXML
    public void handleRegisterAction(ActionEvent event) throws  IOException{
        changeScene(event, "register.fxml");
    }
    @FXML
    public void handleLoginAction(ActionEvent event) throws  IOException {
        changeScene(event, "login.fxml");
    }
}