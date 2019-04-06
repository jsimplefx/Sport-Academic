package QuesViews.Religion;

import CatView.Session2.Session2ViewController;
import animatefx.animation.ZoomIn;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ReligionViewController implements Initializable {

    private static int current; // current score
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
    private Label Score; // label for tracking the points
    private String[][] Options = new String[16][4]; // the answer options
    private String[] Ques = new String[16]; // the questions themselves

    // setter for current
    public static void setCurrent(int current) {
        ReligionViewController.current = current;
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

        JFXButton[] ans = new JFXButton[4]; // create option buttons
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
        Label C = new Label("C. ");
        C.setTextFill(Color.WHITE);
        if (Options[quenum][2].equals(""))
            C.setText(""); // set text to an empty string if the question has only 3 answer options
        Label D = new Label("D. ");
        D.setTextFill(Color.WHITE);
        if (Options[quenum][3].equals(""))
            D.setText(""); // set text to an empty string if the question has only 3 answer options
        LabelContainer.getChildren().addAll(A, B, C, D);

        HBox contain = new HBox(); // new hbox to make it look like real life MCQ options
        contain.getChildren().addAll(LabelContainer, optionsContainer);
        pane.setBottom(contain); // put the hbox at the bottom of the Border pane

        for (JFXButton btn : ans) { // set the on click action on each button(here is a great example of why arrays are MVP)
            btn.setOnAction(e -> {
                checkAnswer(btn, quenum);
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
                }
                break;

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
                }
                break;

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
                }
                break;

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
                }
                break;

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


    // check if the text on a passed item is correct (this is gonna be hardwired to the right answer from Options[][]).
    private void checkAnswer(JFXButton selected, int quenum) {
        int current = Integer.parseInt(Score.getText()); // to get the current score
        int points = 5;
        switch (quenum) {
            case 0:
                if (selected.getText().equals(Options[0][1])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[0][1])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 1:
                if (selected.getText().equals(Options[1][2])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[1][2])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 2:
                if (selected.getText().equals(Options[2][0])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[2][0])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 3:
                if (selected.getText().equals(Options[3][0])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[3][0])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 4:
                if (selected.getText().equals(Options[4][1])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[4][1])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 5:
                if (selected.getText().equals(Options[5][0])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[5][0])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 6:
                if (selected.getText().equals(Options[6][2])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[6][2])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 7:
                if (selected.getText().equals(Options[7][1])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[7][1])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 8:
                if (selected.getText().equals(Options[8][3])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[8][3])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 9:
                if (selected.getText().equals(Options[9][1])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[9][1])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 10:
                if (selected.getText().equals(Options[10][0])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[10][0])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 11:
                if (selected.getText().equals(Options[11][3])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[11][3])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 12:
                if (selected.getText().equals(Options[12][3])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[12][3])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 13:
                if (selected.getText().equals(Options[13][2])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[13][2])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 14:
                if (selected.getText().equals(Options[14][0])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[14][0])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
            case 15:
                if (selected.getText().equals(Options[15][1])) {
                    Score.setText(String.valueOf(current + points));
                } else if (!selected.getText().equals(Options[15][1])) { // deduct 5 marks if question is wrong
                    if (current > 0) Score.setText(String.valueOf(current - 5)); // check if marks is 0 first
                }
                break;
        }
    }


    // set the answer options and question on their arrays
    private void initStuff() {
        Ques[0] = "The founder of Hinduism";
        Options[0][0] = "Gadadhar Chatterji";
        Options[0][1] = "Brahman"; // correct
        Options[0][2] = "Ramakrishna";
        Options[0][3] = "Chattopaghyaya";

        Ques[1] = "when was the Prophet Mohammad (SAW) born?";
        Options[1][0] = "550CE";
        Options[1][1] = "540CE";
        Options[1][2] = "570CE"; // correct
        Options[1][3] = "560CE";

        Ques[2] = "What Church in Penang which was built in 1918 is the oldest Anglican Church in Southeast Asia.";
        Options[2][0] = "St. George"; // correct
        Options[2][1] = "Cathedral of hope";
        Options[2][2] = "Presbyterian";
        Options[2][3] = "Cedar Creek";

        Ques[3] = "What is the third-largest “religious” group worldwide?";
        Options[3][0] = "Unaffiliated religious people"; // correct
        Options[3][1] = "Muslims";
        Options[3][2] = "Christianity";
        Options[3][3] = "Judaism";

        Ques[4] = "Which religion believes in the Nirvana:";
        Options[4][0] = "Islam";
        Options[4][1] = "Buddhism"; // correct
        Options[4][2] = "Hinudism";
        Options[4][3] = "Whicca";

        Ques[5] = "Some religious denominations refuse modern technology, such as:";
        Options[5][0] = "Amish religion who goes without electricity or telephones"; // correct
        Options[5][1] = "Jehovah’s witness, who aren’t allowed blood transfusions";
        Options[5][2] = "Non-trinitarian Restorationism, does not accept the use of Vehicles";
        Options[5][3] = "Protestantism, believes that things must all be hand-made";

        Ques[6] = "In Buddhist worship “this” is used as a signal that life of a human is not permanent but short lived";
        Options[6][0] = "Candles";
        Options[6][1] = "Water";
        Options[6][2] = "flowers"; // correct
        Options[6][3] = "Sweets";

        Ques[7] = "This world religion is based on teachings of a thinker:";
        Options[7][0] = "Aristolia, Aristotle";
        Options[7][1] = "Confucianism, Confucius"; // correct
        Options[7][2] = "Platonism, Plato";
        Options[7][3] = "Dao, Laozi";

        Ques[8] = "The name of this person is mentioned 5 times more than the Prophet Muhammad (PBUH) in the Quran:";
        Options[8][0] = "Adam (AS)";
        Options[8][1] = "Noah (AS)";
        Options[8][2] = "Abraham (AS)";
        Options[8][3] = "Jesus (AS)"; // correct

        Ques[9] = "What was the name of the Muslim Woman who established The World’s Oldest continually operating educational institution in the world?";
        Options[9][0] = "Khawla b. al-Azwar";
        Options[9][1] = "Fatima al-Fihri"; // correct
        Options[9][2] = "Zaynab b. ‘Alī";
        Options[9][3] = "Shajar al-Durr";

        Ques[10] = "Where was the religion founded in the fifteenth century Sikhism started";
        Options[10][0] = "North part Of India"; // correct
        Options[10][1] = "South Part of India";
        Options[10][2] = "West part of India";
        Options[10][3] = "East part of India";

        Ques[11] = "How many known Prophets are there in Islam:";
        Options[11][0] = "15";
        Options[11][1] = "28";
        Options[11][2] = "24";
        Options[11][3] = "25"; // correct

        Ques[12] = "How many gods are there in Hinduism";
        Options[12][0] = "53 trillion";
        Options[12][1] = "585,780";
        Options[12][2] = "15 million";
        Options[12][3] = "33 million"; // correct

        Ques[13] = "What religion believes that the Chinwat Bridge to Heaven is guarded by dogs.";
        Options[13][0] = "Spiritism";
        Options[13][1] = "Shinto";
        Options[13][2] = "Zoroastrianism"; //correct
        Options[13][3] = "The Maya";

        Ques[14] = "Monks at this Temple got together to worship a robot goddess named Mindar:";
        Options[14][0] = "Japan’s Kodaiji"; // correct
        Options[14][1] = "Indonesia’s Borobudur";
        Options[14][2] = "Japan’s Saihoji";
        Options[14][3] = "China’s Lingyin";

        Ques[15] = "The Okipa Ceremony practiced in North Dakota, USA is a ceremony done to prove physical courage and seek approval of the spirits. This involves:";
        Options[15][0] = "fasting for four days and performing a personal sacrifice";
        Options[15][1] = "Piercing in the skin of young men until they faint"; // correct
        Options[15][2] = "Nailing their hands and legs to a cross";
        Options[15][3] = "Dancing with the dead";

    }


    // go back to type selection if the back button is pressed
    @FXML
    void backToTypes() {
        // first confirm the action then proceed
        Session2ViewController.setScore(Integer.valueOf(Score.getText())); // save the current score in category controller
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
                root = FXMLLoader.load(getClass().getResource("/CatView/Session2/Session2View.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
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

