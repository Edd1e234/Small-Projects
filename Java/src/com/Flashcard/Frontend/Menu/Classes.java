package com.Flashcard.Frontend.Menu;

import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Classes implements Initializable {
    @FXML
    private Label userName;
    private TableView classTable;
    private TextField classNameTextField, classCodeTextField;
    private User user;

    // DataBase Will open here.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Sign up page is up");
        userName.setText(user.getUserName());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
