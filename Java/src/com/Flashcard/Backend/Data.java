package com.Flashcard.Backend;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Data {
    private static final String FILE_LOCATION =
            "/Users/greywind/Desktop/Project/Java/src/com/Flashcard/Backend/" +
                    "user.txt";
    private static Gson gson = new Gson();

    public static void saveData(AllUsers users) {
        userWriteToFile(gson.toJson(users));

    }

    private static void userWriteToFile(String data) {
        File file = new File(FILE_LOCATION);
        if (!file.exists()) {
            System.out.println("File is not here");
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(FILE_LOCATION);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data.toString());
            bufferedWriter.close();
            System.out.println(data.toString());
            System.out.println("Made it here");
        } catch (IOException e) {
            System.out.println("Something went wrong");
            System.out.println(e.toString());
        }
    }

    public static AllUsers getAllusers() {
        File file = new File(FILE_LOCATION);
        // Check here.
        AllUsers allUsers = new AllUsers();
        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8);
            JsonReader jsonReader = new JsonReader(isReader);
            allUsers = gson.fromJson(jsonReader, AllUsers.class);
        } catch (Exception e) {
            System.out.println("Error load cache from file " + e.toString());
        }

        return allUsers;
    }
}
