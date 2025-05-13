package org.example.models;

import org.example.models.client.Client;
import org.example.models.product.Product;
import org.example.models.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> productList = new ArrayList<>();
    public Boolean addProduct(Product product, Client client, Staff staff){
        if(staff.verifyClient(client)) {
            productList.add(product);
            printProducts();
            return true;
        }
        return false;
    }
    public Boolean removeProduct(int index){
        if (productList.size() < index) {
            return false;
        }
        productList.remove(index);
        return true;
    }
    public void printProducts(){
        System.out.println("Aktualne produkty");
        for(Product product : productList){
            String response = String.format("%s %s", productList.indexOf(product) + 1,product.describeMenu());
            System.out.println(response);
        }
    }
}
