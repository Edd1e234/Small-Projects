package com.Flashcard;

import com.Flashcard.Backend.AllUsers;
import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.User;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> stringHashMap = new HashMap<>();

        stringHashMap.put(1, "Eddie");

        System.out.println(stringHashMap.get(1));
        System.out.println(stringHashMap.get(2));
    }
}
