package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class DeleteMovieController extends ChangeController{

    @FXML
    private Text deleteMovieMessage;
    @FXML
    private TextField nameField;
    @FXML
    public void handleDeleteMovieAction(ActionEvent event) throws IOException{
         try {
                UserService.deleteMovie(nameField.getText());
                changeScene(event, "cinemaMenu.fxml");
            } catch (Exception e) {
                deleteMovieMessage.setText(e.getMessage());
            }
    }
    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "cinemaMenu.fxml");
    }

}
