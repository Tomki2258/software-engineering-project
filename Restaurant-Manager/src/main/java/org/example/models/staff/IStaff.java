package org.example.models.staff;

import org.example.models.client.Client;

public interface IStaff {
    public int returnStaffId();
    public Boolean verifyClient(Client client);
}
