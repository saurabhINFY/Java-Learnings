package org.learnings.features.SealedClasses;

import java.util.Arrays;
import java.util.List;

public class EcommerceJava21 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Electronics", 3, true),
                new Order("Grocery", 6, false),
                new Order("Furniture", 1, true));

        orders.forEach((order) -> {
            String shippingCategory = switch (order.getItemType()) {
                case "Electronics" -> "Immediate Shipping";
                case "Grocery" -> order.getQuantity() > 5 ? "Eligible for Shipping" : "Not Eligible";
                case "Furniture" -> "Standard Shipping Only";
                default -> "Unknown Item Type";
            };
            if (order.isExpress()) {
                shippingCategory += " (Express +$50)";
            }
            System.out.println("Order for " + order.getItemType() + ": " + shippingCategory);
        });
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