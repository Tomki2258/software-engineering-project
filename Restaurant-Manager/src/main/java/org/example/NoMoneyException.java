package org.example;

import org.example.models.client.Client;

public class NoMoneyException extends Exception {
    public NoMoneyException(Client client) {
        super(String.format("%s have not enough money! Bill canceled POLICE INCOMING!", client.getLogin()));
    }
}