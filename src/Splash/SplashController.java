package Splash;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SplashController implements Initializable {
    @FXML
    private AnchorPane rootPane; // parent anchor pane

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Splash().start(); // start the new thread
    }

    class Splash extends Thread { // different thread for the splash
        @Override
        public void run() {
            try {
                Thread.sleep(5000); // sleep 5 seconds (the amount of time this view (the splash) will be showed for)
                Platform.runLater(new Runnable() { // surpassing the javafx one thread thingy
                    @Override
                    public void run() {
                        Parent root; // new root
                        try {
                            root = FXMLLoader.load(getClass().getResource("/SessionView/SessionView.fxml")); // load new view
                            Scene scene = new Scene(root); // new scene
                            Stage stage = new Stage(); // new stage
                            stage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
                            stage.setScene(scene); // set stage scene
                            stage.setTitle("Select Category");
                            stage.show(); // show the new stage
                            rootPane.getScene().getWindow().hide(); // hide the splash pane(stage)
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
