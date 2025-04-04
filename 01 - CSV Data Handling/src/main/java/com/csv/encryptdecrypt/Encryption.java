package com.csv.encryptdecrypt;

import com.opencsv.CSVWriter;

import java.io.FileWriter;

public class Encryption {
    public void writeCsv(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] headers = {"Employee ID", "Name", "Email", "Salary"};
            writer.writeNext(headers);

            String[] employee1 = {"1", "Jerry",EncryptionUtil.encrypt("jerry@gmail.com"), EncryptionUtil.encrypt("50000")};
            String[] employee2 = {"2", "Ankit", EncryptionUtil.encrypt("ankit@gmail.com"), EncryptionUtil.encrypt("60000")};

            writer.writeNext(employee1);
            writer.writeNext(employee2);

            System.out.println("CSV file with encrypted data created successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
