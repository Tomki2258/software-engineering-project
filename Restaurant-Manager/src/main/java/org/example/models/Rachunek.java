package org.example.models;

import java.util.Date;
import java.util.UUID;

public class Rachunek implements IRachunek {
    private Order order;
    private float orderValue;
    private float tip;
    private boolean isFulfilled;
    private Date openDate;
    private Date fullFillDate;
    private final String UID;

    public Rachunek() {
        this.order = null;
        this.orderValue = 0;
        this.tip = 0;
        this.isFulfilled = false;
        this.openDate = null;
        this.fullFillDate = null;
        this.UID = UUID.randomUUID().toString();
    }

    public void addOrder(Order order) {
        this.order = order;
    }

    public void setTip(float tip) {
        this.tip = tip;
    }

    public void fulfill() {
        this.isFulfilled = true;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public String getUID() {
        return UID;
    }

    public float getTotalValue() {
        return orderValue + tip;
    }
}