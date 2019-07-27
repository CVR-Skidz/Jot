package Jot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JotApplication extends Application {

	@Override
	public void start(Stage stage){
		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");
		Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		Scene scene = new Scene(new StackPane(l), 640, 480);
		stage.setScene(scene);
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
