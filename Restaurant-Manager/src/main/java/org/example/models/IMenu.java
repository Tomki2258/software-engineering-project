package org.example.models;

import org.example.models.product.IProduct;
import org.example.models.product.Product;

import java.util.List;

public interface IMenu {
    public boolean addProduct(Product product);
    public boolean removeProduct(int index);
    public List<IProduct> getProductList();
}
