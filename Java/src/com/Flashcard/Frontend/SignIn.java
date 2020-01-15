package com.Flashcard.Frontend;


import com.Flashcard.Backend.AllUsers;
import com.Flashcard.Backend.Data;
import com.Flashcard.Backend.Status.Status;
import com.Flashcard.Backend.Status.StatusUser;
import com.Flashcard.Backend.User;
import com.Flashcard.Frontend.Menu.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {
    @FXML
    private TextField passwordSignUp, userNameSignUp, username;
    @FXML
    private PasswordField password;
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
            User newUser = new User();
            newUser.setPassword(passwordSignUp.getText());
            newUser.setUserName(userNameSignUp.getText());


            AllUsers.addUser(newUser);
            Data.saveData(AllUsers);
            System.out.println("DataSaved.");
        } catch (Exception e) {
            System.out.println("Something went wrong... " + e.toString());
        }
    }

    public void loginButton(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println(password.getText());
        StatusUser statusUser = AllUsers.getUser(
                username.getText(), password.getText());
        if (!statusUser.getStatus()) {
            AlertBox.display("Failed", statusUser.getStatusMessage());
            return;
        }
        User user = statusUser.getUser();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu/classes.fxml"));

        try {
            loader.load();
        } catch (IIOException e) {
            // TODO(Edd1e234): Do something here.
        }

        Classes classes = loader.getController();
        classes.setUser(user);

        Stage stage =
                (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
        System.out.println("User: " + user.getUserName());
    }
}
