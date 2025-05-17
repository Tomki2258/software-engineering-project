package org.example.factories;

import org.example.models.client.Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientFactory {
    private static final URI CLIENT_PATH = URI.create("src/main/java/org/example/data/client.csv");
    
    public List<Client> load(){
        List<Client> loaded = new ArrayList<>();
        File file = new File(String.valueOf(CLIENT_PATH));
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                loaded.add(build(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loaded;
    }
    private Client build(String line){
        String splitted[] = line.split(";");
        return new Client(
                splitted[0],
                Integer.parseInt(splitted[1]),
                Float.parseFloat(splitted[2]),
                splitted[3],
                splitted[4]
        );
    }
    public void save(List<Client> clientList){
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
