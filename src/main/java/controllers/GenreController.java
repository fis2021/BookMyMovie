package controllers;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Movie;
import services.UserService;
import javafx.event.ActionEvent;
import java.io.IOException;

public class GenreController extends ChangeController {

    @FXML
    private TableColumn<Movie, String> MovieColumn;
    @FXML
    private TableColumn<Movie, String> MovieGenreColumn;
    @FXML
    private TableView<Movie> table2;
    @FXML
    public void initialize() {


        ObservableList<Movie> observableList =
                FXCollections.observableList(UserService.findMovies());

        MovieGenreColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(
                    UserService.findMovie(cellData.getValue().getName()).getGenre()
            );
        });

        MovieColumn.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(
                    UserService.findMovie(cellData.getValue().getName()).getName()
            );
        });

        table2.setItems(observableList);
    }

    @FXML
    public void handleGenreAction(ActionEvent event) throws  IOException{
        changeScene(event, "genre.fxml");
    }

    @FXML
    public void handleBackAction(ActionEvent event) throws  IOException{
        changeScene(event, "customerMenu.fxml");
    }

}