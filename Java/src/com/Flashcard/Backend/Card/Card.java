package com.Flashcard.Backend.Card;

public class Card {
    private String CardTitle;
    private StringBuilder Answer;

    public Card(String cardTitle, String answer) {
        this.CardTitle = cardTitle;
        this.Answer = new StringBuilder(answer);
    }

    public Card () {}

    public String getCardTitle() {
        return this.CardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.CardTitle = cardTitle;
    }


    public String getAnswer() {
        // Maybe slower but makes things simpler.
        return this.Answer.toString();
    }

    public void setAnswer(StringBuilder answer) {
        this.Answer = answer;
    }

    @Override
    public String toString() {
        return "Card{" +
                "CardTitle='" + CardTitle + '\'' +
                ", Answer=" + Answer +
                '}';
    }
}
