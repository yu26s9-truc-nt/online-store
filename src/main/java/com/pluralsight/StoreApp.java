package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;

import com.pluralsight.models.*;
import com.pluralsight.ui.*;

public class StoreApp {
    private static Inventory inventory = new Inventory("data/products.csv");
    private static Cart cart = new Cart();

    public static void displayProducts(ArrayList<Product> products) {
        products.sort(Comparator.comparing(Product::getName));
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void displayStoreHomeScreen() {
        while (true) {
            Menu.displayMenu("==========HOME SCREEN==========", Menu.homeScreenMenu);
            int option = Console.promptForInt("Please choose: ", 1, 3); 
            switch (option) {
                case 1:
                    displayProductScreen();
                    break;
                case 2:
                    displayCartScreen();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void displayProductScreen() {
        while (true) {
            Menu.displayMenu("==========PRODUCT SCREEN==========", Menu.productScreenMenu);
            int option = Console.promptForInt("Please choose: ", 1, 4);
            switch (option) {
                case 1:
                    displaySearchProductScreen();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Going back to home screen...");
                    return;
            }
        }
    }

    public static void displayCartScreen() {
        Menu.displayMenu("Cart Screen", Menu.cartScreenMenu);
        int option = Console.promptForInt("Please choose: ", 1, 4);
        while (true) {
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void displaySearchProductScreen() {
        Menu.displayMenu("Which category do you want to search by:", Menu.searchCriteriaMenu);
        while (true) {
            int option = Console.promptForInt("Please choose the category: ", 1, 5);
            switch (option) {
                case 1:
                    searchProductBySKU();
                    break;
                case 2:
                    searchProductsByName();
                    break;
                case 3:
                    searchProductsByPrice();
                    break;
                case 4:
                    searchProductsByDepartment();
                    break;
                case 5:
                    System.out.println("Going back to product screen...");
                    return;
            }
        }
    }

    public static void searchProductBySKU() {
        String sku = Console.promptForString("Please enter the SKU of the product: ");
        Product product = inventory.getProductBySKU(sku);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("No product found with SKU " + sku);
        }
    }

    public static void searchProductsByName() {
        String name = Console.promptForString("Please enter the name of the product: ");
        ArrayList<Product> products = inventory.getProductsByName(name);
        if (products.size() > 0) {
            displayProducts(products);
        } else {
            System.out.println("No products found with name " + name);
        }
    }

    public static void searchProductsByPrice() {
        double minPrice = Console.promptForDouble("Please enter the minimum price: ");
        double maxPrice = Console.promptForDouble("Please enter the maximum price: ");
        ArrayList<Product> products = inventory.getProductsWithinPriceRange(minPrice, maxPrice);
        if (products.size() > 0) {
            displayProducts(products);
        } else {
            System.out.println("No products found within the price range " + minPrice + " - " + maxPrice);
        }
    }

    public static void searchProductsByDepartment() {
        String department = Console.promptForString("Please enter the department of the product: ");
        ArrayList<Product> products = inventory.getProductsByDepartment(department);
        if (products.size() > 0) {
            displayProducts(products);
        } else {
            System.out.println("No products found in department " + department);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to T Online Store!");
        System.out.println("How can we help you today?");
        displayStoreHomeScreen();
        System.out.println("Good bye!");
    }
}
