package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import java.io.IOException;

public class RateController extends ChangeController{

    @FXML
    private Text rateMessage;
    @FXML
    private TextField nameField;
    @FXML
    private ChoiceBox stars;

    @FXML
    public void initialize() {
        stars.getItems().addAll(1,2,3,4,5);
    }

    @FXML
    public void handleRateAction(){
        try {
            UserService.addRate(nameField.getText(), (int) stars.getValue());
            rateMessage.setText("Movie rated!");
        } catch (Exception e) {
            rateMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }
}