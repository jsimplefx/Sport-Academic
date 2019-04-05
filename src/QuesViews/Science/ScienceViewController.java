package QuesViews.Science;

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

public class ScienceViewController implements Initializable {

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

    private static int current; // current score
    private String[][] Options = new String[16][4]; // the answer options
    private String[] Ques = new String[16]; // the questions themselves
    private final Integer Qtime = 10; // total time to give for each question
    private Integer seconds = Qtime; // need this cuz you cant modify a final variable

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initStuff(); // init the questions and options first
        Score.setText(String.valueOf(current)); // set value of score label based on the tracked current score across all categories
    }

    // setter for current
    public static void setCurrent(int current) {
        ScienceViewController.current = current;
    }

    @FXML
    void showQue(MouseEvent event) {
        if (event.getSource().equals(que1)) { // this is for later on when we sit different questions for each view
            initPane(0, que1); // set the questions and shit based on the passed type
            que1.setOnMouseClicked(null); // disable mouse click even on the pane
        }
        else if (event.getSource().equals(que2)) {
            initPane(1, que2);
            que2.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que3)) {
            initPane(2, que3);
            que3.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que4)) {
            initPane(3, que2);
            que4.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que5)) {
            initPane(4, que5);
            que5.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que6)) {
            initPane(5, que6);
            que6.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que7)) {
            initPane(6, que7);
            que7.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que8)) {
            initPane(7, que8);
            que8.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que9)) {
            initPane(8, que9);
            que9.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que10)) {
            initPane(9, que10);
            que10.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que11)) {
            initPane(10, que11);
            que11.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que12)) {
            initPane(11, que12);
            que12.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que13)) {
            initPane(12, que13);
            que13.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que14)) {
            initPane(13, que14);
            que14.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que15)) {
            initPane(14, que15);
            que15.setOnMouseClicked(null);
        }
        else if (event.getSource().equals(que16)) {
            initPane(15, que16);
            que16.setOnMouseClicked(null);
        }
    }


    private void initPane(int quenum, BorderPane paneParent){
        BorderPane pane = new BorderPane(); // create a new pane instead of directly modifying the main pane
        pane.setPrefSize(600, 600); // set preferred pane size
        pane.setStyle("-fx-background-color: #eb4d4b; -fx-border-color: #d1d8e0; -fx-border-width: 3; "); // set pane styling
        pane.setPadding(new Insets(10)); // set padding for all sides
        paneParent.getChildren().removeAll(); // remove the main pane children
        paneParent.setCenter(pane); // set new pane as center
        Label que = new Label(); // the question label
        que.setTextFill(Color.WHITE); // set the question color
        que.setWrapText(true); // wrap the text around
        pane.setCenter(que); // set the center of the specific pane as the question
        Popup pop = new Popup(); // create popup

        JFXButton[] ans = new JFXButton[4]; // create option buttons
        setBtns(ans, quenum, que); // set the question and answers based on passed pane number
        VBox optionsContainer = new VBox(); //new Vbox
        optionsContainer.setAlignment(Pos.CENTER_LEFT); // set the alignment of the items inside
        optionsContainer.setSpacing(10); // internal spacing
        optionsContainer.getChildren().setAll(ans); // add the yes and no bottoms

        VBox LabelContainer = new VBox();
        LabelContainer.setSpacing(20); // internal spacing
        LabelContainer.setPadding(new Insets(5, 0 ,0 , 0));
        Label A = new Label("A. ");
        A.setTextFill(Color.WHITE);
        Label B = new Label("B. ");
        B.setTextFill(Color.WHITE);
        Label C = new Label("C. ");
        C.setTextFill(Color.WHITE);
        if (Options[quenum][2].equals("")) C.setText(""); // set text to an empty string if the question has only 3 answer options
        Label D = new Label("D. ");
        D.setTextFill(Color.WHITE);
        if (Options[quenum][3].equals("")) D.setText(""); // set text to an empty string if the question has only 3 answer options
        LabelContainer.getChildren().addAll(A, B, C, D);

        HBox contain = new HBox(); // new hbox to make it look like real life MCQ options
        contain.getChildren().addAll(LabelContainer, optionsContainer);
        pane.setBottom(contain); // put the hbox at the bottom of the Border pane

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
                pop.hide();
            }
        });
        // some timeline stuff
        time.setCycleCount(Timeline.INDEFINITE); //indefinite number of cycles
        time.getKeyFrames().add(frame); // add the frame to timer
        time.playFromStart(); // play timer from start every time

        for (JFXButton btn: ans) { // set the on click action on each button(here is a great example of why arrays are MVP)
            btn.setOnAction(e -> {checkAnswer(btn, quenum);
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
        }

        switch (quenum){
            case 0:
                que.setText(Ques[0]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[0][j]);
                }
                break;

            case 1:
                que.setText(Ques[1]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[1][j]);
                }
                break;

            case 2:
                que.setText(Ques[2]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[2][j]);
                }break;

            case 3:
                que.setText(Ques[3]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[3][j]);
                }
                break;

            case 4:
                que.setText(Ques[4]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[4][j]);
                }
                break;

            case 5:
                que.setText(Ques[5]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[5][j]);
                }break;

            case 6:
                que.setText(Ques[6]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[6][j]);
                }
                break;

            case 7:
                que.setText(Ques[7]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[7][j]);
                }
                break;

            case 8:
                que.setText(Ques[8]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[8][j]);
                }break;

            case 9:
                que.setText(Ques[9]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[9][j]);
                }
                break;

            case 10:
                que.setText(Ques[10]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[10][j]);
                }
                break;

            case 11:
                que.setText(Ques[11]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[11][j]);
                }break;

            case 12:
                que.setText(Ques[12]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[12][j]);
                }
                break;

            case 13:
                que.setText(Ques[13]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[13][j]);
                }
                break;

            case 14:
                que.setText(Ques[14]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[14][j]);
                }
                break;

            case 15:
                que.setText(Ques[15]); // the question
                for (int j = 0; j < 4; j++) { // set the text on the buttons based on the question
                    ans[j].setText(Options[15][j]);
                }
                break;
        }

    }


    // some cleanup routine. (not needed anymore since we hide the whole panel but since removing it fucks up the timer it stays
    private void disbtns(Timeline t, JFXButton[] a, Label l, BorderPane pane){
        t.stop(); // stop the timer
        for(JFXButton btn: a) { btn.setDisable(true); } // disable the buttons
        l.setVisible(false); // hide the timer label
        pane.setCenter(null); // hide the question
        pane.setOnMouseClicked(null); // disable panel click action
        seconds = 10; // reset the interval for the question
    }


    // check if the text on a passed item is correct (this is gonna be hardwired to the right answer from Options[][]).
    private void checkAnswer(JFXButton selected, int quenum){
        int current = Integer.parseInt(Score.getText()); // to get the current score
        int points = 10;
        switch (quenum){
            case 0: if (selected.getText().equals(Options[0][0])) Score.setText(String.valueOf(current + points)); break;
            case 1: if (selected.getText().equals(Options[1][1])) Score.setText(String.valueOf(current + points)); break;
            case 2: if (selected.getText().equals(Options[2][0])) Score.setText(String.valueOf(current + points)); break;
            case 3: if (selected.getText().equals(Options[3][2])) Score.setText(String.valueOf(current + points)); break;
            case 4: if (selected.getText().equals(Options[4][3])) Score.setText(String.valueOf(current + points)); break;
            case 5: if (selected.getText().equals(Options[5][0])) Score.setText(String.valueOf(current + points)); break;
            case 6: if (selected.getText().equals(Options[6][1])) Score.setText(String.valueOf(current + points)); break;
            case 7: if (selected.getText().equals(Options[7][2])) Score.setText(String.valueOf(current + points)); break;
            case 8: if (selected.getText().equals(Options[8][1])) Score.setText(String.valueOf(current + points)); break;
            case 9: if (selected.getText().equals(Options[9][3])) Score.setText(String.valueOf(current + points)); break;
            case 10: if (selected.getText().equals(Options[10][0])) Score.setText(String.valueOf(current + points)); break;
            case 11: if (selected.getText().equals(Options[11][1])) Score.setText(String.valueOf(current + points)); break;
            case 12: if (selected.getText().equals(Options[12][3])) Score.setText(String.valueOf(current + points)); break;
            case 13: if (selected.getText().equals(Options[13][1])) Score.setText(String.valueOf(current + points)); break;
            case 14: if (selected.getText().equals(Options[14][1])) Score.setText(String.valueOf(current + points)); break;
            case 15: if (selected.getText().equals(Options[15][1])) Score.setText(String.valueOf(current + points)); break;
        }
    }


    // set the answer options and question on their arrays
    private void initStuff(){
        Ques[0] = "What is the radius of earth?";
        Options[0][0] = "6.371KM"; // correct
        Options[0][1] = "7072KM";
        Options[0][2] = "9096KM";
        Options[0][3] = "3.963KM";

        Ques[1] = "Name the chemical used to make the toothpaste white? ";
        Options[1][0] = "Sulphuric acid";
        Options[1][1] = "Titanium dioxide"; // correct
        Options[1][2] = "hydrochloric acid";
        Options[1][3] = "nitric acid";

        Ques[2] = "Who invented periodic table?";
        Options[2][0] = "Dmitri Mendeleev."; // correct
        Options[2][1] = "John Dalton.";
        Options[2][2] = "Ernest Rutherford";
        Options[2][3] = "Sir Joseph John Thomson.";

        Ques[3] = "What is the main cause of seasons on the Earth?";
        Options[3][0] = "the distance between the earth and the sun";
        Options[3][1] = "changes in the amount of energy coming from the sun";
        Options[3][2] = "the title of the earth's axis in relation to the sun"; // correct
        Options[3][3] = "the speed that the earth rotates around the sun";

        Ques[4] = "Which of the following memory is required to store data so that ,further requests for that data can be served faster?";
        Options[4][0] = "Flash memory";
        Options[4][1] = "Flip Flop";
        Options[4][2] = "External Hard disk";
        Options[4][3] = "Cache memory"; // correct

        Ques[5] = ".Which Vitamin deficiency causes night blindness?";
        Options[5][0] = "vitamin A"; // correct
        Options[5][1] = "vitamin K";
        Options[5][2] = "vitamin D";
        Options[5][3] = "vitamin C++"; // yup thats a thing

        Ques[6] = "Which of the Following day is Celebrated as –Pi day?";
        Options[6][0] = "26 July";
        Options[6][1] = "14 March"; // correct
        Options[6][2] = "27 December";
        Options[6][3] = "17 April";

        Ques[7] = "Many diseases have an incubation period.  what is an  incubation period ?";
        Options[7][0] = "The effect of a disease on babies";
        Options[7][1] = "The period during which someone builds up immunity to a disease";
        Options[7][2] = "The period during which someone has an infection, but is not showing symptoms."; // correct
        Options[7][3] = "The recovery period after being sick";

        Ques[8] = "An antacid relieves an overly acidic stomach because the main components of antacids are …";
        Options[8][0] = "Neutral";
        Options[8][1] = "Bases"; // correct
        Options[8][2] = "Isotopes";
        Options[8][3] = "Acids";

        Ques[9] = "Which of these is a major concern about the overuse of antibiotic";
        Options[9][0] = "Antibiotics will get into the water system";
        Options[9][1] = "Antibiotics can cause secondary infections";
        Options[9][2] = "There will be an antibiotic shortage";
        Options[9][3] = "It can lead to antibiotic-resistant bacteria"; // correct

        Ques[10] = "What is name of The deepest point in all of the world’s oceans?";
        Options[10][0] = "Mariana Trench"; // correct
        Options[10][1] = "Point of immersion";
        Options[10][2] = "Bermuda";
        Options[10][3] = "Sirena Deep";

        Ques[11] = "What is the biggest planet in our solar system?";
        Options[11][0] = "saturn";
        Options[11][1] = "Jupiter"; // correct
        Options[11][2] = "Uranus";
        Options[11][3] = "Neptune";

        Ques[12] = "What is the 7th element on the periodic table of elements?";
        Options[12][0] = "OXYGEN";
        Options[12][1] = "NEON";
        Options[12][2] = "FLUORINE";
        Options[12][3] = "NITROGEN"; // correct

        Ques[13] = "The wire inside an electric bulb is known as the what? ";
        Options[13][0] = "THWN/THHN";
        Options[13][1] = "filament"; //correct
        Options[13][2] = "multiconductor wire";
        Options[13][3] = "Grounding wire";

        Ques[14] = "Who is the Hubble Space Telescope named after? ";
        Options[14][0] = "Thomas Hubble";
        Options[14][1] = "Edwin Hubble"; // correct
        Options[14][2] = "Edward Hubble";
        Options[14][3] = "James Hubble";

        Ques[15] = "What planet is nicknamed the ‘Red Planet’?";
        Options[15][0] = "Neptune";
        Options[15][1] = "Mars"; // correct
        Options[15][2] = "Mercury";
        Options[15][3] = "Saturn";

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

