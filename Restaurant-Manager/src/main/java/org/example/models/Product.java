package org.example.models;

public class Product {
    private float price;
    private String name;
    private int availableCount;
    private String UID;

    public Product(float price, String name, int availableCount, String UID) {
        this.price = price;
        this.name = name;
        this.availableCount = availableCount;
        this.UID = UID;
    }

    public float getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
}
