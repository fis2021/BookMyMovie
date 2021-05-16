package controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;

public class BuySelectedController extends ChangeController{

    public void handleBuySelectedAction(ActionEvent event) throws  IOException {
            changeScene(event, "ticketbought.fxml");
    }
    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}
