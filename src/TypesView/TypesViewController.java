package TypesView;

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

public class TypesViewController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        Parent root;
        /*
        load a different view with different questions based on passed type
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        String view = ""; // hold the requested view string
        switch (num){ // check the passed number and set view accordingly
            case 1: view = "/QuesView/QuesView.fxml"; break;
            case 2: view = "/QuesView/QuesView.fxml"; break;
            case 3: view = "/QuesView/QuesView.fxml"; break;
            case 4: view = "/QuesView/QuesView.fxml"; break;
            case 5: view = "/QuesView/QuesView.fxml"; break;
            case 6: view = "/QuesView/QuesView.fxml"; break;
            case 7: view = "/QuesView/QuesView.fxml"; break;
            case 8: view = "/QuesView/QuesView.fxml"; break;
        }

        // load the set view
        try {
                root = FXMLLoader.load(getClass().getResource(view));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(type); // set window name as the passed type
                stage.setScene(scene); // set the stage scene
                rootPane.getScene().getWindow().hide(); // hide the types view
                stage.show(); // show the new stage
            } catch (IOException e) { // gotta catch 'em all
                e.printStackTrace();
            }
        }
}
