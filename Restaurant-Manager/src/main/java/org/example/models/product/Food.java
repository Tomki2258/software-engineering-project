package org.example.models.product;

public class Food extends Product {
    private int weight;
    private boolean isVege;
    private int calories;

    public Food(String UID,String name,float price, int availableCount, int weight, boolean isVege, int calories) {
        super(price, name, availableCount, UID);
        this.weight = weight;
        this.isVege = isVege;
        this.calories = calories;
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


    @Override
    public String csv() {
        return String.format("FOOD;%s;%s;%f;%d;%d;%b;%d"
                , super.getUUID()
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getWeight()
                , isVege()
                ,getCalories());
    }

    @Override
    public String describe() {
        return String.format("Name:%s Price:%f Count:%d Weight:%d IsVege:%b Calories:%d"
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getWeight()
                , isVege()
                ,getCalories());
    }

    @Override
    public String describeMenu() {
        return String.format("Name:%s Price:%f Count:%d Weight:%d IsVege:%b Calories:%d"
                , super.getName()
                , super.getPrice()
                , super.getAvailableCount()
                , getWeight()
                , isVege()
                ,getCalories());
    }
}
