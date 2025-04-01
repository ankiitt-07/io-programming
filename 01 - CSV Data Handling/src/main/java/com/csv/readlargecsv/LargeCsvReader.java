package com.csv.readlargecsv;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class LargeCsvReader {
    public static void processCsvFile(String fileName,int batchSize) {
        try(CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] line;
            int counter = 0;
            int totalRecords = 0;
            reader.readNext();
            while((line = reader.readNext())!=null){
                counter++;
                totalRecords++;

                if(counter == batchSize){
                    System.out.println("Processed "+totalRecords+" records");
                    counter = 0;
                }
            }
            if(counter > 0){
                System.out.println("Processed "+totalRecords+" records in total");
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csv/readlargecsv/content/StudentsData.csv";
        int batchSize = 100;
        processCsvFile(filePath, batchSize);
        System.out.println("Task Completed!");
    }
}
