package QuesViews.IIUM;

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
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class IIUMViewController implements Initializable {

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
    private String[][] Options = new String[16][4]; // the answer options
    private String[] Ques = new String[16]; // the questions themselves
    private final Integer Qtime = 10; // total time to give for each question
    private Integer seconds = Qtime; // need this cuz you cant modify a final variable

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initStuff(); // init the questions and options first
    }

    @FXML
    void showQue(MouseEvent event) {
        if (event.getSource().equals(que1)) { // this is for later on when we sit different questions for each view
            new FlipInY(que1).play(); // flip the view before updating it
            initPane(1, que1); // set the questions and shit based on the passed type
            que1.setOnMouseClicked(null); // disable mouse click even on the pane
        }
        else if (event.getSource().equals(que2)) {
            new FlipInY(que2).play();
            initPane(2, que2);
            que2.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que3)) {
            new FlipInY(que3).play();
            initPane(3, que3);
            que3.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que4)) {
            new FlipInY(que4).play();
            initPane(4, que2);
            que4.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que5)) {
            new FlipInY(que5).play();
            initPane(5, que5);
            que5.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que6)) {
            new FlipInY(que6).play();
            initPane(6, que6);
            que6.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que7)) {
            new FlipInY(que7).play();
            initPane(7, que7);
            que7.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que8)) {
            new FlipInY(que8).play();
            initPane(8, que8);
            que8.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que9)) {
            new FlipInY(que9).play();
            initPane(9, que9);
            que9.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que10)) {
            new FlipInY(que10).play();
            initPane(10, que10);
            que10.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que11)) {
            new FlipInY(que11).play();
            initPane(11, que11);
            que11.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que12)) {
            new FlipInY(que12).play();
            initPane(12, que12);
            que12.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que13)) {
            new FlipInY(que13).play();
            initPane(13, que13);
            que13.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que14)) {
            new FlipInY(que14).play();
            initPane(14, que14);
            que14.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que15)) {
            new FlipInY(que15).play();
            initPane(15, que15);
            que15.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que16)) {
            new FlipInY(que16).play();
            initPane(16, que16);
            que16.setOnMouseClicked(null);
        }
    }

    private void initPane(int quenum, BorderPane pane){
        Label que = new Label(); // the question label
        que.setTextFill(Color.WHITE); // set the question color
        que.setWrapText(true); // wrap the text around
        pane.setCenter(que); // set the center of the specific pane as the question

        Popup pop = new Popup(); // create the popup
        pane.setMinSize(600, 600);  // set min size for the pane so it wont be small on the popup
        pop.getContent().setAll(pane); // set pop content as the pane

        JFXButton[] ans = new JFXButton[4];
        setBtns(ans, quenum, que); // set the question and answers based on passed pane number
        VBox options = new VBox(); // new hbox
        options.setAlignment(Pos.CENTER); // set the alignment of the items inside
        options.setSpacing(10); // internal spacing
        options.setPadding(new Insets(0, 0, 10 , 0)); // set the padding inside
        options.getChildren().setAll(ans); // add the yes and no bottoms
        pane.setBottom(options); // put the hbox at the bottom of the Border pane

        Label timer = new Label(); // timer label
        timer.setTextFill(Color.WHITE); // color
        timer.setFont(Font.font(30)); // set font size
        pane.setTop(timer); // set timer to top of pane
        BorderPane.setAlignment(timer, Pos.CENTER); // position the label to the middle of the top
        BorderPane.setMargin(timer, new Insets(10, 0, 0 ,0)); // 10px padding from top

        Timeline time = new Timeline(); // new frame(the only actual way to update a view per second)
        KeyFrame frame = new KeyFrame( Duration.seconds(1), e -> {
            seconds--; // the global seconds variable
            timer.setText(seconds.toString()); // update the timer label
            if (seconds <= 0){
                disbtns(time, ans , timer, pane); // regular disable routine
                pop.hide(); // hide the pop if the time is up
            }
        });

        // some timeline stuff
        time.setCycleCount(Timeline.INDEFINITE); //indefinite number of cycles
        time.getKeyFrames().add(frame); // add the frame to timer
        time.playFromStart(); // play timer from start every time

        for (JFXButton btn: ans) { // set the on click action on each button(here is a great example of why arrays are MVP)
            btn.setOnAction(e -> {checkAnswer(btn, quenum);
                disbtns(time, ans, timer, pane);
                pop.hide(); // hide the popup if the button was pressed
            });
        }

        pop.show(rootPane.getScene().getWindow()); // finally show the pop

    }

    // setup the answers on the buttons.
    private void setBtns(JFXButton[] ans, int quenum, Label que) {
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new JFXButton(); // init the buttons
            ans[i].setTextFill(Color.WHITE); // set button text color
            ans[i].setWrapText(true); // wrap the text around
        }

        switch (quenum){
            case 1:
                que.setText(Ques[0]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[0][j]);
                }
                break;

            case 2:
                que.setText(Ques[1]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[1][j]);
                }
                break;

            case 3:
                que.setText(Ques[2]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[2][j]);
                }break;

            case 4:
                que.setText(Ques[3]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[3][j]);
                }
                break;

            case 5:
                que.setText(Ques[4]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[3][j]);
                }
                break;

            case 6:
                que.setText(Ques[5]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[6][j]);
                }break;

            case 7:
                que.setText(Ques[6]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[6][j]);
                }
                break;

            case 8:
                que.setText(Ques[7]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[7][j]);
                }
                break;

            case 9:
                que.setText(Ques[8]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[8][j]);
                }break;

            case 10:
                que.setText(Ques[9]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[9][j]);
                }
                break;

            case 11:
                que.setText(Ques[10]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[10][j]);
                }
                break;

            case 12:
                que.setText(Ques[11]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[11][j]);
                }break;

            case 13:
                que.setText(Ques[12]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[12][j]);
                }
                break;

            case 14:
                que.setText(Ques[13]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[13][j]);
                }
                break;

            case 15:
                que.setText(Ques[14]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[14][j]);
                }
                break;


            case 16:
                que.setText(Ques[15]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(j +". " + Options[15][j]);
                }
                break;
        }

    }


    // check if the text on a passed item is correct (this is gonna be hardwired to the right answer from Options[][]).
    private void checkAnswer(JFXButton selected, int quenum){
        int current = Integer.parseInt(Score.getText()); // to get the current score
        switch (quenum){
            case 1:
                if (selected.getText().equals(Options[0][0])){ // compare to the correct answer in array
                        Score.setText(String.valueOf(current + scores[1])); // set the score label text
                }
                break;
            case 2:
                if (selected.getText().equals(Options[0][0])){ // compare to the correct answer in array
                    Score.setText(String.valueOf(current + scores[1])); // set the score label text
                }
                break;
        }
    }


    // some cleanup routine.
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
                root = FXMLLoader.load(getClass().getResource("/CatView/CatView.fxml"));
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

    // set the answer options and question on their arrays
    private void initStuff(){
        Ques[0] = "";
        Options[0][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[0][1] = "changes in the amount of energy coming from the sun";
        Options[0][2] = "the distance between the earth and the sun";
        Options[0][3] = "the speed that the earth rotates around the sun";

        Ques[1] = "";
        Options[1][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[1][1] = "changes in the amount of energy coming from the sun";
        Options[1][2] = "the distance between the earth and the sun";
        Options[1][3] = "the speed that the earth rotates around the sun";

        Ques[2] = "";
        Options[2][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[2][1] = "changes in the amount of energy coming from the sun";
        Options[2][2] = "the distance between the earth and the sun";
        Options[2][3] = "the speed that the earth rotates around the sun";

        Ques[3] = "";
        Options[3][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[3][1] = "changes in the amount of energy coming from the sun";
        Options[3][2] = "the distance between the earth and the sun";
        Options[3][3] = "the speed that the earth rotates around the sun";

        Ques[4] = "";
        Options[4][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[4][1] = "changes in the amount of energy coming from the sun";
        Options[4][2] = "the distance between the earth and the sun";
        Options[4][3] = "the speed that the earth rotates around the sun";

        Ques[5] = "";
        Options[5][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[5][1] = "changes in the amount of energy coming from the sun";
        Options[5][2] = "the distance between the earth and the sun";
        Options[5][3] = "the speed that the earth rotates around the sun";

        Ques[6] = "";
        Options[6][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[6][1] = "changes in the amount of energy coming from the sun";
        Options[6][2] = "the distance between the earth and the sun";
        Options[6][3] = "the speed that the earth rotates around the sun";

        Ques[7] = "";
        Options[7][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[7][1] = "changes in the amount of energy coming from the sun";
        Options[7][2] = "the distance between the earth and the sun";
        Options[7][3] = "the speed that the earth rotates around the sun";

        Ques[8] = "";
        Options[8][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[8][1] = "changes in the amount of energy coming from the sun";
        Options[8][2] = "the distance between the earth and the sun";
        Options[8][3] = "the speed that the earth rotates around the sun";

        Ques[9] = "";
        Options[9][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[9][1] = "changes in the amount of energy coming from the sun";
        Options[9][2] = "the distance between the earth and the sun";
        Options[9][3] = "the speed that the earth rotates around the sun";

        Ques[10] = "";
        Options[10][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[10][1] = "changes in the amount of energy coming from the sun";
        Options[10][2] = "the distance between the earth and the sun";
        Options[10][3] = "the speed that the earth rotates around the sun";

        Ques[11] = "";
        Options[11][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[11][1] = "changes in the amount of energy coming from the sun";
        Options[11][2] = "the distance between the earth and the sun";
        Options[11][3] = "the speed that the earth rotates around the sun";

        Ques[12] = "";
        Options[12][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[12][1] = "changes in the amount of energy coming from the sun";
        Options[12][2] = "the distance between the earth and the sun";
        Options[12][3] = "the speed that the earth rotates around the sun";

        Ques[13] = "";
        Options[13][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[13][1] = "changes in the amount of energy coming from the sun";
        Options[13][2] = "the distance between the earth and the sun";
        Options[13][3] = "the speed that the earth rotates around the sun";

        Ques[14] = "";
        Options[14][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[14][1] = "changes in the amount of energy coming from the sun";
        Options[14][2] = "the distance between the earth and the sun";
        Options[14][3] = "the speed that the earth rotates around the sun";

        Ques[15] = "";
        Options[15][0] = "the title of the earth's axis in relation to the sun"; // how answers are gonna be set later
        Options[15][1] = "changes in the amount of energy coming from the sun";
        Options[15][2] = "the distance between the earth and the sun";
        Options[15][3] = "the speed that the earth rotates around the sun";

    }
}

