package org.example.models.service;

import org.example.models.Menu;
import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.product.Product;
import org.example.models.staff.Staff;

import java.util.Scanner;

public class StaffService {
    private final Menu menu = new Menu();
    private boolean working = true;

    public StaffService(Staff staff){
        while (working) {
            App();
        }
    }

    private void App() {
        System.out.println("""
                Menu dla obsługi
                1:Wypisz aktualne produkty
                2:Dodaj produkt
                3:Usuń produkt
                4:Uzupełnij produkt
                9:Wyjdź
                """
        );

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> {
                menu.printProducts();
            }
            case "2" -> {
                System.out.println("Który typ produktu chcesz dodać?\nNAPOJ / JEDZENIE");
                String typeInput = scanner.nextLine();

                System.out.println(
                        "Podaj dane produktu do dodania (spacje zastąp znakiem ';')"
                );
//                while (true) {
                    switch (typeInput) {
                        case "NAPOJ" -> {
                            System.out.println("Nazwa;Cena;Ilość;ZawartośćAlkoholu;Objętość");
                            String prod = scanner.nextLine();
                            Product p = getProductDrink(prod);
                            if (p == null) {
                                System.out.println("Błąd przy dodawaniu produktu");
                                break;
                            }
                            menu.addProduct(p);
                        }
                        case "JEDZENIE" -> {
                            System.out.println("Nazwa;Cena;Ilość;Waga;CzyVege(true/false);Kalorie");
                            String prod = scanner.nextLine();
                            Product p = getProductFood(prod);
                            if (p == null) {
                                System.out.println("Błąd przy dodawaniu produktu");
                                break;
                            }
                            menu.addProduct(p);
                        }
//                        case "exit" -> {
//                            System.out.println("Do widzenia");
//                            System.exit(0);
//                        }
                        default -> {
                            System.out.println("Błąd: niepoprawne wejście");
                        }
                    }
//                }
            }
            case "3" -> {
                System.out.println("Który produkt chcesz usunąć? (podaj jego index)");
                int indexInput = scanner.nextInt();
                if (menu.removeProduct(indexInput)) System.out.println("Operacja powiodła się");    // remove product zawsze zwraca true
                else System.out.println("Operacja nie powiodła się");
            }
            case "4" -> {
                System.out.println("Podaj id produktu do uzupełnienia");
                menu.printProducts();
                String pID = scanner.nextLine();
                System.out.println("Podaj ilość sztuk do uzupełnienia");
                String amount = scanner.nextLine();
                menu.modyfiProductAmount(
                        Integer.parseInt(pID), Integer.parseInt(amount));
            }
            case "9" -> {
                working = false;
            }

            default -> {
                System.out.println("Niepoprawna opcja");
            }
        }
    }

    private static Product getProductDrink(String line) {
        //sprawdzanie poprawności wpisywanego tekstu
        if (!line.contains(";")){
            return null;
        }

        String[] strLine = line.split(";");
        if (strLine.length == 5){
            String name = strLine[0];
            float price = Float.parseFloat(strLine[1]);
            int availableCount = Integer.parseInt(strLine[2]);
            double alcoholAmount = Double.parseDouble(strLine[3]);
            int volume = Integer.parseInt(strLine[4]);

            if(price == 0 || volume == 0){
                return null;
            }

            return new Drink(
                    name,                // Name
                    price,               // price
                    availableCount,      // availableCount
                    alcoholAmount,       // alcoholAmount
                    volume               // volume
            );
        }
        return null;
    }

    private static Product getProductFood(String line) {
        //sprawdzanie poprawności wpisywanego tekstu
        if (!line.contains(";")) {
            return null;
        }

        String[] strLine = line.split(";");

        if (strLine.length == 6) {
            String name = strLine[0];
            float price = Float.parseFloat(strLine[1]);
            int availableCount = Integer.parseInt(strLine[2]);
            int weight = Integer.parseInt(strLine[3]);
            Boolean isVege = Boolean.parseBoolean(strLine[4]);
            int calories = Integer.parseInt(strLine[5]);

            if(price == 0 || weight == 0 || calories == 0){
                return null;
            }

            return new Food(
                    name,               // name
                    price,              // price
                    availableCount,     // availableCount
                    weight,             // weight
                    isVege,             // isVege
                    calories            // calories
            );
        }
        return null;
    }
}
