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
        double total = orders.entrySet().stream().mapToDouble(entry -> entry.getValue() * entry.getKey().getPrice())
                .sum();
        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * For Adding menuItem to order If already exist in order, add 1 to existing amount Else, set amount to 1 and put
     *
     * @param menuItem
     */
    public void addOrder(MenuItem menuItem) {
        if (orders.containsKey(menuItem)) {
            orders.compute(menuItem, (k, amount) -> amount + 1);
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
        orders.entrySet().stream()
                .map(entry -> String.format("%-30s", entry.getKey().toString()) + " | " + entry.getValue() + " 개")
                .forEach(System.out::println);
        System.out.println("\n[ Total ]");
        System.out.println("W " + getTotalPrice());
        System.out.printf("\n%-10s%-10s%-10s%n", "1. 주문", "2. 메뉴판", "3. 메뉴 삭제");
    }

    /**
     * For delete menuItem with the same name as name among menuItem in orders list
     * @param name
     */
    public void deleteOrders(String name) {
        boolean flag = orders.entrySet().removeIf(entry -> entry.getKey().getName().equals(name));

        if (flag) {
            System.out.println(name + " 이 성공적으로 장바구니에서 제거되었습니다.");
        } else {
            System.out.println(name + " 에 해당하는 메뉴가 존재하지 않습니다.");
        }
    }
}
