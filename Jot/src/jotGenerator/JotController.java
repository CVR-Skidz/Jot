package jotGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Interface input behaviour
 *
 * @author CVR-Skidz
 */
public class JotController{
    private int round;

    @FXML
    private Pane contents;

    @FXML
    private VBox output;

    @FXML
    private TextField count;

    @FXML
    private TextField noun;

    public void initialize() {
        output.getChildren().add(new JotOutput());
        output.getChildren().add(new JotOutput());
        output.getChildren().add(new JotOutput());

        contents.getChildren().add(new JotTitlebar(contents));
    }

    public void generate() {
        boolean genNoun = getNoun().equals("") ? true : false;
        int adjectives = getWords();
        String result = new String();

        JotDictionary dict = new JotDictionary("adjectives.txt");

        // adjectives
        result = result.concat(dict.genWords(adjectives));

        // nouns
        if (genNoun) {
            dict = new JotDictionary("nouns.txt");
            result = result.concat(dict.genWords(1));
        } else {
            result = result.concat(getNoun());
        }

        ((JotOutput) output.getChildren().get(round%JotOutput.OUTPUTS)).setLabel(result);
        ++ round;
    }

    public int getWords() {
        try {
            return Integer.parseInt(count.getText());
        }
        catch  (NumberFormatException exception) {
            //handle bad input
        }

        return 2;
    }

    public String getNoun(){
        return noun.getText();
    }

    public void setWords(int words) {
        this.count.setText(Integer.toString(words));
    }

    public void setNoun(String noun) {
        this.noun.setText(noun);
    }
}
