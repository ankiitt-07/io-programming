package com.csv.writecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/csv/writecsv/content/output.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("01,Ankit,FSO,550000\n");
            writer.write("02,Jerry,IT,600000\n");
            writer.write("03,Shadow,BusinessDevelopment,800000\n");
            writer.write("04,Paul,ProjectHandler,750000\n");
            writer.write("05,Domnic,HR,8555000\n");
            System.out.println("CSV file written successfully!");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
