package org.example.models;

import org.example.models.rachunek.IRachunek;
import org.example.models.staff.IStaff;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<IStaff> staffList = new ArrayList<>();
    private List<IRachunek> rachunekList = new ArrayList<>();

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
