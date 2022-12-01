package junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    private final Calculator _calculator = new Calculator();

    @Test
    public void testAddPositiveNumbers_Case1(){
        var actualResult= _calculator.add(7, 4);
        Assertions.assertEquals(11, actualResult);
    }
    @Test
    public void testAddNegativeNumberLarger_Case2(){
        var actualResult= _calculator.add(-7, 4);

        Assertions.assertEquals(-3, actualResult);
    }
    @Test
    public void testAddNegativeNumberSmaller_Case3(){
        var actualResult = _calculator.add(7, -4);
        Assertions.assertEquals(3, actualResult);
    }
    @Test
    public void testAddTwoNegativeNumbers_Case4(){
        var actualResult = _calculator.add(-7, -4);
        Assertions.assertEquals(-11, actualResult);
    }

}
