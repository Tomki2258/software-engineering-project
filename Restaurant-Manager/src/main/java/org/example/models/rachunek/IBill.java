package org.example.models.rachunek;

import org.example.models.Order;

public interface IBill {

    public void addOrder(Order order);
    public void setTip(float tip);
    public void fulfill();
    public boolean isFinalized();
    public String getUID();
}
