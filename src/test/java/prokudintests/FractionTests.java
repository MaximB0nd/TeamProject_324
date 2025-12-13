package prokudintests;

import allclasses.prokudin.Fraction;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Description;
import io.qameta.allure.Description;

import java.nio.channels.AsynchronousServerSocketChannel;

public class FractionTests {
    @DisplayName("Создание дробей, когда их существование возможно")
    @Description("Тест проверяет успешное создание объектов дробей с корректными числителем и знаменателем")
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
    

    @DisplayName("Создание дробей, когда их существование невозможно")
    @Description("Тест проверяет создание дробей с некорректными значениями: отрицательный числитель и нулевой знаменатель")
    @Test
    public void create_fractions_when_fractions_invalid() {
        Fraction fraction_a = new Fraction(-2, 3);
        Fraction fraction_b = new Fraction(3, 0);
        // Throwable actualException = Assert.assertThrows(Exception.class, () -> {});
        // Assert.assertEquals("Error: Denominator is zero",  actualException.getMessage());
    }

    @DisplayName("Сложение дробей с корректными значениями")
    @Description("Тест проверяет операцию сложения двух дробей без сокращения результата")
    @Test
    public void get_fractions_sum_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Sum(fraction_a, fraction_b);
        Fraction actual = new Fraction(19, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Сложение дробей с сокращением результата")
    @Description("Тест проверяет операцию сложения двух дробей с последующим сокращением результата")
    @Test
    public void get_fractions_sum_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Sum(fraction_a, fraction_b);
        Fraction actual = new Fraction(5, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Вычитание дробей с корректными значениями")
    @Description("Тест проверяет операцию вычитания двух дробей без сокращения результата")
    @Test
    public void get_fractions_sub_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Sub(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Вычитание дробей с сокращением результата")
    @Description("Тест проверяет операцию вычитания двух дробей с последующим сокращением результата")
    @Test
    public void get_fractions_sub_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Sub(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Умножение дробей с корректными значениями")
    @Description("Тест проверяет операцию умножения двух дробей без сокращения результата")
    @Test
    public void get_fractions_multi_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(4,5);
        Fraction fact = Fraction.Multi(fraction_a, fraction_b);
        Fraction actual = new Fraction(8, 15);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Умножение дробей с сокращением результата")
    @Description("Тест проверяет операцию умножения двух дробей с последующим сокращением результата")
    @Test
    public void get_fractions_multi_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Multi(fraction_a, fraction_b);
        Fraction actual = new Fraction(1, 6);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Деление дробей с корректными значениями")
    @Description("Тест проверяет операцию деления двух дробей без сокращения результата")
    @Test
    public void get_fractions_div_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,3);
        Fraction fraction_b = new Fraction(3,5);
        Fraction fact = Fraction.Div(fraction_a, fraction_b);
        Fraction actual = new Fraction(10, 9);
        Assert.assertEquals(0, fact.compareTo(actual));
    }

    @DisplayName("Деление дробей с сокращением результата")
    @Description("Тест проверяет операцию деления двух дробей с последующим сокращением результата")
    @Test
    public void get_fractions_div_with_reduction_when_fractions_valid() {
        Fraction fraction_a = new Fraction(2,4);
        Fraction fraction_b = new Fraction(2,6);
        Fraction fact = Fraction.Div(fraction_a, fraction_b);
        Fraction actual = new Fraction(3, 2);
        Assert.assertEquals(0, fact.compareTo(actual));
    }
}