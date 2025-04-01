package com.csv.validatecsv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class ValidateCsv {
    public static void validatecsv(String fileName) {
        try(CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] header = reader.readNext();
            String[] line;
            while((line= reader.readNext())!=null){
                if(!Regex.validateEmail(line[2]) && !Regex.validatePhone(line[3])){
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csv/validatecsv/content/Contact.csv";
        System.out.println("-----Validating CSV file-----");
        System.out.println("No errors detected!");
        validatecsv(filePath);
    }
}
