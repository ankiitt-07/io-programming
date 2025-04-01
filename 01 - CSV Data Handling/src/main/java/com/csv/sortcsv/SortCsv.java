package com.csv.sortcsv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortCsv {
    public static void sortCsv(String csvFile) {
        ArrayList<String[]> csvData = new ArrayList<String[]>();
        try(CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while((line= reader.readNext())!=null) {
                csvData.add(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        csvData.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                Normally, Double.compare(o1[3], o2[3]) would sort in ascending order (smallest to largest).
//                Reversing the arguments (o2[3], o1[3]) flips the order, making it largest to smallest.
                return Double.compare(Double.parseDouble(o2[3]), Double.parseDouble(o1[3]));
            }
        });


        for (int i = 0; i < 5 && i<csvData.size(); i++) { //Preventing IndexOutOfBond
            System.out.println(Arrays.toString(csvData.get(i)));
        }
    }

    public static void main(String[] args) {
        System.out.println("--------Sorting Salary in Descending Order---------");
        System.out.println("Top 5 Highest Paid Employees : ");
        String filepath = "src/main/java/com/csv/sortcsv/content/EmployeeRecords.csv";
        sortCsv(filepath);
    }
}
