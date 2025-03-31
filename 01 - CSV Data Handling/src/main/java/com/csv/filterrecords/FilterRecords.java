package com.csv.filterrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/filterrecords/content/StudentsRecords.csv";
        try(CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] line;
            int marksColumn = 3;
            reader.readNext();
            while((line = reader.readNext())!=null){
                if(Integer.parseInt(line[marksColumn])>= 80){
                    System.out.println(line[marksColumn]);
                }
            }

        }
        catch(Exception e){
            e.getMessage();
        }
    }
}
