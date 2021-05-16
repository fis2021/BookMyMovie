package controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.io.IOException;

public class TicketBoughtController extends ChangeController {

    @FXML
    private Text ticketboughtMessage;

    @FXML
    public void handleCheckAction(){
        ticketboughtMessage.setText("Ticket Succesfully Bought!");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}