package com.Flashcard.Frontend;


import com.Flashcard.Backend.AllUsers;
import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {
    @FXML
    private TextField passwordSignUp, userNameSignUp;
    private AllUsers AllUsers;

    // DataBase Will open here.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("hello world");

        // Gets the full database.
        this.AllUsers = Data.getAllusers();
    }

    // TODO(Edd1e234) Things to work on:
        // If the user attempts to put numbers in userName field.
        // Should create an entirely different function for all these checks.
            // Maybe a util.
        // Error codes need to be thrown at user.
    public void signUpButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("SignUp");

        // Add Checks.
        // New User.
        if (this.userNameSignUp.getText().equals("")) {
            System.out.println("UserName empty please retry");
            // Error code should go up.
            return;
        }
        if (this.passwordSignUp.getText().equals("")) {
            System.out.println("Password empty please retry");
            // Error code should go up.
            return;
        }
        try {
            User newUser = new User(
                    this.userNameSignUp.getText(),
                    this.passwordSignUp.getText());

            AllUsers.addUser(newUser);
            Data.saveData(AllUsers);
        } catch (Exception e) {
            System.out.println("Something went wrong... " + e.toString());
        }

        System.out.println("Works");
    }

    public void loginButton(javafx.event.ActionEvent actionEvent) {
        System.out.println("Login Button");
    }
}
