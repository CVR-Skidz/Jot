package jotGenerator;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Region;

public class JotInput extends TextField{

    public JotInput(String placeholder, int w, int d){
        super(placeholder);

        setPrefSize(w, d);
        setMaxSize(w*2, d*2);

        style();
    }

    public JotInput(String placeholder, Region parent, int w, int d){
        super(placeholder);

        setPrefSize(w, d);
        setMaxSize(w*2, d*2);

        //layoutXProperty().bind(parent.widthProperty().divide(2));

        style();
    }

    private void style(){
        setAlignment(Pos.CENTER_LEFT);
        setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
    }
}
