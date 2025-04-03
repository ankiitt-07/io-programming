package com.json.readandprintjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class ReadJsonAndPrint {
    public static void main(String[] args) {
        String json = "{\"name\":\"Jerry\",\"age\":25,\"gender\":\"male\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);
//            System.out.println(node);
            printJson(node,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), parentKey + entry.getKey() + ".");
            }
        } else {
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " : " + node.asText());
        }
    }
}
