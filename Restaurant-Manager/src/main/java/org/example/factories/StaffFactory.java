package org.example.factories;

import org.example.models.IMenu;
import org.example.models.staff.IStaff;
import org.example.models.staff.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffFactory {
    private static final URI STAFF_PATH = URI.create("src/main/java/org/example/data/staff.csv");
    private IMenu menu;
    private IStaff buildFromLine(List<String> splitted){
        IStaff staff = null;
        staff = new Staff(
                Integer.parseInt(splitted.get(0)),  // id
                splitted.get(1),                    // login
                splitted.get(2),                    // password
                splitted.get(3),                    // specialization (done in string this time)
                menu
        );

        return staff;
    }
    public List<Staff> loadStaff() {
        List<Staff> loaded = new ArrayList<>();
        File file = new File(String.valueOf(STAFF_PATH));
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                List<String> splitted = List.of(line.split(";"));
                loaded.add((Staff) buildFromLine(splitted));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loaded;
    }
}
