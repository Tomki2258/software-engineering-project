package org.example.models;

import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.umcsuser.carrent.utils.JsonFileStorage;
import org.example.Repositories.ProductRepository;
import org.example.factories.ProductFactory;
import org.example.models.product.Product;

public class Menu implements IMenu {
    private List<Product> productList = new ArrayList<>();
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.csv");
    private ProductRepository productRepository = new ProductRepository(
            ProductFactory.loadProducts()
    );
    private final JsonFileStorage<Product> storage =
            new JsonFileStorage<>(String.valueOf(PRODUCTS_PATH), new TypeToken<List<Product>>() {
            }.getType());

    public Menu() {
        productList = productRepository.getProductList();
    }

    public void printProducts() {
        int index = 0;
        for (Product product : productList) {
            System.out.println(index + " " + product.describe());
            index++;
        }
    }

    public void printMenuProducts() {
        int index = 1;
        for (Product product : productList) {
            if (product.isAvailable()) {
                String response = String.format("%d %s", index
                        , product.describeMenu());
                index++;
                System.out.println(response);
            }
        }
    }

    @Override
    public boolean addProduct(Product product) {
        productList.add(product);
        productRepository.save();
        return true;
    }

    @Override
    public boolean removeProduct(int index) {
        productList.remove(index);
        return true;
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    public void modyfiProductAmount(int index,int amount){
        productList.get(index).resupplyProduct(amount);
    }
}
