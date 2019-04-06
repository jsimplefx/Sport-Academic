package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // to fix loading from the jar set the fxml directory as "/Splash/Splash.fxml" dunno why this is not the default behavior
        Parent root = FXMLLoader.load(getClass().getResource("/Splash/Splash.fxml"));
        primaryStage.getIcons().add(new Image("/resources/spordemic.png")); // set window icon
        primaryStage.setTitle("Sport Academics");
        primaryStage.setScene(new Scene(root, 600, 349));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setOnCloseRequest(we -> {
            we.consume(); // consume the close event the program wont close anyway even if you said no
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exit");
            alert.setHeaderText("Are you sure You want to exit?");
            ButtonType Yes = new ButtonType("Yes");
            ButtonType No = new ButtonType("No");
            alert.getButtonTypes().setAll(Yes, No);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == Yes) {
                // exit the app using platforms preferred way.
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.show();
    }
}
