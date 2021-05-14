package controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class BuySelectedController extends ChangeController{

    @FXML
    private Text BuySelectedMessage;

    public void handleBuySelectedAction(ActionEvent event) throws  IOException {
        try {
            changeScene(event, "ticketbought.fxml");
        } catch (Exception e) {
            BuySelectedMessage.setText(e.getMessage());
        }
    }
    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}
