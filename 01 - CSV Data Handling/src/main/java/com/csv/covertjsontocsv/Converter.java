package com.csv.covertjsontocsv;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public static void JsonToCsv(String jsonFile, String csvFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            // Deserialize the JSON file into a List of Student object
            List<Student> students = Arrays.asList(objectMapper.readValue(new File(jsonFile), Student[].class));

            // Write the List of students to the CSV file
            writeToCsv(students,csvFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static  void writeToCsv(List<Student> students, String csvFile) {
        try(CSVWriter writer = new CSVWriter(new FileWriter(csvFile))){
            String[] header = new String[]{"Id","Name","Age"};
            writer.writeNext(header);

            //writing student data
            for (Student student : students) {
                writer.writeNext(new String[]{student.getId(),student.getName(),String.valueOf(student.getAge())});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  CsvToJson(String csvFile, String JsonFile){
        try(CSVReader reader = new CSVReader(new FileReader(csvFile));
            BufferedWriter br = new BufferedWriter(new FileWriter(JsonFile))){
                List<Student> students = new ArrayList<>();
                List<String[]> data = reader.readAll();
                ObjectMapper objectMapper = new ObjectMapper();

                for(int i = 1; i<data.size(); i++){
                    String[] row = data.get(i);
                    Student student = new Student(row[0],row[1],Integer.parseInt(row[2]));
                    students.add(student);
                }
                String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
                br.write(jsonOutput);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        String jsonFileName = "src/main/java/com/csv/covertjsontocsv/content/demo.json";
        String csvFile = "src/main/java/com/csv/covertjsontocsv/content/file.csv";
        String ouputJson = "src/main/java/com/csv/covertjsontocsv/content/demoout.json";
        String ouputCsv = "src/main/java/com/csv/covertjsontocsv/content/fileout.csv";
        JsonToCsv(jsonFileName,ouputCsv);
        CsvToJson(csvFile,ouputJson);

    }

}
