package com.json.csvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/json/csvtojson/content/data.csv";

        List<Map<String, String>> jsonData = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();

            String[] row;
            while((row = reader.readNext())!=null){
                Map<String, String> jsonObj = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    jsonObj.put(header[i], row[i]);
                }
                jsonData.add(jsonObj);
            }
            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
            System.out.println(jsonOutput);
            System.out.println("Converted Successfully..");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
