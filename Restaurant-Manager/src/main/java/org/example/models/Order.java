package org.example.models;

import org.example.models.client.Client;
import org.example.models.product.Product;
import org.example.models.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> productList = new ArrayList<>();

    public Boolean addProduct(Product product, Client client, Staff staff){
        if(product.isAvailable() == false) {
            System.out.println("Produkt nie jest dostępny");
            return false;
        }
        if(product.verification() && staff.verifyClient(client) == false) {
            System.out.println("Klient jest za młody");
            return false;
        }

        System.out.println("Udane dodanie produktu");
        productList.add(product);
        printProducts();
        return true;
    }

    public Boolean removeProduct(int index){
        if (productList.size() <= index) {
            return false;
        }
        productList.get(index).resupplyProduct(1);
        productList.remove(index);
        return true;
    }

    public void printProducts(){
        System.out.println("Aktualne produkty");
        int index = 0;
        for(Product product : productList){
            String response = String.format("%s %s", ++index, product.describeMenu());
            System.out.println(response);
        }
    }

    public List<Product> getProductList(){
        return productList;
    }

    public float calculateValue(){
        float sum = 0;
        for (Product product : productList){
            sum += product.getPrice();
        }
        return sum;
    }

    public int orderLength() {
        return productList.size();
    }
}
