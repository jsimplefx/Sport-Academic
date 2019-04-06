package QuesViews.Riddles;

import CatView.Session1.Session1ViewController;
import animatefx.animation.ZoomIn;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class RiddlesViewController implements Initializable {

    private static int current; // current score
    private final Integer Qtime = 10; // total time to give for each question
    private int points = 30; // points per question
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
    private String[] Ques = new String[16]; // the questions themselves
    private Integer seconds = Qtime; // need this cuz you cant modify a final variable

    // setter for current
    public static void setCurrent(int current) {
        RiddlesViewController.current = current;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initStuff(); // init the questions and options first
        Score.setText(String.valueOf(current)); // set value of score label based on the tracked current score across all categories
    }

    @FXML
    void showQue(MouseEvent event) {
        if (event.getSource().equals(que1)) { // this is for later on when we sit different questions for each view
            initPane(0, que1); // set the questions and shit based on the passed type
            que1.setOnMouseClicked(null); // disable mouse click even on the pane
        } else if (event.getSource().equals(que2)) {
            initPane(1, que2);
            que2.setOnMouseClicked(null);
        } else if (event.getSource().equals(que3)) {
            initPane(2, que3);
            que3.setOnMouseClicked(null);
        } else if (event.getSource().equals(que4)) {
            initPane(3, que2);
            que4.setOnMouseClicked(null);
        } else if (event.getSource().equals(que5)) {
            initPane(4, que5);
            que5.setOnMouseClicked(null);
        } else if (event.getSource().equals(que6)) {
            initPane(5, que6);
            que6.setOnMouseClicked(null);
        } else if (event.getSource().equals(que7)) {
            initPane(6, que7);
            que7.setOnMouseClicked(null);
        } else if (event.getSource().equals(que8)) {
            initPane(7, que8);
            que8.setOnMouseClicked(null);
        } else if (event.getSource().equals(que9)) {
            initPane(8, que9);
            que9.setOnMouseClicked(null);
        } else if (event.getSource().equals(que10)) {
            initPane(9, que10);
            que10.setOnMouseClicked(null);
        } else if (event.getSource().equals(que11)) {
            initPane(10, que11);
            que11.setOnMouseClicked(null);
        } else if (event.getSource().equals(que12)) {
            initPane(11, que12);
            que12.setOnMouseClicked(null);
        } else if (event.getSource().equals(que13)) {
            initPane(12, que13);
            que13.setOnMouseClicked(null);
        } else if (event.getSource().equals(que14)) {
            initPane(13, que14);
            que14.setOnMouseClicked(null);
        } else if (event.getSource().equals(que15)) {
            initPane(14, que15);
            que15.setOnMouseClicked(null);
        } else if (event.getSource().equals(que16)) {
            initPane(15, que16);
            que16.setOnMouseClicked(null);
        }
    }


    private void initPane(int quenum, BorderPane paneParent) {
        BorderPane pane = new BorderPane(); // create a new pane instead of directly modifying the main pane
        pane.setPrefSize(500, 500); // set preferred pane size
        pane.setStyle("-fx-background-color: #eb4d4b; -fx-border-color: #d1d8e0; -fx-border-width: 3; "); // set pane styling
        pane.setPadding(new Insets(10)); // set padding for all sides
        paneParent.getChildren().removeAll(); // remove the main pane children
        paneParent.setCenter(pane); // set new pane as center
        Label que = new Label(); // the question label
        que.setTextFill(Color.WHITE); // set the question color
        que.setWrapText(true); // wrap the text around
        pane.setCenter(que); // set the center of the specific pane as the question
        Popup pop = new Popup(); // create popup

        JFXButton[] ans = new JFXButton[2]; // create option buttons
        setBtns(ans, quenum, que); // set the question and answers based on passed pane number
        VBox optionsContainer = new VBox(); //new Vbox
        optionsContainer.setAlignment(Pos.CENTER_LEFT); // set the alignment of the items inside
        optionsContainer.setSpacing(10); // internal spacing
        optionsContainer.getChildren().setAll(ans); // add the yes and no bottoms

        VBox LabelContainer = new VBox();
        LabelContainer.setSpacing(20); // internal spacing
        LabelContainer.setPadding(new Insets(5, 0, 0, 0));
        Label A = new Label("A. ");
        A.setTextFill(Color.WHITE);
        Label B = new Label("B. ");
        B.setTextFill(Color.WHITE);
        LabelContainer.getChildren().addAll(A, B);

        HBox contain = new HBox(); // new hbox to make it look like real life MCQ options
        contain.getChildren().addAll(LabelContainer, optionsContainer);

        AtomicBoolean isAud = new AtomicBoolean(); // for tracking the button value
        JFXButton aud = new JFXButton("Asked Audience?"); // button to check if the user asked the audience
        aud.setTextFill(Color.WHITE); // set the button text color
        aud.setStyle("-fx-cursor: hand;");
        aud.setOnAction(e -> {
            points = 5; // change the points to 5 when the user asks audience
            isAud.set(true); // set to true
        });
        aud.setFocusTraversable(false); // that weird focus thing
        HBox AudContainer = new HBox(); // container for the audience button so we can align it to the center
        AudContainer.getChildren().setAll(aud); // add the button to the container children
        AudContainer.setAlignment(Pos.CENTER); // elements alignments
        VBox AllContainer = new VBox(); // container for everything (the answer options, labels and the audience button)
        AllContainer.setSpacing(40); // spacing for inner items
        AllContainer.getChildren().setAll(AudContainer, contain); // set elements as audience container and the options container
        pane.setBottom(AllContainer); // put the hbox at the bottom of the Border pane

        Label timer = new Label(); // timer label
        timer.setTextFill(Color.WHITE); // color
        timer.setFont(Font.font(30)); // set font size
        pane.setTop(timer); // set timer to top of pane
        BorderPane.setAlignment(timer, Pos.CENTER); // position the label to the middle of the top
        BorderPane.setMargin(timer, new Insets(10, 0, 0, 0)); // 10px padding from top

        Timeline time = new Timeline(); // new frame(the only actual way to update a view per second)
        KeyFrame frame = new KeyFrame(Duration.seconds(1), e -> {
            seconds--; // the global seconds variable
            timer.setText(seconds.toString()); // update the timer label
            if (seconds <= 0) {
                disbtns(time, ans, timer, pane); // regular disable routine
                pop.hide();
            }
        });
        // some timeline stuff
        time.setCycleCount(Timeline.INDEFINITE); //indefinite number of cycles
        time.getKeyFrames().add(frame); // add the frame to timer
        time.playFromStart(); // play timer from start every time

        for (JFXButton btn : ans) { // set the on click action on each button(here is a great example of why arrays are MVP)
            btn.setOnAction(e -> {
                if (!isAud.get()) { // check if its not true ( means the Audience button has not been pressed)
                    points = 10; // set points to 10 (just to make sure after the first question)
                }
                checkAnswer(btn);
                disbtns(time, ans, timer, pane);
                pop.hide();
            });

        }
        pop.getContent().setAll(pane); // set the pane as the popup content
        pop.setAutoFix(true); // auto fix the popup placement
        pop.setOpacity(1.0); // high priority for the pane
        pop.setOnHiding(e -> paneParent.setStyle("-fx-background-color: #d1ccc0")); // change the parent pane color after the popup disappears
        pop.show(rootPane.getScene().getWindow()); // show the popup using the current menu as the root
        new ZoomIn(pane).play(); // zoom in animation for the pane inside the popup
    }


    // setup the answers on the buttons.
    private void setBtns(JFXButton[] ans, int quenum, Label que) {
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new JFXButton(); // init the buttons
            ans[i].setTextFill(Color.WHITE); // set button text color
            ans[i].setWrapText(true); // wrap the text around
            ans[i].setTextAlignment(TextAlignment.LEFT); // align button text to the left
            ans[i].setFocusTraversable(false); // hide the initial focus on the first button
            ans[i].setStyle("-fx-cursor: hand;");
        }

        switch (quenum) {
            case 0:
                que.setText(Ques[0]);
                break;
            case 1:
                que.setText(Ques[1]);
                break;
            case 2:
                que.setText(Ques[2]);
                break;
            case 3:
                que.setText(Ques[3]);
                break;
            case 4:
                que.setText(Ques[4]);
                break;
            case 5:
                que.setText(Ques[5]);
                break;
            case 6:
                que.setText(Ques[6]);
                break;
            case 7:
                que.setText(Ques[7]);
                break;
            case 8:
                que.setText(Ques[8]);
                break;
            case 9:
                que.setText(Ques[9]);
                break;
            case 10:
                que.setText(Ques[10]);
                break;
            case 11:
                que.setText(Ques[11]);
                break;
            case 12:
                que.setText(Ques[12]);
                break;
            case 13:
                que.setText(Ques[13]);
                break;
            case 14:
                que.setText(Ques[14]);
                break;
            case 16:
                que.setText(Ques[15]);
                break;
        }
        ans[0].setText("Correct");
        ans[1].setText("Not Correct");

    }


    // some cleanup routine. (not needed anymore since we hide the whole panel but since removing it fucks up the timer it stays
    private void disbtns(Timeline t, JFXButton[] a, Label l, BorderPane pane) {
        t.stop(); // stop the timer
        for (JFXButton btn : a) {
            btn.setDisable(true);
        } // disable the buttons
        l.setVisible(false); // hide the timer label
        pane.setCenter(null); // hide the question
        pane.setOnMouseClicked(null); // disable panel click action
        seconds = 30; // reset the interval for the question
    }


    // check if the text on a passed item is correct (this is gonna be hardwired to the right answer from Options[][]).
    private void checkAnswer(JFXButton selected) {
        int current = Integer.parseInt(Score.getText()); // to get the current score
        if (selected.getText().equals("Correct")) Score.setText(String.valueOf(current + points));
    }


    // set the answer options and question on their arrays
    private void initStuff() {
        Ques[0] = "What tastes better than it smells?";
        Ques[1] = "What kind of room has no doors or windows?";
        Ques[2] = "During what month do people sleep the least?";
        Ques[3] = "There is an ancient invention still used around the world today that allows people to see through walls. What is it?";
        Ques[4] = "I am in everything and in nothing, what am I?";
        Ques[5] = "When it is alive we sing, when it is dead we clap our hands. What is it?";
        Ques[6] = "What goes through towns and over hills, but never moves?";
        Ques[7] = "A horse jumps over a castle and lands on a man, then the man disappears. How was this possible?";
        Ques[8] = "You see us everyday, but you never see us together. " +
                "We appear everywhere but never are we together at the same place. Who are we?";
        Ques[9] = "What goes up and never comes down?";
        Ques[10] = "What starts with the letter \"t\", is filled with \"t\" and ends in \"t\"?";
        Ques[11] = "Cut my skin out. I'm not going to cry, but you will! What am I?";
        Ques[12] = "How do you make the number ONE disappear?";
        Ques[13] = "I have 6 faces and 21 eyes, but can't see a thing. What am I?";
        Ques[14] = "If you have me, you want to share me. If you share me, you haven't got me. What am I?";
        Ques[15] = "what comes in hard comes out soft and you can blow?";
    }


    // go back to type selection if the back button is pressed
    @FXML
    void backToTypes() {
        // first confirm the action then proceed
        Session1ViewController.setScore(Integer.parseInt(Score.getText())); // save the current score in category controller
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Go back");
        alert.setHeaderText("Are you sure You want to go back?");
        alert.setContentText("This action will reset all the questions");
        ButtonType Yes = new ButtonType("Yes");
        ButtonType No = new ButtonType("No");
        alert.getButtonTypes().setAll(Yes, No);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == Yes) { // make sure the button exists first before adding it(intellij 101)
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/CatView/Session1/Session1View.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
                stage.setTitle("Sport Academics");
                stage.setFullScreen(true); // go full screen
                stage.setFullScreenExitHint(""); // hide the annoying press esc to exit full screen message
                stage.setScene(scene);
                stage.show();
                rootPane.getScene().getWindow().hide(); // hide the questions view after reloading types
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

