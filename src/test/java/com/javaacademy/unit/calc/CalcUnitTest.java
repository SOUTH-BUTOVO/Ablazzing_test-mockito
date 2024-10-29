package com.javaacademy.unit.calc;

import com.javaacademy.calc.Calc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Тестирование калькулятора:")
public class CalcUnitTest {

    @Test
    @DisplayName("Успешное сложение")
    public void add() {
        Calc calc = new Calc();
        int res = calc.add(10, 10);
//        if (res != 20) {
//            throw new RuntimeException("Ожидалось 20, а результат: " + res);
//        }
        Assertions.assertEquals(20, res);
    }

    @Test
    @DisplayName("Успешное деление")
    public void divideSuccess() {
        Calc calc = new Calc();
        int res = calc.divide(4, 2);
//        if (res != 2) {
//            throw new RuntimeException("Ожидалось 2, а результат: " + res);
//        }
        Assertions.assertEquals(2, res);
    }

    @Test
    @DisplayName("Деление на ноль, выкидывающее исключение")
    public void divideFailure() {
        Calc calc = new Calc();
        Assertions.assertThrows(ArithmeticException.class, () -> calc.divide(4, 0));
//        try {
//            calc.divide(4, 0);
//            throw new RuntimeException("Не выкинулось исключение");
//        } catch (ArithmeticException e) {
//            System.out.println("Всё ок!");
//        }
    }

    @Test
    @DisplayName("Успешное умножение")
    public void multiply() {
        Calc calc = new Calc();
        int res = calc.multiply(3, 3);
//        if (res != 9) {
//            throw new RuntimeException("Ожидалось 9, а результат: " + res);
//        }
        Assertions.assertEquals(9, res);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calc_test.csv", delimiter = ';', numLinesToSkip = 1)
    public void multiplyFromCsvSuccess(Integer num1, Integer num2, Integer expected) {
        System.out.printf("num1: %s, num2: %s, expected: %s\n", num1, num2, expected);
        Calc calc = new Calc();
        int res = calc.multiply(num1, num2);

        Assertions.assertEquals(expected, res);
    }
}
