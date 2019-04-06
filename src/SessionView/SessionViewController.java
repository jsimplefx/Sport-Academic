package SessionView;

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

public class SessionViewController {

    @FXML
    private GridPane rootPane; // the root pane

    @FXML
    private BorderPane S1;

    @FXML
    private BorderPane S2;

    @FXML
    void selCat(MouseEvent event) {
        if (event.getSource().equals(S1)) {
            startCat(1);
        } else if (event.getSource().equals(S2)) {
            startCat(2);
        }
    }

    private void startCat(int num) {
        /*
        load a different view with different questions based on passed view number
        this cant be one file because that way the controller could be over 1000s of lines (conditions and stuff)
        in this case its better to split it to multiple similar views
        */
        String view = null; // hold the requested view string
        switch (num) { // check the passed number and set view accordingly
            case 1:
                view = "/CatView/Session1/Session1View.fxml";
                break;
            case 2:
                view = "/CatView/Session2/Session2View.fxml";
                break;
        }

        // load the set view
        try {
            Parent root = FXMLLoader.load(getClass().getResource(view));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Select Category"); // set window name as the passed type
            stage.setScene(scene); // set the stage scene
            stage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
            rootPane.getScene().getWindow().hide(); // hide the types view
            stage.show(); // show the new stage
        } catch (IOException e) {
            e.printStackTrace();
        } // gotta catch 'em all
    }
}
