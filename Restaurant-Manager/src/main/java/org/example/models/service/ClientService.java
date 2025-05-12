package org.example.models.service;

import org.example.models.Menu;
import org.example.models.client.Client;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class ClientService {
    private final Client client;
    private final Staff staff;
    private Menu menu = new Menu();
    public ClientService(Client client,Staff staff){
        this.client = client;
        this.staff = staff;

        App();
    }
    private void App(){
        System.out.println("Witamy w restauracji\nWybierz opcje\n1:Pokaż produkty");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                menu.printProducts();
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                break;
        }
    }
}
