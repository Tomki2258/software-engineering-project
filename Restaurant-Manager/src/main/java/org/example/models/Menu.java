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

import com.umcsuser.carrent.utils.JsonFileStorage;
import org.example.factories.ProductFactory;
import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.IProduct;
import org.example.models.product.Product;

public class Menu implements IMenu {
    private List<Product> productList = new ArrayList<>();
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.csv");
    private ProductFactory productFactory = new ProductFactory();
    private final JsonFileStorage<Product> storage =
            new JsonFileStorage<>(String.valueOf(PRODUCTS_PATH), new TypeToken<List<Product>>() {
            }.getType());

    public Menu() {
        productList = productFactory.loadProducts();
    }

    public void printProducts() {
        for (Product product : productList) {
            System.out.println(product.describe());
        }
    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        return true;
    }

    @Override
    public boolean removeProduct(int index) {
        productList.remove(index);
        return true;
    }

    @Override
    public List<IProduct> getProductList() {
        List<IProduct> newList = new ArrayList<>(productList);
        return newList;
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
