package com.example.Lv3.controller;

import com.example.Lv3.Exception.InvalidInputException;
import com.example.Lv3.model.MenuItem;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        //키오스크 객체 생성
        Kiosk kiosk = new Kiosk();
        //메뉴 저장
        kiosk.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.addMenuItem(new MenuItem("SmokeShack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        kiosk.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        kiosk.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        boolean flag = true;
        while(flag){
             flag = kiosk.start();
        }
    }
}
