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
     *
     * Print current menuItem
     */
    public void printMenuItem() {
        System.out.println(String.format("%-5s", menuName) + "| W " + menuPrice + " | " + menuInfo);
    }
}
