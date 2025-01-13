package com.example.Lv2.model;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuInfo;

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
     * Method
     * <p>
     * Print current menuItem
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%-15s", menuName) + "| W " + menuPrice + " | " + menuInfo;
    }
}
