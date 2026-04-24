package com.pluralsight;

import com.pluralsight.ui.Console;

public class StoreApp {
    public static void displayStoreHomeScreen() {
        while (true) {
            System.out.println("==========HOME SCREEN==========");
            System.out.println("    1. Display products");
            System.out.println("    2. Display Cart");
            System.out.println("    3. Exit");
            int option = Console.promptForInt("Please choose: ", 1, 3); 
            switch (option) {
                case 1:
                    displayProductScreen();
                    break;
                case 2:
                    displayCartScreen();
                    break;
                case 3:
                    System.out.println("Good bye!");
                    return;
            }
        }
    }

    public static void displayProductScreen() {
        System.out.println("==========PRODUCT SCREEN==========");
        System.out.println("    1. Search for a product");
        System.out.println("    2. Filter products");
        System.out.println("    3. Add a product to cart");
        System.out.println("    4. Go back to home screen");
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
                    System.out.println("Going back to home screen...");
                    return;
            }
        }
    }

    public static void displayCartScreen() {
        System.out.println("==========CART SCREEN==========");
        System.out.println("    1. View cart");
        System.out.println("    2. Checkout");
        System.out.println("    3. Remove product from cart");
        System.out.println("    4. Go back to home screen");
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
    public static void main(String[] args) {
        System.out.println("Welcome to T Online Store!");
        System.out.println("How can we help you today?");
        displayStoreHomeScreen();
    }
}
