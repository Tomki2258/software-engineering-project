package org.example.factories;

import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductFactory {
    private static final URI PRODUCTS_PATH = URI.create("src/main/java/org/example/data/products.csv");

    public Product buildFromLine(List<String> splitted){
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
    public List<Product> loadProducts() {
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
}
