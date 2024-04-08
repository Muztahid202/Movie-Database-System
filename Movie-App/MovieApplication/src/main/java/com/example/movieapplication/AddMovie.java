package com.example.movieapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMovie implements Initializable {
    static Movie movieAdd;
    boolean flag = true;
    @FXML
    private TextField yearField;
    @FXML
    private TextField genre1Field;
    @FXML
    private TextField genre2Field;
    @FXML
    private TextField genre3Field;
    @FXML
    private TextField runningTimeField;
    @FXML
    private TextField budgetField;
    @FXML
    private TextField revenueField;
    @FXML
    private Label checkingLabel;
    @FXML
    private TextField nameField;
    @FXML
    private Label companyNameLabel;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Movie addingMovie() {
        try {
            String name = nameField.getText();
            String releaseYear = yearField.getText();
            String genre1 = genre1Field.getText();
            String genre2 = genre2Field.getText();
            String genre3 = genre3Field.getText();
            String runningTime = runningTimeField.getText();
            String budget = budgetField.getText();
            String revenue = revenueField.getText();
            movieAdd = new Movie(name, Integer.parseInt(releaseYear), genre1, genre2, genre3, Integer.parseInt(runningTime), ReqMovieList.companyName, Integer.parseInt(budget), Integer.parseInt(revenue));
            for (int i = 0; i < MovieClient.companyMovieList.size(); i++) {
                if (nameField.getText().equalsIgnoreCase(MovieClient.companyMovieList.get(i).getName())) {
                    flag = false;
                    break;
                }
            }
            if (!(nameField.getText().isEmpty()) && flag) {
                MovieClient.companyMovieList.add(movieAdd);
                return movieAdd;
            } else {
                checkingLabel.setText("Please input name of the movie or the movie already exist");
            }
        } catch (Exception e) {
            checkingLabel.setText("Please input data in right format!!");
            flag = false;
        }
        return null;
    }
    public void onAddClick(ActionEvent actionEvent) throws IOException {
        // write movie
        Movie m = addingMovie();
        if (m != null || flag) {
            MovieClient.clientWrite(m);
        }
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        companyNameLabel.setText(ReqMovieList.companyName.toUpperCase());
    }
}
