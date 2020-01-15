package com.Flashcard.Frontend;


import com.Flashcard.Backend.AllUsers;
import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.Status.Status;
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
    private TextField passwordSignUp, userNameSignUp, username, password;
    private AllUsers AllUsers;

    // DataBase Will open here.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Sign up page is up");
        this.AllUsers = Data.getAllusers();
    }
    private Status checkSignUpFields() {
        Status status = new Status();
        if (this.userNameSignUp.getText().equals("")) {
            status.setStatus(false);
            status.setStatusMessage("Username is empty.");
            return status;
        }
        if (this.passwordSignUp.getText().equals("")) {
            status.setStatus(false);
            status.setStatusMessage("Password is empty");
            return status;
        }

        // Add check for user name taken.
        return status;
    }

    public void signUpButton(javafx.event.ActionEvent actionEvent) {
        Status status = checkSignUpFields();
        if (!status.getStatus()) {
            AlertBox.display("User Sign up failed",
                    status.getStatusMessage());
            return;
        }
        try {
            User newUser = new User(
                    this.userNameSignUp.getText(),
                    this.passwordSignUp.getText());

            AllUsers.addUser(newUser);
            Data.saveData(AllUsers);
            System.out.println("DataSaved.");
        } catch (Exception e) {
            System.out.println("Something went wrong... " + e.toString());
        }
    }

    public void loginButton(javafx.event.ActionEvent actionEvent) {
        
        System.out.println("Login Button");
    }
}
