package org.example.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.factories.ClientFactory;
import org.example.factories.StaffFactory;
import org.example.models.Server;
import org.example.models.staff.Staff;
import org.example.models.client.Client;


public class AuthService { private List<Client> clientList = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    public AuthService(ClientFactory clientFactory,StaffFactory staffFactory) {
        clientList = clientFactory.load();
        staffList = staffFactory.loadStaff();
    }

    public Optional<Client> loginAsClient(String login, String password) {
        for (Client client : clientList) {
            if(client.getLogin().equals(login) && client.getPassword().equals(password)) {
                return Optional.of(client);
            }
        }

        return Optional.empty();
    }

    public Optional<Staff> loginAsStaff(String login, String password) {
        for (Staff staff : staffList) {
            if (staff.getLogin().equals(login) && staff.getPassword().equals(password)) {
                return Optional.of(staff);
            }
        }
        return Optional.empty();
    }
}
