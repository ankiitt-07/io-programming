package com.csv.modifyValue;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ModifyCsvFile {
    public static void modify(String inputfilepath, String outputfilepath) {
        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputfilepath))) {
            String[] line;
            int departmentColumn = 2;
            int salaryColumn = 3;

            // Read & Store Header
            String[] header = reader.readNext();
            if (header != null) {
                data.add(header);
            }

            while ((line = reader.readNext()) != null) {
                if (line[departmentColumn].equals("IT")) {
                    try {
                        double salary = Double.parseDouble(line[salaryColumn]);
                        salary *= 1.10; // Increase salary by 10%
                        line[salaryColumn] = String.format("%.2f", salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for: " + line[departmentColumn]);
                    }
                }
                data.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        // Write modified data back to file
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputfilepath))) {
            csvWriter.writeAll(data);
            System.out.println("Updated file saved as " + outputfilepath);
        } catch (Exception e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputfilepath = "src/main/java/com/csv/modifyValue/content/Employee.csv";
        String outputfilepath = "src/main/java/com/csv/modifyValue/content/ModifiedEmployee.csv";
        modify(inputfilepath,outputfilepath);
    }
}
