package org.example;

import org.example.Repositories.ClientRepository;
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
    private final ClientRepository clientRepository = new ClientRepository(
            clientFactory.load()
    );
    private final AuthService authService = new AuthService(
            clientRepository.getClientList(), staffFactory);

    public App() {
        app();
        server.closeDay();
        clientRepository.save();
    }

    private void app() {
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        boolean loginLoop = true;

        while(loginLoop) {
            System.out.println("""
                Wybierz typ użytkownika
                1:Klient
                2:Obsluga
                
                9:Wyjście
                """);
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Podaj login");
                    login = scanner.nextLine();
                    System.out.println("Podaj haslo");
                    password = scanner.nextLine();
                    Optional<Client> resultClient = authService.loginAsClient(login, password);
                    if (resultClient.isPresent()) {
                        ClientService clientService = new ClientService(resultClient.get()
                                , staffFactory.loadStaff().getFirst(),
                                server);
                    }
                    else {
                        System.out.println("Logowanie nie powiodło się\n");
                    }
                    break;
                case "2":
                    System.out.println("Podaj login");
                    login = scanner.nextLine();
                    System.out.println("Podaj haslo");
                    password = scanner.nextLine();
                    Optional<Staff> resultStaff = authService.loginAsStaff(login, password);
                    if (resultStaff.isPresent()) {
                        StaffService staffService = new StaffService(resultStaff.get());
                    }
                    else {
                        System.out.println("Logowanie nie powiodło się\n");
                    }
                    break;
                case "9":
                    loginLoop = false;
                    break;

                default:
                    System.out.println("wybrano zły typ");
                    break;
            }
        }
    }
}
