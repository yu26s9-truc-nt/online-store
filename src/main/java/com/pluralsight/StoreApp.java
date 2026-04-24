package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.ui.*;

public class StoreApp {
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
        Menu.displayMenu("==========PRODUCT SCREEN==========", Menu.productScreenMenu);
        while (true) {
            int option = Console.promptForInt("Please choose: ", 1, 4);
            switch (option) {
                case 1:
                    Menu.displayMenu("Which category do you want to search by:", Menu.searchCriteriaMenu);
                    option = Console.promptForInt("Please choose: ", 1, 4);
                    switch (option) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
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

    public static void searchProduct() {

    }
    public static void main(String[] args) {
        System.out.println("Welcome to T Online Store!");
        System.out.println("How can we help you today?");
        displayStoreHomeScreen();
        System.out.println("Good bye!");
    }
}
