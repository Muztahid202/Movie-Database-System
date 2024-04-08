package com.example.movieapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
public class LogInController {
    @FXML
    private AnchorPane scenePane;
    static String userCompany;
    @FXML
    private Label verificationLabel;
    @FXML
    private TextField userCompanyName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onLogInClick(ActionEvent actionEvent) throws IOException {
        userCompany = userCompanyName.getText();
        if (!userCompanyName.getText().isEmpty()) {
            MovieClient.clientCreate(userCompany);
        }
    }

    public void respond(Stage stage) throws IOException {
        System.out.println(MovieClient.companyMovieList.size());
        if (MovieClient.companyMovieList.size() != 0) {
            ReqMovieList.companyName = userCompany;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            root = loader.load();

            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            verificationLabel.setText("There is no Production company of that name you entered");
        }
    }

    public void onExitButtonClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit the app!");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully exited");
            stage.close();
        }
    }
}



       /* }catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/
