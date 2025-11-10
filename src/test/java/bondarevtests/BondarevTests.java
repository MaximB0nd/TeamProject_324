package bondarevtests;

import allclasses.bondarev.Mark;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BondarevTests {
    @Test
    public void defaultConstructor_ShouldSetZero() {
        Mark mark = new Mark();
        assertEquals(0, mark.get());
    }

    @Test
    public void constructorWithValue_ShouldSetValueInValidRange() {
        assertEquals(3, new Mark(3).get());
        assertEquals(5, new Mark(7).get());   // Проверка ограничения сверху
        assertEquals(0, new Mark(-2).get());  // Проверка ограничения снизу
    }

    @Test
    public void plus_ShouldIncreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.plus();
        assertEquals(3, mark.get());

        mark = new Mark(5);
        mark.plus();  // Не должен превысить 5
        assertEquals(5, mark.get());
    }

    @Test
    public void minus_ShouldDecreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.minus();
        assertEquals(1, mark.get());

        mark = new Mark(0);
        mark.minus();  // Не должен стать отрицательным
        assertEquals(0, mark.get());
    }

    @Test
    public void plusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(2);
        mark.plus(2);
        assertEquals(4, mark.get());

        mark.plus(10);  // Превышение максимума
        assertEquals(5, mark.get());

        mark = new Mark(2);
        mark.plus(-1);  // Отрицательное значение
        assertEquals(1, mark.get());
    }

    @Test
    public void minusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(4);
        mark.minus(2);
        assertEquals(2, mark.get());

        mark.minus(10);  // Падение ниже минимума
        assertEquals(0, mark.get());

        mark = new Mark(3);
        mark.minus(-2);  // Отрицательное значение (фактически сложение)
        assertEquals(5, mark.get());
    }

    @Test
    public void set_ShouldAdjustToValidRange() {
        Mark mark = new Mark();
        mark.set(4);
        assertEquals(4, mark.get());

        mark.set(10);  // Установка значения выше максимума
        assertEquals(5, mark.get());

        mark.set(-5);  // Установка значения ниже минимума
        assertEquals(0, mark.get());
    }
}