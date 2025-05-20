package org.example.Repositories;

import org.example.models.product.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class ProductRepository {
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.csv");
    private List<Product> productList;

    public ProductRepository(List<Product> productList){
        this.productList = productList;
    }
    public List<Product> getProductList(){
        return this.productList;
    }
    public void save(){
        File file = new File(PRODUCTS_PATH);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            FileWriter fileWriter = new FileWriter(file);
            for(Product product: productList){
                stringBuilder.append(product.csv()).append("\n");
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
