package com.json.readandextract;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonAndExtract {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/json/readandextract/content/file.json";
        try{
            String content = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONArray arr = new JSONArray(content);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                System.out.println("Name:"+obj.optString("name"));
                System.out.println("Email:"+obj.optString("email"));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
