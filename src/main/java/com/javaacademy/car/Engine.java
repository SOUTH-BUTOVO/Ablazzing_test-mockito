package com.javaacademy.car;

public class Engine {

    // Spy
    public void start(int fuel) {
        if (fuel == 1000) {
            System.out.println("Двигатель завёлся");
            return;
        }

        if (fuel < 10_000) {
            throw new RuntimeException("Мало бензина (косяк джуна)");
        }
        System.out.println("Двигатель завёлся");
    }

    // Mock
//    public void start(int fuel) {}
}
