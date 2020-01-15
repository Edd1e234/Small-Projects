package com.Flashcard.Backend;

import com.Flashcard.Backend.Card.Card;

import java.util.ArrayList;

public class User {
    private String UserName;
    private String Date;
    private ArrayList<Class> Classes;

    public User(String userName, String date) {
        UserName = userName;
        Date = date;
        this.Classes = new ArrayList<>();
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ArrayList<Class> getClasses() {
        return Classes;
    }

    public void addClass(String className, int classCode) {
        this.Classes.add(new Class(className, classCode));
    }

    public void addClass(Class classValue) {
        this.Classes.add(classValue);
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();
        userString.append("Class {\n");
        userString.append("User Name: ").append(this.getUserName()).append("\n");
        userString.append("Date: ").append(this.getDate()).append("\n");
        for (Class classValue : this.Classes) {
            userString.append(classValue.toString()).append("\n");
        }
        userString.append("}");
        return userString.toString();
    }
}