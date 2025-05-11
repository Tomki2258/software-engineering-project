package org.example.models.staff;

import org.example.models.IMenu;
import org.example.models.client.Client;
import org.example.models.staff.ENSpecialization;

public class Staff implements IStaff{

    private int staffId;
    private String login;
    private String password;
//    private ENSpecialization specialization;
    private String specialization;
    private IMenu menu;

    public Staff(int staffId, String login, String password, String specialization, IMenu menu) { // ENSpecialization specialization
        this.staffId = staffId;
        this.login = login;
        this.password = password;
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
