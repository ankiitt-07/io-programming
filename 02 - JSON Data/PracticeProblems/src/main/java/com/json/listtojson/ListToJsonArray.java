package com.json.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Ankit",22,"Male"),
                new Person("Jerry",23,"Male"),
                new Person("Chloee",21,"Female")
        );

        try{
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(json);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
