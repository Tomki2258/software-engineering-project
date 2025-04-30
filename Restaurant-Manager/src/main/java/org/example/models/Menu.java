package org.example.models;

import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.umcsuser.carrent.utils.JsonFileStorage;

public class Menu implements IMenu {
    private List<Product> productList = new ArrayList<>();
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.json");
    private final JsonFileStorage<Product> storage =
            new JsonFileStorage<>(String.valueOf(PRODUCTS_PATH), new TypeToken<List<Product>>() {
            }.getType());

    public Menu() {
        loadProducts();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void printProducts() {
        for (Product product : productList) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
    }

    private void loadProducts() {
        storage.load();
    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        return true;
    }

    public void save() {
        storage.save(productList);
    }
}
