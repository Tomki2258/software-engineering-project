package org.example.models;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.umcsuser.carrent.utils.JsonFileStorage;

public class Menu implements IMenu {
    private List<Product> productList = new ArrayList<>();
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.csv");
    private final JsonFileStorage<Product> storage =
            new JsonFileStorage<>(String.valueOf(PRODUCTS_PATH), new TypeToken<List<Product>>() {
            }.getType());

    public Menu() {
        productList =  loadProducts();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void printProducts() {
        for (Product product : productList) {
            System.out.println(product.describe());
        }
    }
    private Product buildFromLine(List<String> splitted){
        Product product = null;
        if(splitted.getFirst().equals("DRINK")){
            product = new Drink(
                    splitted.get(1),
                    splitted.get(2),
                    Float.parseFloat(splitted.get(3).replace(",", ".")),
                    Integer.parseInt(splitted.get(4)),
                    Double.parseDouble(splitted.get(5).replace(",",".")),
                    Integer.parseInt(splitted.get(6))
            );
        }else if(splitted.getFirst().equals("FOOD")){
            product = new Food(
                    splitted.get(1),
                    splitted.get(2),
                    Float.parseFloat(splitted.get(3).replace(",",".")),
                    Integer.parseInt(splitted.get(4)),
                    Integer.parseInt(splitted.get(5)),
                    Boolean.parseBoolean(splitted.get(6)),
                    Integer.parseInt(splitted.get(7))
            );
        }
        return product;
    }
    private List<Product> loadProducts() {
        List<Product> loaded = new ArrayList<>();
        File file = new File(String.valueOf(PRODUCTS_PATH));
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                List<String> splitted = List.of(line.split(";"));
                loaded.add(buildFromLine(splitted));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loaded;

    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        return true;
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(String.valueOf(PRODUCTS_PATH));
            StringBuilder toSave = new StringBuilder();
            for (Product product : productList){
                toSave.append(product.csv()).append("\n");
            }

            writer.write(String.valueOf(toSave));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
