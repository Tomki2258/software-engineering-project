package org.example.models.product;

public interface IProduct {
    public void setPrice(float price);
    public void setName(String name);
    public Boolean isAvailable();
    public String returnUID();
}
