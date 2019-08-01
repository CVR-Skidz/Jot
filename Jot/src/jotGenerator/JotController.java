package jotGenerator;

public class JotController{
    private int words = 0;
    private String noun;

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
