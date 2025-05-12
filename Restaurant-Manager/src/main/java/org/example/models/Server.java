package org.example.models;

import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.Product;
import org.example.models.rachunek.IRachunek;
import org.example.models.staff.IStaff;
import org.example.models.staff.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private List<Staff> staffList = new ArrayList<>();
    private List<IRachunek> rachunekList = new ArrayList<>();
    // TODO ogarnąć co z rachunkami będziem robić
    private static final URI STAFF_PATH = URI.create("src/main/java/org/example/data/staff.csv");
    private IMenu menu;

    public Server(IMenu menu) {
        this.menu = menu;
    }
    public Server() {
    }


    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public List<IStaff> returnStaff() {
        return new ArrayList<>(staffList);
    }

    // TODO zrobić to summary (nwm co to ma robić) + ten "zakres"
    public void summary() {

    }

    // TODO zrobić closeDay bo również nie wiem jak to tak właściwie ma działać
    /*
     można to rozomieć jako podsumowanie czyli:
     - ile zrealizowanych transakcji
     - ile zarobiliśmy
     */
    public void closeDay() {

    }

    public void addRachunek(IRachunek rachunek) {
        rachunekList.add(rachunek);
    }

    public List<IRachunek> returnRachunek() {
        return new ArrayList<>(rachunekList);
    }
}
