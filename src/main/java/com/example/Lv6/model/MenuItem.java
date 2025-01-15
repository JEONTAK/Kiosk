package com.example.Lv6.model;

public class MenuItem {
    private final String menuName;
    private final double menuPrice;
    private final String menuInfo;

    /**
     * Constructor
     *
     * @param menuName
     * @param menuPrice
     * @param menuInfo
     */
    public MenuItem(String menuName, double menuPrice, String menuInfo) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }

    /**
     * Print current menuItem's name, price and description
     *
     * @return formatted string using menuItem
     */
    @Override
    public String toString() {
        return String.format("%-20s", menuName) + "| W " + menuPrice + " | " + menuInfo;
    }

    /**
     * Get menu price
     *
     * @return menuPrice
     */
    public double getPrice() {
        return menuPrice;
    }

    /**
     * Get menu name
     *
     * @return menuName
     */
    public String getName() {
        return menuName;
    }
}
