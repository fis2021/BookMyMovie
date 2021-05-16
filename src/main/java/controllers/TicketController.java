package controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.io.IOException;

public class TicketController extends ChangeController {

    @FXML
    private Text ticketMessage;

    @FXML
    public void handleCheckAction(){
        ticketMessage.setText("Ticket Booked Successfully!");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}
