package com.Flashcard.Backend;

import com.Flashcard.Backend.Status.StatusUser;

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

    public StatusUser getUser(String username, String password) {
        User user = Users.get(username);
        StatusUser statusUser = new StatusUser();
        if (user == null) {
            statusUser.setStatus(false);
            statusUser.setStatusMessage("User is not here.");
            return statusUser;
        }
        if (!user.getPassword().equals(password)) {
            statusUser.setStatus(false);
            statusUser.setStatusMessage("Password is not correct");
            return statusUser;
        }
        statusUser.setUser(user);
        return statusUser;
    }
}
