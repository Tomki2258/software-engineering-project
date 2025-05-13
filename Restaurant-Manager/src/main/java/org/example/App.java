package org.example;

import org.example.factories.ClientFactory;
import org.example.factories.StaffFactory;
import org.example.models.Server;
import org.example.models.client.Client;
import org.example.models.service.AuthService;
import org.example.models.service.ClientService;
import org.example.models.service.StaffService;
import org.example.models.staff.Staff;

import java.util.Optional;
import java.util.Scanner;

public class App {
    private final ClientFactory clientFactory = new ClientFactory();
    private final StaffFactory staffFactory = new StaffFactory();
    private final Server server = new Server();

    private final AuthService authService = new AuthService(clientFactory, staffFactory);

    public App() {
        app();
        server.closeDay();
    }

    private void app() {
        System.out.println("Wybierz typ użytkownika\n1:Klient\n2:Obsluga");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj haslo");
        String password = scanner.nextLine();
        switch (input) {
            case "1":
                Optional<Client> resultClient = authService.loginAsClient(login, password);
                if (resultClient.isPresent()) {
                    ClientService clientService = new ClientService(resultClient.get()
                            , staffFactory.loadStaff().getFirst());
                }
                break;
            case "2":
                Optional<Staff> resultStaff = authService.loginAsStaff(login, password);
                if (resultStaff.isPresent()) {
                    StaffService staffService = new StaffService(resultStaff.get());
                }
                break;
            default:
                System.out.println("wybrano zły typ");
                break;
        }
    }
}
