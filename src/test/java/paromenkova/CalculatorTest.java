package paromenkova;

import allclasses.paromenkova.calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void add_NegativeNumbers_ReturnsCorrectSum() {
        calculator testCalculator = new calculator("Test", "Manufacturer");
        double expected = -8.0;
        Assert.assertEquals(expected, testCalculator.add(-5.0, -3.0), 0.001);
    }

    @Test
    public void multiply_PositiveNumbers_ReturnsCorrectProduct() {
        calculator testCalculator = new calculator("Test", "Manufacturer");
        double expected = 10.0;
        Assert.assertEquals(expected, testCalculator.multiply(4.0, 2.5), 0.001);
    }

    @Test
    public void factorial_Zero_ReturnsOne() {
        calculator testCalculator = new calculator("Test", "Manufacturer");
        long expected = 1;
        Assert.assertEquals(expected, testCalculator.factorial(0));
    }
}