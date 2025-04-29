package org.example.models;

public class Food extends Product{
    private int weight;
    private boolean isVege;
    private int calories;

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
