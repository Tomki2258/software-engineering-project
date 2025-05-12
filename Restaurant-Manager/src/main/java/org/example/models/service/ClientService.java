package org.example.models.service;

import org.example.models.Menu;
import org.example.models.Order;
import org.example.models.client.Client;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class ClientService {
    private final Client client;
    private final Staff staff;
    private Order order = new Order();
    private Menu menu = new Menu();
    public ClientService(Client client,Staff staff){
        this.client = client;
        this.staff = staff;

        App();
    }
    private void App(){
        System.out.println("Witamy w restauracji\nWybierz opcje\n1:Pokaż produkty\n2:Dodaj produkt");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                menu.printMenuProducts();
                break;
            case "2":
                menu.printMenuProducts();
                // TODO dodawanie do order
                // TODO odejmowanie ilości danego przedniotu z listy / sprawdzanie czy można go wgl dodać
                break;
            case "3":
                // TODO opłacenie zamówienia i elo
                break;
            default:
                break;
        }
    }
}
