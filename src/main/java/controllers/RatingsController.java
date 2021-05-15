package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Movie;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RatingsController extends ChangeController {

    @FXML
    private TableColumn<Movie, String> NameColumn;
    @FXML
    private TableColumn<Movie, String> RateColumn;
    @FXML
    private TableView<Movie> table;

    @FXML
    public void initialize() {

        ObservableList<Movie> observableList =
                FXCollections.observableList(UserService.findMovies());

        NameColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(
                    UserService.findMovie(cellData.getValue().getName()).getName()
            );
        });
        RateColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(
                    UserService.findMovie(cellData.getValue().getName()).getRating()
            );
        });

        table.setItems(observableList);
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "cinemaMenu.fxml");
    }

}