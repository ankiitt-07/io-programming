package com.csv.readcsv;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/readcsv/content/StudentDetails.csv";
        try(CSVReader reader = new CSVReader(new FileReader(filepath))){
            String[] line ;
            while((line = reader.readNext()) != null){
                System.out.println(line[0]+" " + line[1]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
