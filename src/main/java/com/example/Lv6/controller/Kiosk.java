package com.example.Lv6.controller;

import com.example.Lv6.Exception.InvalidInputException;
import com.example.Lv6.Exception.InvalidRangeException;
import com.example.Lv6.model.DiscountType;
import com.example.Lv6.model.Menu;
import com.example.Lv6.model.MenuItem;
import com.example.Lv6.model.Order;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Kiosk {

    private final List<Menu> menus = new ArrayList<>();
    private final Order order;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Constructor
     *
     * @param order
     */
    public Kiosk(Order order) {
        this.order = order;
    }

    /**
     * To initialize order list
     */
    public void setOrder() {
        order.clear();
    }

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
    public int start() throws Exception {

        //메뉴판 출력
        printCategory();

        /**
         * return 1 : start 재 실행
         * return 2 : 장바구니 초기화 후 실행
         * return 0 : 종료
         */
        //입력 값 받음
        int selectedCategory = parseInput();

        //비정상적인 값 들어옴
        if (selectedCategory == -1) {
            return 1;
        }

        //입력 값이 0이면
        if (selectedCategory == 0) {
            System.out.println("프로그램을 종료합니다.");
            return 0;
        }

        //전체 인덱스 = 카테고리 수 + 장바구니에 메뉴가 담겨 있다면 2 , 없다면 0
        int totalIdx = menus.size() + (order.getSize() > 0 ? 2 : 0);

        //입력 값이 1 ~ 전체 인덱스 사이가 아니라면
        if (0 > selectedCategory || totalIdx < selectedCategory) {
            System.out.println(new InvalidRangeException("적혀있는 번호만 입력 가능합니다.\n").getMessage());
            return 1;
        }

        //입력 받은 값이 메뉴의 수 안에 있다면
        if (menus.size() >= selectedCategory) {
            //메뉴 출력
            menus.get(selectedCategory - 1).printMenu();

            //메뉴 선택 입력 값 받음
            int selectedMenu = parseInput();

            //입력 값 0 or 1이면 다시 메인 메뉴 출력
            if (selectedMenu == 0 || selectedMenu == -1) {
                return 1;
            }

            //입력 값이 1 ~ 해당 카테고리의 메뉴의 수가 아니라면
            if (0 > selectedMenu || menus.get(selectedCategory - 1).getMenuItems().size() < selectedMenu) {
                System.out.println(new InvalidRangeException("적혀있는 번호만 입력 가능합니다.\n").getMessage());
                return 1;
            }

            //메뉴 및 장바구니 추가 질문 출력
            MenuItem menuItem = menus.get(selectedCategory - 1).getMenuItems().get(selectedMenu - 1);
            System.out.println(
                    "선택한 메뉴: " + menuItem);
            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.printf("%-20s%s%n", "1. 확인", "2. 취소");

            //추가 유무 입력값 받음
            int confirmAddToOrder = parseInput();

            //1 : 추가 한다면 / 2 : 추가하지 않는다면 / 그 외 예외 처리
            if (confirmAddToOrder == 1) {
                order.addOrder(menuItem);
                System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
            } else if (confirmAddToOrder != 2) {
                System.out.println(new InvalidRangeException("적혀있는 번호만 입력 가능합니다.\n").getMessage());
            }
            return 1;
        }


        //주문 선택을 했을 경우
        if ((totalIdx - 1) == selectedCategory) {
            //주문 내역 출력
            order.printOrders();
            //주문 확정 유무 입력 값 받음
            int confirmOrder = parseInput();

            //예외 처리
            if (confirmOrder < 1 || confirmOrder > 3) {
                System.out.println(new InvalidRangeException("적혀있는 번호만 입력 가능합니다.\n").getMessage());
                return 1;
            }

            //1 : 할인 선택 / 2: 메인 메뉴판으로 이동 / 그 외 예외 처리
            if (confirmOrder == 1) {
                //할인 정보 출력
                DiscountType.printType();

                //할인 선택 입력 값 받음
                int selectType = parseInput();

                //범위 안에 있지 않다면 메인 메뉴 화면 이동
                if (selectType < 1 || selectType > DiscountType.values().length) {
                    System.out.println(new InvalidRangeException("적혀있는 번호만 입력 가능합니다.\n").getMessage());
                    return 1;
                }

                double totalPrice = order.getTotalPrice();
                totalPrice = totalPrice * (1 - DiscountType.values()[selectType - 1].getDiscountRate() / 100);

                //주문 결과 출력
                System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + " 입니다.");
                return 2;
            } else if (confirmOrder == 3) {
                //삭제 프로세스 수행
                System.out.println("삭제할 메뉴를 적어주세요");
                String deleteName = br.readLine();
                order.deleteOrders(deleteName);
            }
            return 1;
        }

        System.out.println("주문이 취소되었습니다.");
        return 2;
    }

    /**
     * Read and parse User Input Value
     *
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
     * Print Menu Categories and Order Menu if order size > 0
     */
    public void printCategory() {
        System.out.println("\n[ MAIN MENU ]");
        IntStream.range(0, menus.size()).mapToObj(i -> (i + 1) + ". " + menus.get(i).toString())
                .forEach(System.out::println);
        System.out.println("0. 종료     | 종료");

        if (order.getSize() != 0) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println((menus.size() + 1) + ". " + String.format("%-20s", "Orders") + "| 장바구니를 확인 후 주문합니다.");
            System.out.println((menus.size() + 2) + ". " + String.format("%-20s", "Cancel") + "| 진행중인 주문을 취소합니다.");
        }
    }
}
