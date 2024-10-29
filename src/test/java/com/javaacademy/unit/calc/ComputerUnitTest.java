package com.javaacademy.unit.calc;

import com.javaacademy.calc.Calc;
import com.javaacademy.calc.Computer;
import com.javaacademy.calc.SquareType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ComputerUnitTest {

    @Test
    public void computeSquareMetersSuccess() {
        Calc mock = Mockito.mock(Calc.class);
        Mockito.when(mock.multiply(2, 2)).thenReturn(4);
        Computer computer = new Computer(mock);
        double res = computer.computeSquare(2, 2, SquareType.METERS);
        Assertions.assertEquals(4, res);
    }

    @Test
    public void computeSquareMetersSuccess2() {
        Calc calcSpy = Mockito.spy(Calc.class);
        Mockito.when(calcSpy.multiply(2, 2)).thenReturn(4);
        Computer computer = new Computer(calcSpy);
        double res = computer.computeSquare(2, 2, SquareType.METERS);
        Assertions.assertEquals(4, res);

        double res2 = computer.computeSquare(3, 3, SquareType.METERS);
        Assertions.assertEquals(9, res2);

    }
}
