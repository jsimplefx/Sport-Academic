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
    private GridPane rootPane;

    @FXML
    private BorderPane typeA;

    @FXML
    private BorderPane typeB;

    @FXML
    private BorderPane typeC;

    @FXML
    private BorderPane typeD;

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
        try {
            root = FXMLLoader.load(getClass().getResource("../QuesView/QuesView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            rootPane.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
