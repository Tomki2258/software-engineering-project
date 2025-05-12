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
    private List<IStaff> staffList = new ArrayList<>();
    private List<IRachunek> rachunekList = new ArrayList<>();
    // TODO ogarnąć co z rachunkami będziem robić
    private static final URI STAFF_PATH = URI.create("src/main/java/org/example/data/staff.csv");
    private IMenu menu;

    public Server(IMenu menu) {
        this.menu = menu;
        staffList = loadStaff();
    }

    private IStaff buildFromLine(List<String> splitted){
        IStaff staff = null;
        staff = new Staff(
                Integer.parseInt(splitted.get(1)),  // id
                splitted.get(2),                    // login
                splitted.get(3),                    // password
                splitted.get(4),                    // specialization (done in string this time)
                menu
        );

        return staff;
    }
    public List<IStaff> loadStaff() {
        List<IStaff> loaded = new ArrayList<>();
        File file = new File(String.valueOf(STAFF_PATH));
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                List<String> splitted = List.of(line.split(";"));
                loaded.add(buildFromLine(splitted));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loaded;

    }

    public void addStaff(IStaff staff) {
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
