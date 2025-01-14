package com.example.Lv4.controller;

import com.example.Lv4.Exception.*;
import com.example.Lv4.model.Menu;
import com.example.Lv4.model.MenuItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private final List<Menu> menus = new ArrayList<>();

    /**
     * To add menuItem into menuItems
     *
     * @param menu
     */
    public void addMenuCategory(Menu menu) {
        menus.add(menu);
    }

    /**
     * Controls the workflow of the application.
     *
     * @return {@code true} to repeat the process, {@code false} to end it
     * @throws IOException
     */
    public boolean start() throws Exception {
        //메뉴판 출력
        printCategory();

        /**
         * 메뉴 선택 수행
         * 0 : 종료
         * 1 ~ N : 해당 메뉴 출력
         * N 초과 or 숫자가 아닐 경우 : 예외 처리
         */
        try {
            return selectCategory();
        } catch (NumberFormatException e) {
            System.out.println(new InvalidInputException("메뉴 선택은 숫자만 입력 가능합니다.").getMessage());
        }
        return true;
    }

    public boolean selectCategory() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int selectedCategory = Integer.parseInt(br.readLine());

        if (selectedCategory == 0) {
            System.out.println("프로그램을 종료합니다.");
            return false;
        } else {
            try {
                selectMenu(selectedCategory);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(new InvalidRangeException("메인 메뉴에 적혀있는 번호만 입력 가능합니다.\n").getMessage());
            }
        }
        return true;
    }

    public void selectMenu(int selectedCategory) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        menus.get(selectedCategory - 1).printMenu();
        int selectedMenu = Integer.parseInt(br.readLine());
        if (selectedMenu != 0) {
            try {
                System.out.println(
                        "선택한 메뉴: " + menus.get(selectedCategory - 1).getMenuItems().get(selectedMenu - 1)
                                + "\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(new InvalidRangeException("메뉴에 적혀있는 번호만 입력 가능합니다.\n").getMessage());
            }
        }
    }

    public void printCategory() {
        //메뉴판 출력
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).toString());
        }
        System.out.println("0. 종료     | 종료");
    }
}
