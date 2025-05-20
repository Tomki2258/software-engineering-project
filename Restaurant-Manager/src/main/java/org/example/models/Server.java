package org.example.models;

import org.example.Repositories.BillRepository;
import org.example.factories.BillFactory;
import org.example.models.rachunek.Bill;
import org.example.models.staff.IStaff;
import org.example.models.staff.Staff;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Staff> staffList = new ArrayList<>();
    // TODO ogarnąć co z rachunkami będziem robić
    private static final URI STAFF_PATH = URI.create("src/main/java/org/example/data/staff.csv");
    private IMenu menu = new Menu();
    private BillFactory billFactory = new BillFactory();
    private BillRepository billRepository = new BillRepository(
            billFactory.load()
    );
    public Server(IMenu menu) {
        this.menu = menu;
    }
    public Server() {
        // TODO Dostosowanie ładowania zamówień do Product
        //billList = billFactory.load();
    }


    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public List<IStaff> returnStaff() {
        return new ArrayList<>(staffList);
    }

    public void closeDay() {
        System.out.println("Do widzenia");

        float sum = 0;
        for(Bill bill: billRepository.getBills()){
            sum += bill.getTotalValue();
        }
        System.out.println("Dzienny utarg: "+sum+"\nZrealizowanych zamówień: "+billRepository.getBills().size());
        billRepository.save();
    }

    public void proceedBill(Bill rachunek) {
        billRepository.addBill(rachunek);
    }

    public List<Bill> returnBill() {
        return billRepository.getBills();
    }
}
