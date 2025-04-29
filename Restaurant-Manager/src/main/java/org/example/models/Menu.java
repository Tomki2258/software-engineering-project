package org.example.models;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Menu implements IMenu {
    private List<Product> productList = new ArrayList<>();
    private static final URI PRODUCTS_PATH = URI.create("org/example/data/products.json");

    Menu() {
        loadProducts();
    }

    public List<Product> getProductList() {
        return productList;
    }

    private void loadProducts() {
        //File productsFile  = new File(PRODUCTS_PATH);
        Product product = new Drink(18,
                "Pifko Perła",
                15,
                UUID.randomUUID().toString(), 5.5,
                2000);
        productList.add(product);
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }
}
