package largeQue;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class largeController implements Initializable {
    @FXML
    static
    BorderPane root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setQue(BorderPane pane){
        root.setCenter(pane);
    }
}
