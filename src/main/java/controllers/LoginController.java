package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import java.util.Objects;
import java.io.IOException;
import javafx.event.ActionEvent;
import model.User;

public class LoginController extends ChangeController{

    @FXML
    private Text LoginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;


    @FXML
    public void handleLoginAction(ActionEvent event) throws  IOException {
        try {
            User user = UserService.login(usernameField.getText(), passwordField.getText());
            if (Objects.equals(user.getRole(), "Customer")) {
                changeScene(event, "customerMenu.fxml");
            } else {
                changeScene(event, "cinemaMenu.fxml");
            }
        } catch (Exception e) {
            LoginMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "welcome.fxml");
    }

}
