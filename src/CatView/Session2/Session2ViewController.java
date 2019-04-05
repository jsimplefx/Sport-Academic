package CatView.Session2;

import QuesViews.History.HistoryViewController;
import QuesViews.IIUM.IIUMViewController;
import QuesViews.Religion.ReligionViewController;
import QuesViews.Sports.SportsViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Session2ViewController implements Initializable {

    @FXML
    private GridPane rootPane;

    @FXML
    private BorderPane typeE;

    @FXML
    private BorderPane typeF;

    @FXML
    private BorderPane typeG;

    @FXML
    private BorderPane typeH;

    private static int score = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Session2ViewController.score = score;
    }

    @FXML
    void selType(MouseEvent event) {
        // check the source of the mouse click event and pass the category number and name accordingly
        if (event.getSource().equals(typeG)){
            startQuiz(1);
        }
        else if (event.getSource().equals(typeE)){
            startQuiz(2);
        }
        else if (event.getSource().equals(typeF)){
            startQuiz(3);
        }
        else if (event.getSource().equals(typeH)){
            startQuiz(4);

        }
    }

    private void startQuiz(int num) {
        /*
        load a different view with different questions based on passed view number
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        String view = null; // hold the requested view string
        switch (num){ // check the passed number and set view accordingly
            case 1:
                view = "/QuesViews/Sports/SportsView.fxml";
                SportsViewController.setCurrent(score);
                break;
            case 2:
                view = "/QuesViews/History/HistoryView.fxml";
                HistoryViewController.setCurrent(score);
                break;
            case 3:
                view = "/QuesViews/Religion/ReligionView.fxml";
                ReligionViewController.setCurrent(score);
                break;
            case 4:
                view = "/QuesViews/IIUM/IIUMView.fxml";
                IIUMViewController.setCurrent(score);
                break;
        }

        // load the set view
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Select Category"); // set window name as the passed type
            stage.setScene(scene); // set the stage scene
            rootPane.getScene().getWindow().hide(); // hide the types view
            stage.show(); // show the new stage
            } catch (IOException e) { e.printStackTrace(); } // gotta catch 'em all
        }
}
