package com.example.Lv6.model;

import java.util.stream.IntStream;

public enum DiscountType {
    국가유공자(10),
    군인(5),
    학생(3),
    일반(0);

    private final double discountRate;

    /**
     * Constructor
     *
     * @param discountRate
     */
    DiscountType(double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * For get current discount rate
     * @return
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     *  Print type and discount rate
     */
    public static void printType() {
        System.out.println("\n할인 정보를 입력해주세요.");
        IntStream.range(0, DiscountType.values().length)
                .mapToObj(i -> (i + 1) + ". " + String.format("%-7s", DiscountType.values()[i]) + " : " + (int) DiscountType.values()[i].getDiscountRate()  + "%")
                .forEach(System.out::println);
    }
}
