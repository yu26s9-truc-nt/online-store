package com.pluralsight.ui;

public class Menu {
    public static String[] homeScreenMenu = {
        "Display products",
        "Display Cart",
        "Exit"
    };

    public static String[] productScreenMenu = {
        "Search for a product",
        "Add a product to cart",
        "Go back to home screen"
    };

    public static String[] searchCriteriaMenu = {
        "Search by SKU",
        "Search by name",
        "Search by price",
        "Search by department",
        "Go back to product screen"
    };

    public static String[] cartScreenMenu = {
        "View cart",
        "Checkout",
        "Remove product from cart",
        "Go back to home screen"
    };

    public static void displayMenu(String menuTitle, String[] options) {
        System.out.println(menuTitle);
        for (int i = 0; i < options.length; i++) {
            System.out.println("    " + (i + 1) + ". " + options[i]);
        }
    }
}
