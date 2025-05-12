package org.example.models.service;

import org.example.models.Menu;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class StaffService {
    private Menu menu = new Menu();
    private final Staff staff;
    public StaffService(Staff staff){
        this.staff = staff;

        App();
    }
    private void App(){
        System.out.println("Menu dla obsługi\n1:Wypisz aktualne produkti\n2:Dodaj produkt");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                menu.printProducts();
                break;
            case "2":
                String line = scanner.nextLine();
                System.out.println("Który typ produktu chcesz dodać ?");
                String typeInput = scanner.nextLine();
                switch (typeInput){
                    case "NAPOJ":
                        break;
                    case "JEDZENIE":
                        break;
                }
                String[] splitted = line.split(";");
                break;
        }
    }
}
