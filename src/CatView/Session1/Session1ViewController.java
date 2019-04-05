package CatView.Session1;

import QuesViews.Countries.CountriesViewController;
import QuesViews.Entertainment.EntViewController;
import QuesViews.Riddles.RiddlesViewController;
import QuesViews.Science.ScienceViewController;
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

public class Session1ViewController implements Initializable {

    @FXML
    private GridPane rootPane; // the root pane

    @FXML
    private BorderPane typeA;

    @FXML
    private BorderPane typeB;

    @FXML
    private BorderPane typeC;

    @FXML
    private BorderPane typeD;

    private static int score = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Session1ViewController.score = score;
    }

    @FXML
    void selType(MouseEvent event) {
        // check the source of the mouse click event and pass the category number and name accordingly
        if (event.getSource().equals(typeA)){
            startQuiz(1, "SCIENCE");
        }
        else if (event.getSource().equals(typeB)){
            startQuiz(2, "ENTERTAINMENT");
        }
        else if (event.getSource().equals(typeC)){
            startQuiz(3, "COUNTRIES");
        }
        else if (event.getSource().equals(typeD)){
            startQuiz(4, "RIDDLES");
        }
    }

    private void startQuiz(int num, String type) {
        /*
        load a different view with different questions based on passed view number
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        String view = null; // hold the requested view string
        switch (num){ // check the passed number and set view accordingly
            case 1:
                view = "/QuesViews/Science/ScienceView.fxml";
                ScienceViewController.setCurrent(score);
                break;
            case 2:
                view = "/QuesViews/Entertainment/EntView.fxml";
                EntViewController.setCurrent(score);
                break;
            case 3:
                view = "/QuesViews/Countries/CountriesView.fxml";
                CountriesViewController.setCurrent(score);
                break;
            case 4:
                view = "/QuesViews/Riddles/RiddlesView.fxml";
                RiddlesViewController.setCurrent(score);
                break;
        }

        // load the set view
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(type); // set window name as the passed type
            stage.setScene(scene); // set the stage scene
            rootPane.getScene().getWindow().hide(); // hide the types view
            stage.show(); // show the new stage
            } catch (IOException e) { e.printStackTrace(); } // gotta catch 'em all
        }
}
