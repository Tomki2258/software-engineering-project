package org.example.models;

public class Drink extends Product{
    private double alcoholAmount;
    private int volume;

    public Drink(float price, String name, int availableCount, String UID, double alcoholAmount, int volume) {
        super(price, name, availableCount, UID);
        this.alcoholAmount = alcoholAmount;
        this.volume = volume;
    }


    public double getAlcoholAmount() {
        return alcoholAmount;
    }

    public int getVolume() {
        return volume;
    }
}
