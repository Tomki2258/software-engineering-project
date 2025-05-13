package org.example.models.service;

import org.example.models.Menu;
import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.Product;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class StaffService {
    private final Menu menu = new Menu();

    public StaffService(Staff staff){ App(); }

    private void App(){
        System.out.println("Menu dla obsługi\n1:Wypisz aktualne produkti\n2:Dodaj produkt");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "1":
                menu.printProducts();
                break;
            case "2":
                System.out.println("Który typ produktu chcesz dodać?");
                String typeInput = scanner.nextLine();
                System.out.println("Podaj dane produktu do dodania (spacje zastąp znakiem ';')");
                switch (typeInput){
                    case "NAPOJ" -> {
                        String prod = scanner.nextLine();
                        Product p = getProductDrink(prod);
                        menu.addProduct(p);
                    }
                    case "JEDZENIE" -> {
                        String prod = scanner.nextLine();
                        Product p = getProductFood(prod);
                        menu.addProduct(p);
                    }
                    default -> {
                        System.out.println("Bład: niepoprawne  wejście");
                        System.exit(0);
                    }
                }
                break;
        }
    }

    private static Product getProductDrink(String line) {
        String[] splitted = line.split(";");
        return new Drink(
                splitted[0],                        // Name
                Float.parseFloat(splitted[1]),      // price
                Integer.parseInt(splitted[2]),      // availableCount
                Double.parseDouble(splitted[3]),    // alcoholAmount
                Integer.parseInt(splitted[4])       // volume
        );
    }

    private static Product getProductFood(String prod2) {
        String[] splitted = prod2.split(";");
        return new Food(
                splitted[0],                       // name
                Float.parseFloat(splitted[1]),     // price
                Integer.parseInt(splitted[2]),     // availableCount
                Integer.parseInt(splitted[3]),     // weight
                Boolean.parseBoolean(splitted[4]), // isVege
                Integer.parseInt(splitted[5])      // calories
        );
    }
}
