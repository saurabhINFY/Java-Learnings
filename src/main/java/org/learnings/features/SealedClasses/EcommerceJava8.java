package org.learnings.features.SealedClasses;

import java.util.Arrays;
import java.util.List;

public class EcommerceJava8 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Electronics", 3, true),
                new Order("Grocery", 6, false),
                new Order("Furniture", 1, true));

        for (Order order : orders) {
            String shippingCategory;
            switch (order.getItemType()) {
                case "Electronics":
                    shippingCategory = "Immediate Shipping";
                    break;
                case "Grocery":
                    shippingCategory = order.getQuantity() > 5 ? "Eligible for Shipping" : "Not Eligible";
                    break;
                case "Furniture":
                    shippingCategory = "Standard Shipping Only";
                    break;
                default:
                    shippingCategory = "Unknown Item Type";
            }
            if (order.isExpress()) {
                shippingCategory += " (Express +$50)";
            }
            System.out.println("Order for " + order.getItemType() + ": " + shippingCategory);
        }
    }
}

class Order {
    String itemType;
    int quantity;
    boolean isExpress;

    Order(String itemType, int quantity, boolean isExpress) {
        this.itemType = itemType;
        this.quantity = quantity;
        this.isExpress = isExpress;
    }

    public String getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpress() {
        return isExpress;
    }
}