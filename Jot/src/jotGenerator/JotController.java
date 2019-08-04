package jotGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class JotController{
    private int words = 0;
    private String noun;

    @FXML
    private VBox output;

    @FXML
    private TextField count;

    public void initialize() {
        output.getChildren().add(new JotOutput());
        output.getChildren().add(new JotOutput());
        output.getChildren().add(new JotOutput());
    }

    public void genOutputs(ActionEvent event){

    }

    public int getWords() {
        return words;
    }

    public String getNoun(){
        return noun;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }
}
