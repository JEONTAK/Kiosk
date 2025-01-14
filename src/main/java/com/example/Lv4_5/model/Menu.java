package com.example.Lv4.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String category;

    public Menu(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void printMenu() {
        //메뉴판 출력
        System.out.println("[ " + category + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 뒤로가기");
    }

    @Override
    public String toString() {
        return category;
    }
}
