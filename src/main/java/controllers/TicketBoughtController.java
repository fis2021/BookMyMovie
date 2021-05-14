package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class TicketBoughtController extends ChangeController {

    @FXML
    private Text ticketboughtMessage;

    @FXML
    public void handleCheckAction(ActionEvent event) throws  IOException{
        ticketboughtMessage.setText("Ticket Succesfully Bought!");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}