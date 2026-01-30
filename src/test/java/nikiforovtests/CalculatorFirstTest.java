package nikiforovtests;

import allclasses.nikiforov.CalculatorFirst;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorFirstTest {

    @Test
    public void add_TwoPlusThree_ReturnsFive() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = 5;
        Assert.assertEquals(expected, calc.add(2, 3));
    }

    @Test
    public void add_NegativePlusPositive_ReturnsNegative() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = -1;
        Assert.assertEquals(expected, calc.add(-5, 4));
    }

    @Test
    public void subtract_FiveMinusThree_ReturnsTwo() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = 2;
        Assert.assertEquals(expected, calc.subtract(5, 3));
    }

    @Test
    public void subtract_NegativeMinusPositive_ReturnsNegative() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = -8;
        Assert.assertEquals(expected, calc.subtract(-5, 3));
    }

    @Test
    public void multiply_TwoByThree_ReturnsSix() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = 6;
        Assert.assertEquals(expected, calc.multiply(2, 3));
    }

    @Test
    public void multiply_NegativeByPositive_ReturnsNegative() {
        CalculatorFirst calc = new CalculatorFirst();
        int expected = -12;
        Assert.assertEquals(expected, calc.multiply(-4, 3));
    }

    @Test
    public void divide_TenByTwo_ReturnsFive() {
        CalculatorFirst calc = new CalculatorFirst();
        double expected = 5.0;
        Assert.assertEquals(expected, calc.divide(10, 2), 0.001);
    }

    @Test
    public void divide_NegativeByPositive_ReturnsNegative() {
        CalculatorFirst calc = new CalculatorFirst();
        double expected = -2.5;
        Assert.assertEquals(expected, calc.divide(-5, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divide_ByZero_ThrowsArithmeticException() {
        CalculatorFirst calc = new CalculatorFirst();
        calc.divide(10, 0);
    }
}