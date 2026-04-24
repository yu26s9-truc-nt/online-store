package com.pluralsight.models;

import java.io.*;
import java.util.*;

public class Inventory {
    private ArrayList<Product> products;
    private HashMap<String, Product> skus;
    private String filePath;

    public Inventory(String filePath) {
        this.products = new ArrayList<>();
        this.skus = new HashMap<>();
        this.filePath = filePath;
        this.importProducts();
    }

    public void importProducts() {
        try {
            FileReader fr = new FileReader(this.filePath);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] productDetails = line.split("\\|");
                String sku = productDetails[0];
                String name = productDetails[1];
                double price = Double.parseDouble(productDetails[2]);
                String department = productDetails[3];
                Product product = new Product(sku, name, price, department);
                this.addProduct(product);
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error importing products: " + e.getMessage());
        }
    }

    public void addProduct(Product product) {
        if (this.skus.containsKey(product.getSKU())) {
            System.out.println("Product with SKU " + product.getSKU() + " already exists. Skipping.");
            return;
        }
        this.products.add(product);
        this.skus.put(product.getSKU(), product);
        System.out.println("Product added successfully");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductBySKU(String sku) {
        return this.skus.get(sku);
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public ArrayList<Product> getProductsWithinPriceRange(double minPrice, double maxPrice) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public ArrayList<Product> getProductsByDepartment(String department) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDepartment().toLowerCase().equalsIgnoreCase(department)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
