package com.csv.studentcsv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

// Student class to hold CSV data
class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class ConvertCsvToStudentObj {
    public static List<Student> readCsvToStudents(String csvFile) {
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                String id = line[0];
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                double marks = Double.parseDouble(line[3]);
                students.add(new Student(id, name, age, marks));
            }
        } catch (Exception e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        return students;
    }

    public static void main(String[] args) {
        System.out.println("Reading CSV File and Converting to Student Objects");
        String filepath = "src/main/java/com/csv/csvtoobjects/content/StudentRecords.csv";
        List<Student> studentList = readCsvToStudents(filepath);

        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
