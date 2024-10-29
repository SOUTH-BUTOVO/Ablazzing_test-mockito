package com.javaacademy.it;

import com.javaacademy.calc.Calc;
import com.javaacademy.calc.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static com.javaacademy.calc.SquareType.*;

@DisplayName("Тестирование компьютера")
public class ComputerIT {

    @BeforeEach
    public void clear() {
        Computer.historyCompute.clear();
    }

    @Test
    public void calcNotNull() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        Assertions.assertNotNull(computer.getCalc());
    }

    @Test
    @DisplayName("Успешное вычисление квадратных метров")
    public void computeSquareMetersSuccess() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        double res = computer.computeSquare(4, 4, METERS);
        Assertions.assertEquals(16, res);
        Assertions.assertEquals(1, Computer.historyCompute.size());
    }

    @Test
    @DisplayName("Успешное вычисление квадратных футов")
    public void computeSquareFootsSuccess() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        double res = computer.computeSquare(4, 4, FOOTS);
        Assertions.assertEquals(16 * 10.764, res);
        Assertions.assertEquals(1, Computer.historyCompute.size());
    }

    @Test
    @DisplayName("Успешное выбрасывание ошибки")
    public void computerSquareExceptionSuccess() {
        Calc calc = new Calc();
        Computer computer = new Computer(calc);
        Assertions.assertThrows(InvalidParameterException.class,
                () -> computer.computeSquare(4, 4, YARDS));
        Assertions.assertEquals(0, Computer.historyCompute.size());
    }
}
