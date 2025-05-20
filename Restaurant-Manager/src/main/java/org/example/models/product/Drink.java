package org.example.models.product;

import java.util.UUID;

public class Drink extends Product {
    private double alcoholAmount;
    private int volume;

    public Drink(String UID, String name, float price, int availableCount, double alcoholAmount, int volume) {
        super(price, name, availableCount, UID);
        this.alcoholAmount = alcoholAmount;
        this.volume = volume;
    }


    //konstruktor do generowania nowych produktów
    public Drink(String name, float price, int availableCount, double alcoholAmount, int volume) {
        super(price, name, availableCount, UUID.randomUUID().toString());
        this.alcoholAmount = alcoholAmount;
        this.volume = volume;
    }


    public double getAlcoholAmount() {
        return alcoholAmount;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String csv() {
        return String.format("DRINK;%s;%s;%f;%d;%f;%d"
                , super.getUUID()
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getAlcoholAmount()
                , getVolume()
        );
    }

    @Override
    public String describe() {
        return String.format("[Drink] UUID:%s Name:%s Count: %d Price:%f Volume:%d (ML) Alcohol %f"
                , super.getUUID()
                , super.getName()
                , super.getAvailableCount()
                , super.getPrice()
                , getVolume()
                , getAlcoholAmount());
    }

    @Override
    public String describeMenu() {
        return String.format("Name:%s Price:%f Count:%d Volume:%d (ML) Alcohol %f"
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getVolume()
                , getAlcoholAmount());
    }

    @Override
    public boolean verification() {
        if (alcoholAmount > 0) return true;
        else return false;
    }
}
