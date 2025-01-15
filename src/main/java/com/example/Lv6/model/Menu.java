package com.example.Lv6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        System.out.println("[ " + category + " MENU ]");
        IntStream.range(0, menuItems.size()).mapToObj(i -> (i + 1) + ". " + menuItems.get(i).toString())
                .forEach(System.out::println);
        System.out.println("0. 뒤로가기");
    }

    /**
     * Returns the string category of this menu
     *
     * @return the category name
     */
    @Override
    public String toString() {
        return category;
    }
}
