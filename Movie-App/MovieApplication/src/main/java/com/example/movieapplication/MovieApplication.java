package com.example.movieapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieApplication extends Application {
    public static MovieListShow controller = null;
    public static LogInController logInController;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MovieApplication.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        logInController = fxmlLoader.getController();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            onExitButtonClick(stage);
        });
    }
    public void onExitButtonClick(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit the app!");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully exited");
            stage.close();
        }
    }

    public static void main(String[] args){
        launch();
    }
}