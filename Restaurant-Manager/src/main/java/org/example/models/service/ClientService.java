package org.example.models.service;

import org.example.NoMoneyException;
import org.example.models.Menu;
import org.example.models.Order;
import org.example.models.Server;
import org.example.models.client.Client;
import org.example.models.rachunek.Bill;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class ClientService {
    private final Client client;
    private final Staff staff;
    private Order order = new Order();
    private Menu menu = new Menu();
    private boolean working = true;
    private final Server server;

    public ClientService(Client client, Staff staff, Server server) {
        this.client = client;
        this.staff = staff;
        this.server = server;
        System.out.println("Witamy w restauracji");
        while (working) {
            App();
        }
        menu.save();
    }

    private void App() {
        System.out.println("""
                Wybierz opcje
                1:Pokaż produkty
                2:Dodaj produkt do koszyka
                3:Zapłać
                """);
        //TODO - dodać możliwość wyjścia wcześniejszego? (wiązałoby się to z przywróceniem tego co było w koszyku)
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                menu.printMenuProducts();
            }
            case "2" -> {
                menu.printMenuProducts();
                System.out.println("Podaj index produktu do dodania");
                input = scanner.nextLine();
                int inputInt = Integer.parseInt(input) - 1;
                if (order.addProduct(menu.getProductList().get(inputInt), client, staff)) {
                    menu.getProductList().get(inputInt).reduceAvailableCount();
                }
            }
            case "3" -> {
                try {
                    finalizeBill();
                } catch (NoMoneyException e) {
                    throw new RuntimeException(e);
                }
            }

            default -> {
                System.out.println("Niepoprawna opcja");
            }
        }
    }

    private void finalizeBill() throws NoMoneyException {
        Bill bill = new Bill(order);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chcesz dać napiwek (TAK/NIE)?");
        String input = scanner.nextLine();
        if (input.equals("TAK")) {
            System.out.println("Podaj kwote napiwku");
            float tip = scanner.nextFloat();
            bill.setTip(tip);
        }
        bill.close();
        if(client.reduceMoneyAmount(bill.getTotalValue())){
            bill.describe();
            working = false;
            server.proceedBill(bill);
        }else{
            throw new NoMoneyException(client);
        }
    }
}
