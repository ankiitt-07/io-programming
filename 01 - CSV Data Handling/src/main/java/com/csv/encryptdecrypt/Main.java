package com.csv.encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/csv/encryptdecrypt/content/EmployeeData.csv";

        Encryption encryptionWriter = new Encryption();
        Decryption decryptionReader = new Decryption();

//        encryptionWriter.writeCsv(csvFilePath);
        decryptionReader.readCsv(csvFilePath);
    }
}
