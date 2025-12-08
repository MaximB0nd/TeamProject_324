package simonenkotests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import allclasses.simonenko.Fractions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SimonenkoTest {
    @Test
    @DisplayName("Сложение: 1/2 + 1/3 = 5/6")
    public void testAdd() {
        Fractions a = new Fractions(1, 2);
        Fractions b = new Fractions(1, 3);
        Fractions result = a.add(b);
        assertEquals("5/6", result.toString());
    }
    @Test
    @DisplayName("Вычитание: 1/2 - 1/3 = 1/6")
    public void testSubtract() {
        Fractions a = new Fractions(1, 2);
        Fractions b = new Fractions(1, 3);
        Fractions result = a.subtract(b);
        assertEquals("1/6", result.toString());
    }
    @Test
    @DisplayName("Целое число как дробь: 5 = '5'")
    public void testWholeNumber() {
        Fractions frac = new Fractions(5);
        assertEquals("5", frac.toString());
    }
    @Test
    @DisplayName("Создание дроби: 1/2 = '1/2'")
    public void testConstructor() {
        Fractions frac = new Fractions(1, 2);
        assertEquals("1/2", frac.toString());
    }
    @Test
    @DisplayName("Исключение при знаменателе = 0")
    public void testConstructorWithZeroDenominator() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fractions(1, 0);
        });
    }
}


