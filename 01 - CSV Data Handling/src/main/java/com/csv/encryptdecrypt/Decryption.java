package com.csv.encryptdecrypt;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;


public class Decryption {
    public void readCsv(String filePath){

        List<String[]> decryptedRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] header = reader.readNext();
            if (header != null) {
                decryptedRecords.add(header); // Add header as is
            }
            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length < 4) {
                    System.out.println("Invalid data format");
                    continue;
                }

                String employeeId = record[0];
                String name = record[1];
                String email = record[2];
                String salary = record[3];

                String decryptedEmail = EncryptionUtil.isValidEncryptedData(email) ? EncryptionUtil.decrypt(email) : email;
                String decryptedSalary = EncryptionUtil.isValidEncryptedData(salary) ? EncryptionUtil.decrypt(salary) : salary;

                // Store the decrypted record
                decryptedRecords.add(new String[]{employeeId, name, decryptedEmail, decryptedSalary});

                System.out.println("Employee ID: " + employeeId);
                System.out.println("Name: " + name);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("----------------------------");
            }

            // Write the decrypted data back to the same file
            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
                writer.writeAll(decryptedRecords);
                System.out.println("Decrypted data written back to same file");
            }

        } catch (Exception e) {
            System.out.println("Error processing CSV file: " + e.getMessage());
        }
    }
}
