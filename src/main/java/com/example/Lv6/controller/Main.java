package com.example.Lv6.controller;

import com.example.Lv6.model.Menu;
import com.example.Lv6.model.MenuItem;
import com.example.Lv6.model.Order;

public class Main {
    public static void main(String[] args) throws Exception {
        //메뉴 객체 생성
        //버거 카테고리
        Menu burgers = new Menu("Burgers");
        burgers.addMenuItem(new MenuItem("Shack Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Smoke Shack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Shroom Burger ", 8.9, "버섯 패티, 양상추, 토마토를 올린 베지테리안 버거"));
        burgers.addMenuItem(new MenuItem("Cheese Burger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        //음료 카테고리
        Menu drinks = new Menu("Drinks");
        drinks.addMenuItem(new MenuItem("Cola", 2.9, "누구나 좋아하는 탄산이 톡 쏘는 콜라"));
        drinks.addMenuItem(new MenuItem("Cider ", 2.9, "누구나 좋아하는 탄산이 톡 쏘는 사이다"));
        drinks.addMenuItem(new MenuItem("Iced tea", 3.7, "직접 유기농 홍차를 우려낸 아이스 티"));
        drinks.addMenuItem(new MenuItem("Lemonade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.addMenuItem(new MenuItem("Shakes", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        //디저트 카테고리
        Menu desserts = new Menu("Desserts");
        desserts.addMenuItem(new MenuItem("Shack Attack", 6.2, "초콜릿 커스터드와 세 가지 토핑이 블렌딩된 디저트"));
        desserts.addMenuItem(new MenuItem("Honey Butter Crunch ", 6.2, "바닐라 커스터드와 허니 버터 소스, 슈가 콘이 블렌딩된 디저트"));
        desserts.addMenuItem(new MenuItem("Better 2Gether", 6.2, "바닐라, 초콜릿 커스터드를 반씩 넣고 쿠키 도우와 쇼트브레드를 믹스한 디저트"));
        desserts.addMenuItem(new MenuItem("Shack-ffogato", 6.2, "바닐라 커스터드에 커피 카라멜 소스, 초콜릿 토핑이 어우러진 아포카토 디저트"));
        desserts.addMenuItem(new MenuItem("Shack in the Garden", 6.2, "바닐라 커스터드에 라즈베리 잼, 쇼트브레드, 말차가 블렌딩된 디저트"));

        //장바구니 생성
        Order order = new Order();

        //키오스크 객체 생성
        Kiosk kiosk = new Kiosk(order);
        //메뉴 카테고리 저장
        kiosk.addMenuCategory(burgers);
        kiosk.addMenuCategory(drinks);
        kiosk.addMenuCategory(desserts);

        // 1 : 그대로 실행 / 2 : 장바구니 초기화 후 실행 / 0 : 종료
        int flag = 1;
        while (flag != 0) {
            flag = kiosk.start();
            if (flag == 2) {
                kiosk.setOrder();
            }
        }
    }
}
