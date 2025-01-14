package com.example.Lv4.controller;

import com.example.Lv4.Exception.InvalidInputException;
import com.example.Lv4.model.Menu;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class temp {

    private final List<Menu> menus = new ArrayList<>();


    public boolean start() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //메뉴판 출력
        printCategory();

        /**
         * 메뉴 선택 수행
         * 0 : 종료
         * 1 ~ N : 해당 메뉴 출력
         * N 초과 or 숫자가 아닐 경우 : 예외 처리
         */
        try {
            int selectedCategory = Integer.parseInt(br.readLine());

            if (selectedCategory == 0) {
                System.out.println("프로그램을 종료합니다.");
                return false;
            } else if (selectedCategory <= menus.size()) {
                menus.get(selectedCategory - 1).printMenu();
                int selectedMenu = Integer.parseInt(br.readLine());
                if (selectedMenu == 0) {
                    return true;
                } else if (selectedMenu <= menus.get(selectedCategory - 1).getMenuItems().size()) {
                    System.out.println(
                            "선택한 메뉴: " + menus.get(selectedCategory - 1).getMenuItems().get(selectedMenu - 1) + "\n");
                } else {
                    System.out.println("메뉴에 적혀있는 번호만 입력 가능합니다.\n");
                }
            } else {
                System.out.println("메인 메뉴에 적혀있는 번호만 입력 가능합니다.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println(new InvalidInputException("메뉴 선택은 숫자만 입력 가능합니다.").getMessage());
        }
        return true;
    }

    private void printCategory() {

    }
}
