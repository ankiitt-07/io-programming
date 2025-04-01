package com.csv.detectduplicatescsv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void detect(String filename) {
        Set<String> duplicates = new HashSet<String>();
        try(CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] line;
            reader.readNext();
            while((line = reader.readNext())!=null){
                if(duplicates.contains(line[0])){
                    System.out.println("Duplicate detected:-");
                    System.out.println(line[0]+", "+line[1]+", "+line[2]+", "+line[3]);
                }
                duplicates.add(line[0]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csv/detectduplicatescsv/content/StudentsRecords.csv";
        detect(filePath);
    }
}
