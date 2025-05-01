package org.example.models;

public class Drink extends Product {
    private double alcoholAmount;
    private int volume;

    public Drink(String UID, String name, float price, int availableCount, double alcoholAmount, int volume) {
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
        return String.format("DRINK - UUID:%s Name:%s Price:%f Count:%d Volume:%d (ML) Alcohol %f"
                , super.getUUID()
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getVolume()
                , getAlcoholAmount());
    }
}
