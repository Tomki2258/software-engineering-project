package org.example.models.product;

public abstract class Product implements IProduct {
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
    public void reduceAvailableCount(){
        this.availableCount--;
    }
    public void resupplyProduct(int amount){
        this.availableCount += amount;
    }
    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Boolean isAvailable() {
        return availableCount > 0;
    }

    @Override
    public String returnUID() {
        return UID;
    }

    public abstract String csv();
    public abstract String describe();
    public abstract String describeMenu();
    public abstract boolean verification();
}