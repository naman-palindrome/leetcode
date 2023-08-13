package org.example.Utility;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Utility {
    public static int[][] readJsonData(String filePath) {
        try {
            // Read the contents of the .json file
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

            // Parse the JSON data into a 2D array of integers
            Gson gson = new Gson();
            int[][] array = gson.fromJson(jsonData, int[][].class);

            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
