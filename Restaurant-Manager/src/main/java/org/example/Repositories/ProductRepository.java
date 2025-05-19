package org.example.Repositories;

import org.example.models.product.Product;

import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository(List<Product> productList){
        this.productList = productList;
    }
    public List<Product> getProductList(){
        return this.productList;
    }

}
