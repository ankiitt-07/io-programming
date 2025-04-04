package com.json.jsonreportdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateJsonReport {
    public static void main(String[] args) {
        List<Map<String, Object>>  list = new ArrayList<>();

        Map<String, Object> student1 = new HashMap<>();
        student1.put("name", "Jerry");
        student1.put("age", 23);
        student1.put("class",10);

        Map<String, Object> student2 = new HashMap<>();
        student2.put("name", "Ankit");
        student2.put("age", 22);
        student2.put("class",11);

        Map<String, Object> student3 = new HashMap<>();
        student3.put("name", "Shadow");
        student3.put("age", 20);
        student3.put("class",12);

        list.add(student1);
        list.add(student2);
        list.add(student3);

        try{
            ObjectMapper mapper = new ObjectMapper();

            String jsonReport = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(jsonReport);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }



    }
}
