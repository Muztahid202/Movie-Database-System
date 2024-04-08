package com.example.movieapplication;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.movieapplication.ReqMovieList.companyName;

public class MostRecentMovies implements Initializable {
    @FXML
    private Label productionCompanyName;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TableView tableView;
    @FXML
    private TableColumn<Movie, Integer> budgetCol;

    @FXML
    private TableColumn<Movie, String> genre1Col;

    @FXML
    private TableColumn<Movie, String> genre2Col;

    @FXML
    private TableColumn<Movie, String> genre3Col;

    @FXML
    private TableColumn<Movie, String> nameCol;

    @FXML
    private TableColumn<Movie, Integer> releaseYearCol;

    @FXML
    private TableColumn<Movie, Integer> revenueCol;

    @FXML
    private TableColumn<Movie, Integer> runningTimeCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productionCompanyName.setText(companyName.toUpperCase());
        productionCompanyName.setText(companyName.toUpperCase());
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        releaseYearCol.setCellValueFactory(new PropertyValueFactory<>("release_year"));
        genre1Col.setCellValueFactory(new PropertyValueFactory<>("genre1"));
        genre2Col.setCellValueFactory(new PropertyValueFactory<>("genre2"));
        genre3Col.setCellValueFactory(new PropertyValueFactory<>("genre3"));
        runningTimeCol.setCellValueFactory(new PropertyValueFactory<>("running_time"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));

        tableView.setItems(FXCollections.observableList(SearchClass.search_recent_movie(MovieClient.companyMovieList)));

    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
