package com.json.objecttojson;

public class Car {
    int id;
    String model;
    String color;
    double price;

    public Car(int id, String model, String color, double price) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
