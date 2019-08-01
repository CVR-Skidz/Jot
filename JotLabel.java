package Jot;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JotLabel extends Label {

    public JotLabel(String text, double w, double h){
        super(text);

        setPrefSize(w,h);
        applyStyle();
    }

    private void applyStyle(){
        setStyle("-fx-text-fill: #AAA");
        setAlignment(Pos.CENTER);
        setFont(Font.font("Segoe UI", FontWeight.BLACK, 45));
    }
}
