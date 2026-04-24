package com.pluralsight.models;

import java.util.*;

public class Cart {
    private HashMap<String, Integer> skus;

    public Cart() {
        this.skus = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (this.skus.containsKey(product.getSKU())) {
            this.skus.put(product.getSKU(), this.skus.get(product.getSKU()) + quantity);
        } else {
            this.skus.put(product.getSKU(), quantity);
        }
    }

    public void removeProduct(String sku, int quantity) {
        if (!this.skus.containsKey(sku)) {
            System.out.println("Product with SKU " + sku + " is not in the cart.");
            return;
        }

        int currentQuantity = this.skus.get(sku);
        if (quantity >= currentQuantity) {
            this.skus.remove(sku);
        } else {
            this.skus.put(sku, currentQuantity - quantity);
        }
    }
}
