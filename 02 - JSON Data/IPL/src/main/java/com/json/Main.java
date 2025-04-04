package com.json;

import com.json.inputhandler.InputHandler;

public class Main {
    public static void main(String[] args) {
        String inputCsvFilepath = "src/main/java/com/json/content/ipl.csv";
        String inputJsonFilepath = "src/main/java/com/json/content/ipl.json";

        InputHandler.csvFile(inputCsvFilepath);
        InputHandler.jsonFile(inputJsonFilepath);
    }
}