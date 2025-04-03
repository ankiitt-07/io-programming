package com.json.jsontoxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ConvertJsonToXml {
    public static void main(String[] args) {

        try{
            String json = "{\"name\":\"Jerry\",\"age\":22}";
            ObjectMapper mapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            Object obj1 = mapper.readValue(json,Object.class);

            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);
            System.out.println(xml);
            System.out.println("Json to Xml converted successfully..");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
