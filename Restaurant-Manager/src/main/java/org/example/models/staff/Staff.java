package org.example.models.staff;

import org.example.models.client.Client;
import org.example.models.staff.ENSpecialization;

public class Staff implements IStaff{

    private int staffId;
    private ENSpecialization specialization;

    // !!!trzeba tu jakąś funkcjonalność z IMenu zrobić!!!
    // !!!trzeba tu jakąś funkcjonalność z Product (?) zrobić!!!
    // (jeszcze nie mam pomysłu jak)

    public Staff(int staffId, ENSpecialization specialization) {
        this.staffId = staffId;
        this.specialization = specialization;
    }

    @Override
    public int returnStaffId() {
        return staffId;
    }

    @Override
    public Boolean verifyClient(Client client) {
        // jak to tak właściwie ma działać?
        return null;
    }
}
