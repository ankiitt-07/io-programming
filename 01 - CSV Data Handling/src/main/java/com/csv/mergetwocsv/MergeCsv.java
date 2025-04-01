package com.csv.mergetwocsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeCsv {
    public static void mergeCsv(String file1, String file2) {
        List<String[]> csvData = new ArrayList<String[]>();
        try(
            CSVReader csvReader1 = new CSVReader(new FileReader(file1));
            CSVReader csvReader2 = new CSVReader(new FileReader(file2));
        ){
            csvData.add(new String[] {"Id","Name","Age","Marks","Grade"});
            String[] line;
            csvReader1.readNext();
            while((line = csvReader1.readNext())!=null){
                csvData.add(new String[] {line[0],line[1],line[2],line[3]," , "});
            }
            String[] line2;
            csvReader2.readNext();
            while((line2 = csvReader2.readNext())!=null){
                for(int i=0; i<csvData.size(); i++){
                    if(csvData.get(i)[0].equals(line2[0])){
                        csvData.get(i)[4] = line2[1];
//                        csvData.get(i)[5] = line2[2];
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        String mergedCsv = "src/main/java/com/csv/mergetwocsv/content/MergedData.csv";
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter(mergedCsv))){
            csvWriter.writeAll(csvData);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        String inputFile1 = "src/main/java/com/csv/mergetwocsv/content/Student1.csv";
        String inputFile2 = "src/main/java/com/csv/mergetwocsv/content/Student2.csv";
        System.out.println("No errors detected!");
        System.out.println("Student List Merged!");
        mergeCsv(inputFile1, inputFile2);
    }
}