package Jot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JotApplication extends Application {

	@Override
	public void start(Stage stage){

		/*VBox container = new VBox();
		container.setAlignment(Pos.CENTER);

		container.setFillWidth(false);

		container.getChildren().add(new JotLabel("JOT", 150, 60));

		Scene root = new Scene(container, 400, 500);
		stage.setScene(root);
		stage.show();*/

		//window
		stage.setTitle("Shape Sample");

		//window contents layout
		Pane pane = new Pane();

		Circle circle = new Circle();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(4));
		circle.setRadius(20);

		circle.setStyle("-fx-stroke: #AF2FCF; -fx-stroke-width: 3px; -fx-fill: #EE2fAF;");
		Color color = new Color(0.8, 0.2, 0.6, 0.5);

		pane.getChildren().add(circle);
		pane.getChildren().add(new Button("Test"));

		stage.setScene(new Scene(pane, 200, 200));
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
