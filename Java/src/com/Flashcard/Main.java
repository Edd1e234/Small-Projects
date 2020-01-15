package com.Flashcard;

import com.Flashcard.Backend.User;
import com.Flashcard.Backend.Class;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User eddie = new User("Eddie234", "This Date");

        eddie.addClass("ECON", 2012);
        eddie.addClass("MATH", 2012);
        eddie.addClass("CS", 2012);

        ArrayList<Class> classes = eddie.getClasses();

        classes.get(0).addCard("ECON Question is",
                "Answer is A");
        System.out.println(eddie.toString());
    }
}
