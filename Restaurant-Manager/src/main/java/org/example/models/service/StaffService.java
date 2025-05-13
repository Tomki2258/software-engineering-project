package org.example.models.service;

import org.example.models.Menu;
import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.Product;
import org.example.models.staff.Staff;

import java.lang.classfile.constantpool.PoolEntry;
import java.util.Scanner;
import java.util.UUID;

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
                System.out.println("Który typ produktu chcesz dodać?");
                String typeInput = scanner.nextLine();
                System.out.println("Podaj dane produktu do dodania (spacje zastąp znakiem ';')");
                switch (typeInput){
                    case "NAPOJ":
                        String prod = scanner.nextLine();
                        String[] splitted = line.split(";");
                        Product p = new Drink(
                                splitted[0],                        // Name
                                Float.parseFloat(splitted[1]),      // price
                                Integer.parseInt(splitted[2]),      // availableCount
                                Double.parseDouble(splitted[3]),    // alcoholAmount
                                Integer.parseInt(splitted[4])       // volume
                        );
                        break;
                    case "JEDZENIE":
                        String prod2 = scanner.nextLine();
                        String[] splitted2 = prod2.split(";");
                        Product p2 = new Food(
                                splitted2[0],                       // name
                                Float.parseFloat(splitted2[1]),     // price
                                Integer.parseInt(splitted2[2]),     // availableCount
                                Integer.parseInt(splitted2[3]),     // weight
                                Boolean.parseBoolean(splitted2[4]), // isVege
                                Integer.parseInt(splitted2[5])      // calories
                        );
                        break;
                }
                break;
        }
    }
}
