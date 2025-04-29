package org.example.models;

public class Food extends Product{
    private int weight;
    private boolean isVege;
    private int calories;

    public Food(float price, String name, int availableCount, String UID) {
        super(price, name, availableCount, UID);
    }

    public int getWeight() {
        return weight;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVege() {
        return isVege;
    }
}
