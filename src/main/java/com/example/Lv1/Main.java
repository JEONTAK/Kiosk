package com.example.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //메뉴 저장
        String[] menus = {
                "ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"};

        while (true) {
            //메뉴판 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menus.length; i++) {
                System.out.println((i + 1) + ". " + menus[i]);
            }
            System.out.println("0. 종료     | 종료");

            /**
             * 메뉴 선택 수행
             * 0 : 종료
             * 1 ~ N : 해당 메뉴 출력
             * N 초과 : 예외 처리
             */
            System.out.println("\n[ 메뉴를 선택해 주세요. ]");
            int selectMenu = Integer.parseInt(br.readLine());
            if (selectMenu == 0) {
                System.out.println("[ 프로그램을 종료합니다. ]");
                break;
            } else if (selectMenu <= menus.length) {
                System.out.println("[ 선택한 메뉴는 ]");
                System.out.println("[ " + menus[selectMenu - 1] + " ]");
                System.out.println("[ 입니다. ]\n");
            } else {
                System.out.println("[ 메뉴에 적혀있는 번호만 입력 가능합니다! ]\n");
            }
        }
    }
}
