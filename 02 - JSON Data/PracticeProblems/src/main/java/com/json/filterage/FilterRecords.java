package com.json.filterage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class FilterRecords {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\": \"Ankit\", \"age\": 27}, {\"name\": \"Shadow\", \"age\": 20}, {\"name\": \"Jerry\", \"age\": 16}]";

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonArray);

            List<JsonNode> list = new ArrayList<>();
            for (JsonNode jsonNode : node) {
                if(jsonNode.get("age").asInt() > 25){
                    list.add(jsonNode);
                }
            }
            String filter = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(filter);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
