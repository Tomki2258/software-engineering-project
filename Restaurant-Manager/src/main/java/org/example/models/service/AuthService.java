package org.example.models.service;

import java.util.List;
import java.util.Optional;
import org.example.factories.ClientFactory;
import org.example.models.Server;
import org.example.models.staff.Staff;
import org.example.models.client.Client;


public class AuthService {
    private final ClientFactory clientFactory;
    private final Server server;

    public AuthService(ClientFactory clientFactory, Server server) {
        this.clientFactory = clientFactory;
        this.server = server;
    }

    public Optional<Client> loginAsClient(String login, String password) {
        List<Client> clientList = clientFactory.load();
        for (Client client : clientList) {
            if(client.getLogin().equals(login) && client.getPassword().equals(password)) {
                return Optional.of(client);
            }
        }

        return Optional.empty();
    }

    public Optional<Staff> loginAsStaff(String login, String password) {
        List<Staff> staffList = server.loadStaff();

        for (Staff staff : staffList) {
            if (staff.getLogin().equals(login) && staff.getPassword().equals(password)) {
                return Optional.of(staff);
            }
        }
        return Optional.empty();
    }
}
