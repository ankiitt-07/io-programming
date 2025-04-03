package com.json.validateschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class ValidateSchemaJson {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/com/json/validateschema/Schema.json";
        String json = "{ \"id\": 1, \"name\": \"Ankit\", \"email\": \"abc@test.com\" }";

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(new File(jsonFilePath));

            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema schema = schemaFactory.getJsonSchema(node);

            JsonNode jsonData = mapper.readTree(json);

            if(schema.validate(jsonData).isSuccess()){
                System.out.println("Json Schema Validated...");
            }
            else{
                System.out.println("Invalid JSON");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
