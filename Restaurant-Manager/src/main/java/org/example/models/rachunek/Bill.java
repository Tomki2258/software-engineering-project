package org.example.models.rachunek;

import org.example.models.Order;
import org.example.models.product.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bill implements IBill {
    private Order order;
    private float orderValue;
    private float tip;
    private boolean isFinalized;
    private String openDate;     // localDateTime
    private String  finalizedDate;// localDateTime
    private final String UID;

    public Bill(Order order) {
        this.order = order;
        this.orderValue = 0;
        this.tip = 0;
        this.isFinalized = false;
        this.openDate = String.valueOf(LocalDateTime.now());
        this.finalizedDate = null;
        this.UID = UUID.randomUUID().toString();
    }

    public void addOrder(Order order) {
        this.order = order;
    }

    public void setTip(float tip) {
        this.tip = tip;
    }

    public void fulfill() {
        this.isFinalized = true;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public String getUID() {
        return UID;
    }

    public float getTotalValue() {
        return order.calculateValue() + tip;
    }
    public void close(){
        this.finalizedDate = String.valueOf(LocalDateTime.now());
    }
    public void describe() {
        String result = String.format("%s %f %f %s %s",
                this.UID,
                this.orderValue,
                this.tip,
                this.openDate,
                this.finalizedDate);
        System.out.println(result);
    }
}