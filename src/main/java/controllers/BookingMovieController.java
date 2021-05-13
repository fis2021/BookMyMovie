package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Booking;
import services.BookingService;
import services.UserService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingMovieController {
    @FXML
    private Label tfilm;
    @FXML
    private Label rasp;
    @FXML
    private TextField locuri;
    @FXML
    private Button buton;

    public void initialize() {
        buton.setDisable(false);
        /*  tfilm.setText(SessionService.getSelectedScreening().getMovieTitle());*/


    }

    public void onBookAction() {
        try {
            if (locuri.getText().isEmpty()) {
                rasp.setText("You need to book seats first!");

            }
            if ((Integer.parseInt(locuri.getText()) < 1)) {
                rasp.setText("You need to book at least 1 seat!");
            } else {
                Booking booking = new Booking(null, UserService.getLoggedInUser().getUsername(), UserService.getSelectedScreening().getId(), Integer.parseInt(locuri.getText()));
                rasp.setText("Enjoy!");
                BookingService.addBooking(booking);
                buton.setDisable(true);
            }

        } catch (Exception e) {

        }
    }

}


