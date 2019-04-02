package QuesView;

import animatefx.animation.FlipInY;
import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class QuesViewController implements Initializable {

    @FXML
    private BorderPane rootPane; // the main border pane

    @FXML
    private BorderPane que1;

    @FXML
    private BorderPane que6;

    @FXML
    private BorderPane que2;

    @FXML
    private BorderPane que3;

    @FXML
    private BorderPane que4;

    @FXML
    private BorderPane que5;

    @FXML
    private BorderPane que7;

    @FXML
    private BorderPane que8;

    @FXML
    private BorderPane que9;

    @FXML
    private BorderPane que10;

    @FXML
    private BorderPane que11;

    @FXML
    private BorderPane que12;

    @FXML
    private BorderPane que13;

    @FXML
    private BorderPane que14;

    @FXML
    private BorderPane que15;

    @FXML
    private BorderPane que16;


    @FXML
    private Label Score; // label for tracking the score

    private int[] scores = {10, 20}; // the scores
    // for saving the answers to compare with user option later (16 questions and each has 2 answer options)
    private String[][] Answers = new String[16][4];
    private final Integer Qtime = 10; // total time to give for each question
    private Integer seconds = Qtime; // need this cuz you cant modify a final variable

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Answers[0][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Answers[0][1] = "changes in the amount of energy coming from the sun";
        Answers[0][2] = "the distance between the earth and the sun";
        Answers[0][3] = "the speed that the earth rotates around the sun";
    }

    @FXML
    void showQue(MouseEvent event) {
        if (event.getSource().equals(que1)) { // this is for later on when we sit different questions for each view
            new FlipInY(que1).play(); // flip the view before updating it
            initQues(1, que1); // set the questions and shit based on the passed type
            que1.setOnMouseClicked(null); // disable mouse click even on the pane
        }
        else if (event.getSource().equals(que2)) { // this is for later on when we sit different questions for each view
            new FlipInY(que2).play(); // flip the view before updating it
            initQues(2, que2); // set the questions and shit based on the passed type
            que2.setOnMouseClicked(null); // disable mouse click even on the pane
        }
        else if (event.getSource().equals(que3)) { // this is for later on when we sit different questions for each view
            new FlipInY(que3).play(); // flip the view before updating it
            initQues(2, que3); // set the questions and shit based on the passed type
            que3.setOnMouseClicked(null); // disable mouse click even on the pane
        }
    }

    private void initQues(int quenum, BorderPane pane){
        Label que = new Label(); // the question label
        que.setTextFill(Color.WHITE); // set the question color
        que.setWrapText(true); // wrap the text around
        pane.setCenter(que); // set the center of the specific pane as the question

        JFXButton[] ans = new JFXButton[4];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = new JFXButton();
            ans[i].setTextFill(Color.WHITE); // set button text color
            ans[i].setWrapText(true); // wrap the text aroud
        }

        // set the question and answers based on passed pane number
        switch (quenum){
            case 1:
                que.setText("What is the main cause of seasons on earth"); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Answers[0][j]);
                }
                break;

            case 2:
                que.setText("question 2"); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Answers[1][j]);
                }
                break;

            case 3:
                que.setText("question 3"); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Answers[2][j]);
                }break;
        }

        VBox options = new VBox(); // new hbox
        options.setAlignment(Pos.CENTER); // set the alignment of the items inside
        options.setSpacing(10); // internal spacing
        options.setPadding(new Insets(0, 0, 10 , 0)); // set the padding inside
        options.getChildren().setAll(ans); // add the yes and no bottoms
        pane.setBottom(options); // put the hbox at the bottom of the Border pane

        Label timer = new Label(); // timer label
        timer.setTextFill(Color.WHITE); // color
        pane.setTop(timer); // set timer to top of pane
        BorderPane.setAlignment(timer, Pos.CENTER); // position the label to the middle of the top
        BorderPane.setMargin(timer, new Insets(10, 0, 0 ,0)); // 10px padding from top

        Timeline time = new Timeline(); // new frame(the only actual way to update a view per second)
        KeyFrame frame = new KeyFrame( Duration.seconds(1), e -> {
            seconds--; // the global seconds variable
            timer.setText(seconds.toString()); // update the timer label
            if (seconds <= 0){
                disbtns(time, ans , timer, pane); // regular disable routine
            }
        });

        // some timeline stuff
        time.setCycleCount(Timeline.INDEFINITE); //indefinite number of cycles
        time.getKeyFrames().add(frame); // add the frame to timer
        time.playFromStart(); // play timer from start every time


        for (JFXButton btn: ans) { // set the on click action on each button(here is a great example of why arrays are MVP)
            btn.setOnAction(e -> {checkAnswer(btn, quenum);
                disbtns(time, ans, timer, pane);
            });
        }

//        Popup pop = new Popup();
//        pop.setX(1000);
//        pop.setY(1000);
//        pop.getContent().setAll(pane);
//        pop.show(rootPane.getScene().getWindow());
    }


    // check if the text on a passed item is correct (this is gonna be hardwired to the right answer from Answers[][])
    private void checkAnswer(JFXButton selected, int quenum){
        int current = Integer.parseInt(Score.getText()); // to get the current score
        switch (quenum){
            case 1:
                if (selected.getText().equals(Answers[0][0])){ // compare to the correct answer in array
                        Score.setText(String.valueOf(current + scores[1])); // set the score label text
                }
                break;
            case 2:
                if (selected.getText().equals(Answers[0][0])){ // compare to the correct answer in array
                    Score.setText(String.valueOf(current + scores[1])); // set the score label text
                }
                break;
        }
    }


    // some cleanup routine
    private void disbtns(Timeline t, JFXButton[] a, Label l, BorderPane pane){
        t.stop(); // stop the timer
        for(JFXButton btn: a) { btn.setDisable(true); } // disable the buttons
        l.setVisible(false); // hide the timer label
        pane.setCenter(null); // hide the question
        pane.setOnMouseClicked(null); // disable panel click action
        seconds = 10; // reset the interval for the question
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
                root = FXMLLoader.load(getClass().getResource("/TypesView/TypesView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Sport Academics");
                stage.setScene(scene);
                stage.show();
                rootPane.getScene().getWindow().hide(); // hide the questions view after reloading types
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
