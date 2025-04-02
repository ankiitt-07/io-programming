package com.json.objecttojson;

import org.json.JSONObject;

public class CarObjToJson {
    public static void main(String[] args) {
        Car car = new Car(124,"SUV","Black",10000000.00);

        JSONObject obj = new JSONObject(car);
        System.out.println(obj.toString(4));
    }
}
