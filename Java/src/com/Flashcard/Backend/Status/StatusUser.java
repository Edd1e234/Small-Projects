package com.Flashcard.Backend.Status;

import com.Flashcard.Backend.User;

public class StatusUser extends Status {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
