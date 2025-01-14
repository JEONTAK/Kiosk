package com.example.Lv4_5.controller;

import com.example.Lv4_5.Exception.*;
import com.example.Lv4_5.model.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private final List<Menu> menus = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * To add menu into menu
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
        //입력 값 받음
        int selectedCategory = parseInput();
        //비정상적인 값 들어옴
        if (selectedCategory == -1) {
            return true;
        }

        //입력 값이 0이면
        if (selectedCategory == 0) {
            System.out.println("프로그램을 종료합니다.");
            return false;
        }

        //입력 값이 1 ~ 해당 카테고리의 메뉴의 개수 사이라면
        try {
            //메뉴 출력
            menus.get(selectedCategory - 1).printMenu();
            int selectedMenu = parseInput();

            //입력 값 0 or 1이면 다시 메인 메뉴 출력
            if (selectedMenu == 0 || selectedMenu == -1) {
                return true;
            }

            try {
                System.out.println(
                        "선택한 메뉴: " + menus.get(selectedCategory - 1).getMenuItems().get(selectedMenu - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(new InvalidRangeException("메뉴에 적혀있는 번호만 입력 가능합니다.").getMessage());
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(new InvalidRangeException("메인 메뉴에 적혀있는 번호만 입력 가능합니다.\n").getMessage());
        }
        return true;
    }

    /**
     * Read and parse User Input Value
     * @return Integer, if -1 : otherwise
     * @throws IOException
     */
    public int parseInput() throws IOException {
        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println(new InvalidInputException("메뉴 선택은 숫자만 입력 가능합니다!").getMessage());
            return -1;
        }
    }

    /**
     *  Print Menu Categories
     */
    public void printCategory() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).toString());
        }
        System.out.println("0. 종료     | 종료");
    }
}
