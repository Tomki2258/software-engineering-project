package org.example;

import org.example.factories.ClientFactory;
import org.example.models.Server;
import org.example.models.service.AuthService;

import java.util.Scanner;

public class App {
    private final ClientFactory clientFactory = new ClientFactory();
    private final Server server = new Server();

    private AuthService authService = new AuthService(clientFactory,server);
    public App(){
        app();
    }
    private void app(){
        System.out.println("Wybierz typ użytkownika\n1:Klient\n2:Obsluga");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj haslo");
        String password = scanner.nextLine();
        switch (input){
            case "1":
                authService.loginAsClient(login,password);
                break;
            case "2":
                authService.loginAsStaff(login,password);
                break;
            default:
                System.out.println("wybrano zły typ");
                break;
        }
    }
}
