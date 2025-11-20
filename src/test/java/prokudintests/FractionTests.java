package prokudintests;

import allclasses.prokudin.Fraction;
import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.AsynchronousServerSocketChannel;

public class FractionTests {
    @Test
    public void create_fractions_when_fractions_valid() {
        try {
            Fraction fraction_a = new Fraction(2, 3);
            Fraction fraction_b = new Fraction(3, 5);
            Assert.assertTrue(true);
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void create_fractions_when_fractions_invalid() {
        Fraction fraction_a = new Fraction(-2, 3);
        Fraction fraction_b = new Fraction(3, 0);
        // Throwable actualException = Assert.assertThrows(Exception.class, () -> {});
        // Assert.assertEquals("Error: Denominator is zero",  actualException.getMessage());
    }

    @Test
    public void get_fractions_sum_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Sum(fraction_a, fraction_b);
        Fraction actual = new Fraction(19, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_sum_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Sum(fraction_a, fraction_b);
        Fraction actual = new Fraction(5, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_sub_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Sub(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_sub_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Sub(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_multi_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(4,5);
        Fraction fact = Fraction.Multi(fraction_a, fraction_b);
        Fraction actual = new Fraction(8, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_multi_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Multi(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }


    @Test
    public void get_fractions_div_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Div(fraction_a, fraction_b);
        Fraction actual = new Fraction(10, 9);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @Test
    public void get_fractions_div_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Div(fraction_a, fraction_b);
        Fraction actual = new Fraction(3, 2);
        Assert.assertEquals(0, fact.compareTo(actual));
    }
}
