package jotGenerator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JotApplication extends Application{

    public void start(Stage stage){
        stage.setTitle("Jot");
        stage.setMinHeight(450);
        stage.setMinWidth(400);

        VBox vertContainer = new VBox(50);
        vertContainer.setAlignment(Pos.TOP_CENTER);
        //vertContainer.setPadding(new Insets(50));

        Scene contents = new Scene(vertContainer);
        contents.getStylesheets().add("JotGlobal.css");

        vertContainer.getChildren().add(new JotLabel("JOT", 150, 60));
        vertContainer.getChildren().add(new JotInput("Words", vertContainer, 175, 40));
        vertContainer.getChildren().add(new JotInput("Noun", 175, 40));

        stage.setScene(contents);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        /*boolean genNoun = false;
        int adjectives = 0;
        String result = new String();

        if (args.length == 1) {
            genNoun = true;
            adjectives = Integer.parseInt(args[0]) - 1;
        } else if (args.length != 2) {
            System.err.println("Unknown arguments, use: [number] [noun]<optional>");
            return;
        }

        // if 2 arguments passed
        if (!genNoun) {
            adjectives = Integer.parseInt(args[0]);
        }

        JotDictionary dict = new JotDictionary("adjectives.txt");

        // adjectives
        result = result.concat(dict.genWords(adjectives));

        // nouns
        if (genNoun) {
            dict = new JotDictionary("nouns.txt");
            result = result.concat(dict.genWords(1));
        } else {
            result = result.concat(args[1]);
        }

        System.out.println("\n--- Name: " + result);*/
    }

}
