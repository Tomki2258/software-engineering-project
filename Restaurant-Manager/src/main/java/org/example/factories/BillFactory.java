package org.example.factories;

import com.google.gson.reflect.TypeToken;
import com.umcsuser.carrent.utils.JsonFileStorage;
import org.example.models.rachunek.Bill;

import java.util.List;

public class BillFactory {
    final String PATH = "src/main/java/org/example/data/bills.json";
    private com.umcsuser.carrent.utils.JsonFileStorage<Bill> storage = new JsonFileStorage<Bill>(PATH, new TypeToken<List<Bill>>(){}.getType());

    public List<Bill> load(){
        return null;
    }
}
