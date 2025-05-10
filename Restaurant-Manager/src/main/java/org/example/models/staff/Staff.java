package org.example.models.staff;

import org.example.models.IMenu;
import org.example.models.client.Client;
import org.example.models.staff.ENSpecialization;

public class Staff implements IStaff{

    private int staffId;
    private ENSpecialization specialization;
    private IMenu menu;

    public Staff(int staffId, ENSpecialization specialization, IMenu menu) {
        this.staffId = staffId;
        this.specialization = specialization;
        this.menu = menu;
    }

    @Override
    public int returnStaffId() {
        return staffId;
    }

    @Override
    public Boolean verifyClient(Client client) {
        return client.zwrocWiek() > 18;
    }
}
