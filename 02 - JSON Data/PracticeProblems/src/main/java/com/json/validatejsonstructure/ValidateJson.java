package com.json.validatejsonstructure;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"Jerry\",\"age\":22}";
        ObjectMapper mapper = new ObjectMapper();
        try{
            Person person = mapper.readValue(json,Person.class);
            System.out.println(person);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
