package simonenkotests;

import org.junit.Assert;
import org.junit.Test;
import allclasses.simonenko.Fractions;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class test_simonenko {
    @Test
    public void testAdd() {
        Fractions a = new Fractions(1, 2);
        Fractions b = new Fractions(1, 3);
        Fractions result = a.add(b);
        assertEquals("5/6", result.toString());
    }
    @Test
    public void testSubtract() {
        Fractions a = new Fractions(1, 2);
        Fractions b = new Fractions(1, 3);
        Fractions result = a.subtract(b);
        assertEquals("1/6", result.toString());
    }
    @Test
    public void testWholeNumber() {
        Fractions frac = new Fractions(5);
        assertEquals("5", frac.toString());
    }
    @Test
    public void testConstructor() {
        Fractions frac = new Fractions(1, 2);
        assertEquals("1/2", frac.toString());
    }
    @Test
    public void testConstructorWithZeroDenominator() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fractions(1, 0);
        });
    }
}


