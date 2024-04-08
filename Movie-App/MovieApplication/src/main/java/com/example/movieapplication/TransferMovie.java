package com.example.movieapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TransferMovie implements Initializable {
    static String fromCompanyName = ReqMovieList.companyName;
    static String sentMovieName;
    static String toCompanyName;
    @FXML
    public Label movieNameLabel;
    @FXML
    public Label companyNameLabel;
    public Label successfulMessage;
    List<String> movieName = ReqMovieList.movieNameList();
    @FXML
    private ChoiceBox<String> movieChoiceBox ;
    @FXML
    private ChoiceBox<String> productionCompanyChoiceBox;
    @FXML
    private Label productionCompanyLabel;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onTransferButtonClick(ActionEvent actionEvent) throws IOException {
        if (!(movieNameLabel.getText().isEmpty()) && !(companyNameLabel.getText().isEmpty())) {
            successfulMessage.setText("Movie successfully transferred");
            MovieClient.clientTransfer(MovieClient.companyMovieList, transfer(), toCompanyName);
        }
        else{
            successfulMessage.setText("Please select first!!");
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
          productionCompanyLabel.setText(ReqMovieList.companyName.toUpperCase());
          movieChoiceBox.getItems().addAll(movieName);
          productionCompanyChoiceBox.getItems().addAll(MovieClient.companyNameList);
          movieChoiceBox.setOnAction(this::selectMovie);
          productionCompanyChoiceBox.setOnAction(this::selectCompany);
    }
    public void selectMovie(ActionEvent event)
    {
        String myChoice = movieChoiceBox.getValue();
        movieNameLabel.setText(myChoice);
        sentMovieName = movieNameLabel.getText();

    }
    public void selectCompany(ActionEvent event)
    {
        String myCompanyChoice = productionCompanyChoiceBox.getValue();
        companyNameLabel.setText(myCompanyChoice);
        toCompanyName = companyNameLabel.getText();
    }
    public Movie transfer()
    {
        for(Movie m : MovieClient.companyMovieList)
        {
            if(sentMovieName.equalsIgnoreCase(m.getName()))
            {
                MovieClient.companyMovieList.remove(m);
                return m;
            }
        }
        return null;
    }

}
