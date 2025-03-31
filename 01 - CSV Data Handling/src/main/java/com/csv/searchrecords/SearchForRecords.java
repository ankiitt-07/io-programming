package com.csv.searchrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class SearchForRecords {
    public static void search(String filepath,String employeeName)  {
        try(CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] line;
            int nameColumn = 1;
            int departmentColumn = 2;
            int salaryColumn = 3;
            while ((line = reader.readNext()) != null) {
                if (line.length > salaryColumn && line[nameColumn].equalsIgnoreCase(employeeName)) {
                    System.out.println("Employee Found: " + line[nameColumn]);
                    System.out.println("Department: " + line[departmentColumn]);
                    System.out.println("Salary: " + line[salaryColumn]);
                    System.out.println("------------------------");
                    return;
                }
            }
//            throw new Exception("Employee Not Found");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/searchrecords/content/EmployeeData.csv";
        search(filepath,"Pauli");


    }
}
