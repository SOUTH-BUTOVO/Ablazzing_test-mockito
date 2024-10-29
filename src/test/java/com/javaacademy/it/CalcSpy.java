package com.javaacademy.it;

import com.javaacademy.calc.Calc;

/**
 * Реализует паттерн Proxy
 */
public class CalcSpy {
    private Calc calc;

    public CalcSpy(Calc calc) {
        this.calc = calc;
    }

    public int add(int num1, int num2) {
        return calc.add(num1, num2);
    }

    public int divide(int num1, int num2) {
        return calc.divide(num1, num2);
    }

    public int multiply(int num1, int num2) {
        if (num1 == 2 && num2 == 2) {
            return 4;
        }
            return calc.multiply(num1, num2);
    }
}
