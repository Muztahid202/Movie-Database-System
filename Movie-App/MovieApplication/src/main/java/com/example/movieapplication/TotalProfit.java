package com.example.movieapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.movieapplication.ReqMovieList.companyName;

public class TotalProfit implements Initializable {
    @FXML
    private Label profitLabel;
    @FXML
    private Label productionCompanyName;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productionCompanyName.setText(companyName.toUpperCase());
        profitLabel.setText("Total Profit of The Company: " + SearchClass.total_profit_company(MovieClient.companyMovieList));
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
