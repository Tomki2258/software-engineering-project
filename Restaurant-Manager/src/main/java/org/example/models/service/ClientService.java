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
                1:Pokaż menu
                2:Pokaż koszyk
                3:Dodaj produkt do koszyka
                4:Usuń produkt z koszyka
                5:Zapłać
                
                9:Anuluj zamówienie i wyjdź
                """);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            // TODO problem jest że wyświetlają się ilości danych produktów jakby globalnie
            //  - jak dodamy dwa te same produkty do koszyka, ich ilość będzie się zmieniała
            //  i ogólnie wskazywała tą która jest pokazywana w menu - imo łatwo temu by było
            //  zaradzić jeżeli pokazywalibyśmy klientowi mniej informacji
            case "1" -> {
                menu.printMenuProducts();
            }
            case "2" -> {
                order.printProducts();
            }
            case "3" -> {
                menu.printMenuProducts();
                System.out.println("Podaj numer produktu do dodania");
                input = scanner.nextLine();
                int inputInt = Integer.parseInt(input) - 1;
                if (order.addProduct(menu.getProductList().get(inputInt), client, staff)) {
                    menu.getProductList().get(inputInt).reduceAvailableCount();
                }
            }
            case "4" -> {
                order.printProducts();
                System.out.println("Podaj numer produktu do usunięcia");
                input = scanner.nextLine();
                int inputInt = Integer.parseInt(input) - 1;
                if (order.removeProduct(inputInt)) System.out.println("Produkt usunięty poprawnie");
                else System.out.println("Wystąpił problem z usunięciem produktu - zły numer podany");
            }
            case "5" -> {
                try {
                    finalizeBill();
                } catch (NoMoneyException e) {
                    throw new RuntimeException(e);
                }
            }
            case "9" -> {
                for (int i = 0; i < order.orderLength(); i++) {
                    order.removeProduct(i);
                }
                working = false;
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
