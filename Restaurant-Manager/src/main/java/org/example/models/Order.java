package org.example.models;

import org.example.models.product.Product;

import java.util.List;

public class Order {
    List<Product> productList;
    public Boolean addProduct(Product product){
        // TODO warunki sprawdzenia poprawności produktu
        productList.add(product);
        return true;
    }
    public Boolean removeProduct(int index){
        if (productList.size() < index) {
            return false;
        }
        productList.remove(index);
        return true;
    }
}
