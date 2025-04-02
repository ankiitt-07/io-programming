package com.csv.writecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class WriteCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/writecsv/content/output.csv";
        List<String[]> data = Arrays.asList(
                new String[] {"Id","Name","Department","Salary"},
                new String[]{"1","Ankit","HR","85000"},
                new String[]{"2","Jerry","ProductManager","657555"},
                new String[]{"3","Anmol","Analyst","785444"},
                new String[]{"4","Rishav","Developer","120000"}
                );

        try(CSVWriter writer = new CSVWriter(new FileWriter(filepath))){
            writer.writeAll(data);
            System.out.println("Csv File witten Successfully..");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
