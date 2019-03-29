package QuesView;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuesViewController implements Initializable {

    @FXML
    private BorderPane rootPane; // the main border pane

    @FXML
    private BorderPane que00; // the first border pane inside the grid

    @FXML
    private Label Score; // label for tracking the score

    private int[] scores = {10, 20}; // the scores

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initQues("test"); // set the questions and shit based on the passed type
    }

    private void initQues(String type){
        Label que = new Label(); // the question label
        que.setText("question 1"); // the question
        que00.setCenter(que); // set the center of the specific pane as the question
        que.setTextFill(Color.WHITE); // set the question color
        JFXButton yes = new JFXButton("Yes"); // yes button
        JFXButton no = new JFXButton("No"); // no button
        yes.setTextFill(Color.WHITE);
        no.setTextFill(Color.WHITE);
        // set the action on yes button click
        yes.setOnAction(e -> {
            int current = Integer.parseInt(Score.getText()); // to get the current score
            Score.setText(String.valueOf(current + scores[1])); // set the score label text
            // disable the buttons cuz we can only choose the answer once
            yes.setDisable(true);
            no.setDisable(true);
        });
        no.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.ERROR); // init an error alert
            alert.setTitle("Wrong Answer!");
            alert.show(); // show the alert
            // disable the buttons cuz we can only choose the answer once
            no.setDisable(true);
            yes.setDisable(true);
        });
        HBox options = new HBox(); // new hbox
        options.setAlignment(Pos.CENTER); // set the alignment of the items inside
        options.setPadding(new Insets(0, 0, 10 , 0)); // set the padding inside
        options.getChildren().setAll(yes, no); // add the yes and no bottoms
        que00.setBottom(options); // put the hbox at the bottom of the Border pane
    }

    // go back to type selection if the back button is pressed
    @FXML
    void backToTypes() {
        // first confirm the action then proceed
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Go back");
        alert.setHeaderText("Are you sure You want to go back?");
        alert.setContentText("This action will delete the current score!");
        ButtonType Yes = new ButtonType("Yes");
        ButtonType No = new ButtonType("No");
        alert.getButtonTypes().setAll(Yes, No);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == Yes) { // make sure the button exists first before adding it(intellij 101)
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("../TypesView/TypesView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                rootPane.getScene().getWindow().hide(); // hide the questions view after reloading types
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
