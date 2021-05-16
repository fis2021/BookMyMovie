package controllers;

import javafx.fxml.FXML;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CustomerMenuController extends ChangeController {


    @FXML
    private TableColumn<Movie, String> NameColumn;
    @FXML
    private TableColumn<Movie, String> DescriptionColumn;
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

        DescriptionColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(
                    UserService.findMovie(cellData.getValue().getName()).getDescription()
            );
        });

        table.setItems(observableList);
    }

    @FXML
    public void handleBookSelectedAction(ActionEvent event) throws  IOException {
        changeScene(event, "booking.fxml");
    }
    @FXML
    public void handleBuySelectedAction(ActionEvent event) throws  IOException{
        changeScene(event, "buy.fxml");
    }
    @FXML
    public void handleRateAction(ActionEvent event) throws  IOException{
        changeScene(event, "rate.fxml");
    }
    @FXML
    public void handleGenreAction(ActionEvent event) throws  IOException{
        changeScene(event, "genre.fxml");
    }
    @FXML
    public void handleLogoutAction(ActionEvent event) throws  IOException{
        UserService.logout();
        changeScene(event, "login.fxml");
    }

}