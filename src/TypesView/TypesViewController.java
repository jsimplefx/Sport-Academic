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
        if (event.getSource().equals(typeA)){
            startQuiz("typeA");
        }
        if (event.getSource().equals(typeB)){
            startQuiz("typeB");
        }
        if (event.getSource().equals(typeC)){
            startQuiz("typeC");
        }
        if (event.getSource().equals(typeD)){
            startQuiz("typeD");
        }
    }

    private void startQuiz(String Sauce) {
        Parent root;
        /*
        load a different view with different questions based on passed type
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        if (Sauce.equals("typeA")) {
            try {
                // load the questions view
                root = FXMLLoader.load(getClass().getResource("/QuesView/QuesView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(Sauce); // set window name as the passed type
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (Sauce.equals("TypeB")){
            try {
                // load the questions view
                root = FXMLLoader.load(getClass().getResource("/QuesView/QuesView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(Sauce); // set window name as the passed type
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
