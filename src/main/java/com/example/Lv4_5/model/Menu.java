package com.example.Lv4_5.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String category;

    /**
     * Constructor
     *
     * @param category
     */
    public Menu(String category) {
        this.category = category;
    }

    /**
     * Return list of menu items in this menu
     *
     * @return list of MenuItem Objects
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Add new menu item to the menu
     *
     * @param menuItem
     */
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * Print menus
     */
    public void printMenu() {
        //메뉴판 출력
        System.out.println("[ " + category + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 뒤로가기");
    }

    /**
     * Returns the string category of this menu
     * @return the category name
     */
    @Override
    public String toString() {
        return category;
    }
}
