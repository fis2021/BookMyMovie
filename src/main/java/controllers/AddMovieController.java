package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class AddMovieController extends ChangeController {

    @FXML
    private Text addMovieMessage;
    @FXML
    private TextField nameField;
    @FXML
    private TextField genreField;
    @FXML
    private TextField descriptionField;
    @FXML
    public void handleAddMovieAction(ActionEvent event) throws  IOException {
        try {
            UserService.addMovie(nameField.getText(), genreField.getText(), descriptionField.getText());
            addMovieMessage.setText("Successfully added!");
            changeScene(event, "cinemaMenu.fxml");
        } catch (Exception e) {
            //LoginMessage.setText(e.getMessage());
        }
    }
    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "cinemaMenu.fxml");
    }
}
