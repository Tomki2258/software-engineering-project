package org.example.models;

public abstract class Product {
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

    public String getUUID() {
        return UID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public abstract String csv();
    public abstract String describe();
}