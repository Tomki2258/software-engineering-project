package org.example;

import org.example.models.Drink;
import org.example.models.Food;
import org.example.models.Menu;
import org.example.models.Product;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.printProducts();

        menu.save();
    }
}