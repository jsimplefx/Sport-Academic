package CatView;

import QuesViews.Countries.CountriesViewController;
import QuesViews.Entertainment.EntViewController;
import QuesViews.History.HistoryViewController;
import QuesViews.IIUM.IIUMViewController;
import QuesViews.Religion.ReligionViewController;
import QuesViews.Science.ScienceViewController;
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

public class CatViewController implements Initializable {

    @FXML
    private GridPane rootPane; // the root pane

    @FXML
    private BorderPane typeA;

    @FXML
    private BorderPane typeB;

    @FXML
    private BorderPane typeE;

    @FXML
    private BorderPane typeF;

    @FXML
    private BorderPane typeC;

    @FXML
    private BorderPane typeD;

    @FXML
    private BorderPane typeH;

    @FXML
    private BorderPane typeI;

    private static int score = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public int getScore() {
        return score;
    }

    public static void setScore(int score) {
        CatViewController.score = score;
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
            startQuiz(4, "SPORTS");
        }
        else if (event.getSource().equals(typeE)){
            startQuiz(5, "HISTORY");
        }
        else if (event.getSource().equals(typeF)){
            startQuiz(6, "RELIGION");
        }
        else if (event.getSource().equals(typeH)){
            startQuiz(7, "RIDDLES");
        }
        else if (event.getSource().equals(typeI)){
            startQuiz(8, "IIUM");

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
                view = "/QuesViews/Sports/SportsView.fxml";
                SportsViewController.setCurrent(score);
                break;
            case 5:
                view = "/QuesViews/History/HistoryView.fxml";
                HistoryViewController.setCurrent(score);
                break;
            case 6:
                view = "/QuesViews/Religion/ReligionView.fxml";
                ReligionViewController.setCurrent(score);
                break;
            case 7: view = "/QuesViews/Riddles/RiddlesView.fxml"; break;
            case 8:
                view = "/QuesViews/IIUM/IIUMView.fxml";
                IIUMViewController.setCurrent(score);
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
