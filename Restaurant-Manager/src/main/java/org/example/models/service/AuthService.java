package org.example.models.service;

import org.example.ClientFactory;
import org.example.models.Server;
import org.example.models.client.Client;
import org.example.models.staff.IStaff;
import org.example.models.staff.Staff;

import java.util.List;
import java.util.Optional;


public class AuthService {
    ClientFactory clientFactory;
    Server server;


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
}
