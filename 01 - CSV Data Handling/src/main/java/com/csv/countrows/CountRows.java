package com.csv.countrows;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/countrows/content/EmployeeDetails.csv";
        try(CSVReader reader = new CSVReader(new FileReader(filepath))) {
            int counter = 0;
            reader.readNext(); //Skip the header row
            while((reader.readNext()) != null){
                counter++;
            }
            System.out.println(counter);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
