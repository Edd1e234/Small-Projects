package com.Flashcard;

import com.Flashcard.Backend.AllUsers;
import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.User;

public class Main {
    public static void main(String[] args) {
        AllUsers allUsers = new AllUsers();
        allUsers.addUser(new User("testUser1", "testPassword"));
        Data.saveData(allUsers);
    }
}
