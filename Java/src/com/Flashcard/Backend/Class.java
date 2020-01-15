package com.Flashcard.Backend;

import com.Flashcard.Backend.Card.Card;

import java.util.ArrayList;

public class Class {
    private String ClassName;
    private int ClassCode;
    private ArrayList<Card> Cards;

    public Class() {
        this.Cards = new ArrayList<>();
    }

    public Class(String className, int classCode) {
        this.ClassName = className;
        this.ClassCode = classCode;
        this.Cards = new ArrayList<>();
    }
    public Class(String className) {
        this.ClassName = className;
        this.Cards = new ArrayList<>();
    }

    public String getClassName() {
        return this.ClassName;
    }

    public void setClassName(String className) {
        this.ClassName = className;
    }

    public int getClassCode() {
        return this.ClassCode;
    }

    public void setClassCode(int classCode) {
        this.ClassCode = classCode;
    }

    public ArrayList<Card> getCards() {
        return this.Cards;
    }

    public void addCard(String CardTitle, String CardAnswer){
        this.Cards.add(new Card(CardTitle, CardAnswer));
    }

    @Override
    public String toString() {
        StringBuilder classString = new StringBuilder();
        classString.append("Class {\n");
        classString.append("Class Name: ").append(this.ClassName).append("\n");
        classString.append("Class Code: ").append(this.ClassCode).append("\n");
        for (Card card : this.Cards) {
            classString.append(card.toString()).append("\n");
        }
        classString.append("}");
        return classString.toString();
    }
}
