package com.csv.readcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/readcsv/content/StudentDetails.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line ;
            while((line= br.readLine()) != null){
                String[] data = line.split(",");
                System.out.println("ID: " + data[0]+" Name: " + data[1]);
            }
        }
        catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }
}
