package org.example.models;

import org.example.models.client.Client;
import org.example.models.product.Drink;
import org.example.models.product.Food;
import org.example.models.staff.Staff;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {

    @Test
    void addProduct_drinkNoAlc_clientOfAge_checkCorrectResult() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 1, 0, 10);
        Client client = new Client(5000, 20);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertEquals(order.productList.getFirst(), drink);
    }

    @Test
    void addProduct_drinkWithAlc_clientOfAge_checkCorrectResult() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 1, 1, 10);
        Client client = new Client(5000, 20);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertEquals(order.productList.getFirst(), drink);
    }

    @Test
    void addProduct_drinkNoAlc_clientOfAge_notAvailableThrowsException() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 0, 0, 10);
        Client client = new Client(5000, 20);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertThrows(NoSuchElementException.class, () -> {
            order.productList.getFirst();
        });
    }

    @Test
    void addProduct_drinkNoAlc_clientUnderage_checkCorrectResult() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 1, 0, 10);
        Client client = new Client(5000, 10);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertEquals(order.productList.getFirst(), drink);
    }

    @Test
    void addProduct_drinkWithAlc_clientUnderage_checkThrowsException() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 1, 1, 10);
        Client client = new Client(5000, 10);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertThrows(NoSuchElementException.class, () -> {
            order.productList.getFirst();
        });
    }

    @Test
    void addProduct_drinkNoAlc_clientUnderage_notAvailableThrowsException() {
        Order order = new Order();
        Drink drink = new Drink("test", 1, 0, 0, 10);
        Client client = new Client(5000, 10);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(drink, client, staff);

        assertThrows(NoSuchElementException.class, () -> {
            order.productList.getFirst();
        });
    }

    // FOOD

    @Test
    void addProduct_food_clientOfAge_checkCorrectResult() {
        Order order = new Order();
        Food food = new Food("test", 1, 1, 20, false, 5000);
        Client client = new Client(5000, 20);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(food, client, staff);

        assertEquals(order.productList.getFirst(), food);
    }

    @Test
    void addProduct_food_clientUnderage_checkCorrectResult() {
        Order order = new Order();
        Food food = new Food("test", 1, 1, 20, false, 5000);
        Client client = new Client(5000, 10);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(food, client, staff);

        assertEquals(order.productList.getFirst(), food);
    }

    @Test
    void addProduct_food_clientOfAge_notAvailableThrowsException() {
        Order order = new Order();
        Food food = new Food("test", 1, 0, 20, false, 5000);
        Client client = new Client(5000, 20);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(food, client, staff);

        assertThrows(NoSuchElementException.class, () -> {
            order.productList.getFirst();
        });
    }

    @Test
    void addProduct_food_clientUnderage_notAvailableThrowsException() {
        Order order = new Order();
        Food food = new Food("test", 1, 0, 20, false, 5000);
        Client client = new Client(5000, 10);
        Staff staff = new Staff(0, "test_login", "test_password", "test_specialization", new Menu());

        order.addProduct(food, client, staff);

        assertThrows(NoSuchElementException.class, () -> {
            order.productList.getFirst();
        });
    }
}