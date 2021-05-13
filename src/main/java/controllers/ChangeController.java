package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.UserService;

import java.io.IOException;
import java.util.Objects;

abstract class ChangeController {
    public void changeScene(ActionEvent event, String fxmlname) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource(
                        fxmlname)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}