package jotGenerator;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

/**
 * Jot driver class
 *
 * @author CVR-Skidz
 */
public class JotApplication extends Application{

    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/JotInterface.fxml"));

        //stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Jot");

        stage.setResizable(false);

        Rectangle2D screen = Screen.getPrimary().getVisualBounds();

        Scene jotScene = new Scene(root, 400, 450);
        jotScene.setFill(Color.TRANSPARENT);

        stage.setScene(jotScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
