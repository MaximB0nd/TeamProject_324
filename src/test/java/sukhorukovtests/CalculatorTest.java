package sukhorukovtests;

import allclasses.sukhorukov.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator("Test", true);
        assertEquals("Сложение работает неправильно", 5.0, calc.add(2.0, 3.0), 0.0);
        assertEquals("Сложение с отрицательными числами работает неправильно", 0.0, calc.add(-2.0, 2.0), 0.0);
    }

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator("Test", true);
        assertEquals("Умножение работает неправильно", 6.0, calc.multiply(2.0, 3.0), 0.0);
        assertEquals("Умножение на ноль работает неправильно", 0.0, calc.multiply(5.0, 0.0), 0.0);
    }

    @Test
    public void testCanCalculatePercentages() {
        Calculator scientificCalc = new Calculator("Scientific", true);
        Calculator basicCalc = new Calculator("Basic", false);

        assertTrue("Научный калькулятор должен уметь вычислять проценты", scientificCalc.canCalculatePercentages());
        assertFalse("Обычный калькулятор не должен уметь вычислять проценты", basicCalc.canCalculatePercentages());
    }

    @Test
    public void testGetCalculatorInfo() {
        Calculator calc = new Calculator("Casio FX-991", true);
        String expected = "Калькулятор: Casio FX-991, тип: научный";
        assertEquals("Информация о калькуляторе не совпадает", expected, calc.getCalculatorInfo());
    }
}
