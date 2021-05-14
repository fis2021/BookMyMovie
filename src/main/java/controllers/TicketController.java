package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class TicketController extends ChangeController {

    @FXML
    private Text ticketMessage;

    @FXML
    public void handleCheckAction(ActionEvent event) throws  IOException{
        ticketMessage.setText("Ticket Succesfully Booked!");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}
