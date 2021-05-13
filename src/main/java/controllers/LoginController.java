package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import exceptions.WrongPasswordException;
import services.UserService;

public class LoginController {

    @FXML
    private Text LoginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;


    @FXML
    public void handleLoginAction() {
        try {
            UserService.login(usernameField.getText(), passwordField.getText());
        } catch (WrongPasswordException e) {
            LoginMessage.setText(e.getMessage());
        } catch(Exception e){
            LoginMessage.setText(e.getMessage());
        }
    }
}
.