package org.example;

import org.example.models.Menu;
import org.example.models.client.Client;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        
        menu.printProducts();

        menu.save();
    }
}