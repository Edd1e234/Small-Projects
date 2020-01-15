package com.Flashcard.Backend;

import java.util.ArrayList;
import java.util.HashMap;

public class AllUsers {
    private HashMap<String, User> Users;

    public AllUsers() {
        Users = new HashMap<String, User>();
    }

    public HashMap<String, User> getUsers() {
        return Users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.Users = users;
    }

    public void addUser(User user) {
        this.Users.put(user.getUserName(), user);
    }
}
