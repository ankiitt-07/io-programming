package com.csv.generatecsvreport;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateCsvReportFromDatabase {
    public void generateCsvReportFromDatabase(String filePath) {
        List<String[]> data = getEmployeeData();

        if(data.isEmpty()){
            System.out.println("No employee data found");
            return;
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter(filePath))){
            writer.writeNext(new String[]{"Id","EmployeeName","Department","Salary"});

            writer.writeAll(data);
            System.out.println("CSV file generated Successfully....");
        } catch (Exception e) {
            System.out.println("Error occured while writing CSV file");
        }


    }

    private List<String[]> getEmployeeData(){
        return List.of(
                new String[]{"1","Jerry","HR","5000000"},
                new String[]{"2","Ankit","Developer","5478456900"},
                new String[]{"3","Shadow","Analyst","8778555"}
        );
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/csv/generatecsvreport/contentout/EmployeeReport.csv";

        GenerateCsvReportFromDatabase gen = new GenerateCsvReportFromDatabase();
        gen.generateCsvReportFromDatabase(filePath);
    }

}
