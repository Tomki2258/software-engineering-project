package org.example.Repositories;

import com.google.gson.reflect.TypeToken;
import org.example.models.rachunek.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    final String PATH = "src/main/java/org/example/data/bills.json";
    private com.umcsuser.carrent.utils.JsonFileStorage<Bill> storage = new com.umcsuser.carrent.utils.JsonFileStorage<Bill>(PATH, new TypeToken<List<Bill>>() {
    }.getType());
    private List<Bill> billList = new ArrayList<>();

    public BillRepository(List<Bill> billList) {
        this.billList = new ArrayList<>();
    }

    public void addBill(Bill bill) {
        billList.add(bill);
    }
    public void save(){
        storage.save(billList);
    }
    public List<Bill> getBills(){
        return billList;
    }

}
