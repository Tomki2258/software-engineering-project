package org.example.Repositories;

import org.example.models.client.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.factories.ClientFactory.CLIENT_PATH;

public class ClientRepository {

    private List<Client> clientList = new ArrayList<>();
    public ClientRepository(List<Client> clientList){
        this.clientList = clientList;
    }
    public List<Client> getClientList(){
        return clientList;
    }
    public void save(){
        File file = new File(String.valueOf(CLIENT_PATH));
        StringBuilder result = new StringBuilder();

        for (Client client : clientList) {
            result.append(client.toCSV()).append("\n");
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(result.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
