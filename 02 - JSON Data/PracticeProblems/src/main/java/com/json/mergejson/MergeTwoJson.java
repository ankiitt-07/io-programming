package com.json.mergejson;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoJson {
    public static void main(String[] args) {
        try {
            String filepath1 = "src/main/java/com/json/mergejson/content/file1.json";
            String filepath2 = "src/main/java/com/json/mergejson/content/file2.json";
            String mergedPath = "src/main/java/com/json/mergejson/content/merged.json";


            // Read JSON files as Strings
            String content1 = new String(Files.readAllBytes(Paths.get(filepath1)));
            String content2 = new String(Files.readAllBytes(Paths.get(filepath2)));

            JSONObject obj1 = new JSONObject(content1);
            JSONObject obj2 = new JSONObject(content2);
            JSONObject merged = new JSONObject();

            for (String key : obj1.keySet()) {
                merged.put(key, obj1.get(key));
            }
            for (String key : obj2.keySet()) {
                merged.put(key, obj2.get(key));
            }

            System.out.println(merged.toString(4));

           try(BufferedWriter writer = new BufferedWriter(new FileWriter(mergedPath))) {
               writer.write(merged.toString(4));
               writer.flush();
               System.out.println("JSON File Merged Successfully..");
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
