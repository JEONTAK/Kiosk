package com.example.Lv3.controller;

import com.example.Lv3.Exception.InvalidInputException;
import com.example.Lv3.model.MenuItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private final List<MenuItem> menuItems = new ArrayList<>();

    /**
     * To add menuItem into menuItems
     *
     * @param menuItem
     */
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    /**
     * Controls the workflow of the application.
     *
     * @return {@code true} to repeat the process, {@code false} to end it
     * @throws IOException
     */
    public boolean start() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //메뉴판 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).toString());
        }
        System.out.println("0. 종료     | 종료");

        /**
         * 메뉴 선택 수행
         * 0 : 종료
         * 1 ~ N : 해당 메뉴 출력
         * N 초과 : 예외 처리
         */
        System.out.println("\n[ 메뉴를 선택해 주세요. ]");
        try {
            int selectMenu = Integer.parseInt(br.readLine());
            if (selectMenu == 0) {
                System.out.println("[ 프로그램을 종료합니다. ]");
                return false;
            } else if (selectMenu <= menuItems.size()) {
                System.out.println("[ 선택한 메뉴는 ]");
                System.out.println("[ " + menuItems.get(selectMenu - 1).toString() + " ]");
                System.out.println("[ 입니다. ]\n");
            } else {
                System.out.println("[ 메뉴에 적혀있는 번호만 입력 가능합니다! ]\n");
            }
        } catch (NumberFormatException e) {
            System.out.println(new InvalidInputException("메뉴 선택은 숫자만 입력 가능합니다!").getMessage());
        }
        return true;
    }
}
