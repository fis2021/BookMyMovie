package controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class BookSelectedController extends ChangeController{

    @FXML
    private Text BookSelectedMessage;

    @FXML
    public void handleBookSelectedAction(ActionEvent event) throws IOException {
        changeScene(event, "ticketbooked.fxml");
    }
    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}