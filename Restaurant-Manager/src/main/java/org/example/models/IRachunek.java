package org.example.models;

public interface IRachunek {

    public void addOrder(Order order);
    public void setTip(float tip);
    public void fulfill();
    public boolean isFulfilled();
    public String getUID();
}
