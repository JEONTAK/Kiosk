package com.example.Lv6.model;

public enum ClientType {
    국가유공자(0.9),
    군인(0.95),
    학생(0.97),
    일반인(1.0);

    private final double discountRate;

    ClientType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
