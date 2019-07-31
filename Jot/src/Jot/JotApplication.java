package Jot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class JotApplication extends Application {

	@Override
	public void start(Stage stage){

		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);

		container.setFillWidth(false);

		JotLabel heading = new JotLabel("JOT", 150, 60);
		container.getChildren().add(heading);

		Scene root = new Scene(container, 400, 500);
		stage.setScene(root);
		stage.show();
	}

	public static void main(String[] args) {
		launch();

		boolean genNoun = false;
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
		
		System.out.println("\n--- Name: " + result);
	}
}
