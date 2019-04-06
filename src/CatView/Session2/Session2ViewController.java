package CatView.Session2;

import QuesViews.Religion.ReligionViewController;
import QuesViews.Sports.SportsViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Session2ViewController {

    private static int score = 0;
    @FXML
    private GridPane rootPane;
    @FXML
    private BorderPane typeF;
    @FXML
    private BorderPane typeG;

    public int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Session2ViewController.score = score;
    }

    @FXML
    void selType(MouseEvent event) {
        // check the source of the mouse click event and pass the category number and name accordingly
        if (event.getSource().equals(typeG)) {
            startQuiz(1);
        } else if (event.getSource().equals(typeF)) {
            startQuiz(2);
        }
    }

    private void startQuiz(int num) {
        /*
        load a different view with different questions based on passed view number
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        String view = null; // hold the requested view string
        switch (num) { // check the passed number and set view accordingly
            case 1:
                view = "/QuesViews/Sports/SportsView.fxml";
                SportsViewController.setCurrent(score);
                break;
            case 2:
                view = "/QuesViews/Religion/ReligionView.fxml";
                ReligionViewController.setCurrent(score);
                break;
        }

        // load the set view
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Select Category"); // set window name as the passed type
            stage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
            stage.setScene(scene); // set the stage scene
            rootPane.getScene().getWindow().hide(); // hide the types view
            stage.show(); // show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        } // gotta catch 'em all
    }
}
