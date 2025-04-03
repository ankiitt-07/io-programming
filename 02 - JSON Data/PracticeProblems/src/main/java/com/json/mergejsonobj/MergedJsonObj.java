package com.json.mergejsonobj;

import org.json.JSONObject;

public class MergedJsonObj {
    public static void main(String[] args) {
        String json1 = "{\"name\":\"Jerry\",\"age\":22}";
        String json2 = "{\"email\":\"Jerry@gmail.com\",\"city\":Rajpura}";

        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }
        System.out.println(obj1.toString(4));
    }
}
