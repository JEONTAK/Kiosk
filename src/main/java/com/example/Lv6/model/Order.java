package com.example.Lv6.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order {

    private final Map<MenuItem, Integer> orders = new HashMap<>();


    /**
     * Run on request for oder initialization
     */
    public void clear() {
        orders.clear();
    }

    /**
     * Get order list size
     *
     * @return size of order list
     */
    public int getSize() {
        return orders.size();
    }

    /**
     * Method of total menu prices in orders
     *
     * @return total price
     */
    public double getTotalPrice() {
        double total = 0;
        for (Entry<MenuItem, Integer> entry : orders.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * For Adding menuItem to order If already exist in order, add 1 to existing amount Else, set amount to 1 and put
     *
     * @param menuItem
     */
    public void addOrder(MenuItem menuItem) {
        if (orders.containsKey(menuItem)) {
            int amount = orders.get(menuItem);
            orders.put(menuItem, amount + 1);
        } else {
            orders.put(menuItem, 1);
        }
    }

    /**
     * Print list of menu item in orders
     */
    public void printOrders() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ Orders ]");
        for (Entry<MenuItem, Integer> entry : orders.entrySet()) {
            System.out.println(String.format("%-30s", entry.getKey().toString()) + " | " + entry.getValue() + " 개");
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + getTotalPrice());
        System.out.printf("\n%-20s%s%n", "1. 주문", "2. 메뉴판");
    }
}
