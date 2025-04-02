package com.json.createjsonobject;


import org.json.JSONArray;
import org.json.JSONObject;

public class StudentDataJson {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("Name", "Jerry");
        student.put("Age", 22);
        student.put("Gender", "Male");

        JSONObject student2 = new JSONObject();
        student2.put("Name", "Ankit");
        student2.put("Age", 22);
        student2.put("Gender", "Male");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Maths");
        jsonArray.put("English");

        student.put("Subjects",jsonArray);
        System.out.println(student.toString());

        student2.put("Subjects",jsonArray);
        System.out.println(student2.toString());


    }
}
