package com.example.Lv4.controller;

import com.example.Lv4.Exception.*;
import com.example.Lv4.model.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private final List<Menu> menus = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
    public boolean start() {
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
        } catch (InvalidInputException | InvalidRangeException | IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean selectCategory() throws IOException, InvalidInputException, InvalidRangeException {
        int selectedCategory = parseInput();

        if (selectedCategory == 0) {
            System.out.println("프로그램을 종료합니다.");
            return false;
        }

        if (selectedCategory < 1 || selectedCategory > menus.size()) {
            throw new InvalidRangeException("메인 메뉴에 적혀있는 번호만 입력 가능합니다.\n");
        }

        selectMenu(selectedCategory);

        return true;
    }

    public void selectMenu(int selectedCategory) throws IOException, InvalidInputException, InvalidRangeException {
        menus.get(selectedCategory - 1).printMenu();
        int selectedMenu = parseInput();
        if (selectedMenu == 0) {
            return;
        }
        if (selectedMenu < 1 || selectedMenu > menus.get(selectedCategory).getMenuItems().size()) {
            throw new InvalidRangeException("메뉴에 적혀있는 번호만 입력 가능합니다.\n");
        }
        System.out.println(
                "선택한 메뉴: " + menus.get(selectedCategory - 1).getMenuItems().get(selectedMenu - 1)
                        + "\n");
    }

    public int parseInput() throws InvalidInputException, IOException {
        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("메뉴 선택은 숫자만 입력 가능합니다.\n");
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
