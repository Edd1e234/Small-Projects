package com.Flashcard.Frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FX extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                SignIn.class.getResource("SignIn.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("loader Failed");
        }
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();


    }
}
