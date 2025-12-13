package bondarevtests;

import allclasses.bondarev.Mark;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BondarevTests {

    private static final float DELTA = 0.0001f;

    @Test
    @DisplayName("Проверка конструктора по умолчанию")
    @Description("Тест проверяет, что конструктор без параметров устанавливает оценку в 0")
    @TmsLink("TestCase-Mark-001")
    @Issue("BUG-Mark-001")
    public void defaultConstructor_ShouldSetZero() {
        Mark mark = new Mark();
        assertEquals(0, mark.get(), DELTA);
    }

    @Test
    @DisplayName("Проверка конструктора с параметром")
    @Description("Тест проверяет установку значения через конструктор с валидацией диапазона")
    @TmsLink("TestCase-Mark-002")
    @Issue("BUG-Mark-002")
    public void constructorWithValue_ShouldSetValueInValidRange() {
        assertEquals(3, new Mark(3).get(), DELTA);

        assertEquals(5, new Mark(7).get(), DELTA);

        assertEquals(0, new Mark(-2).get(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода plus() без параметра")
    @Description("Тест проверяет увеличение оценки на 1 в пределах допустимого диапазона")
    @TmsLink("TestCase-Mark-003")
    @Issue("BUG-Mark-003")
    public void plus_ShouldIncreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.plus();
        assertEquals(3, mark.get(), DELTA);

        Mark maxMark = new Mark(5);
        maxMark.plus();
        assertEquals(5, maxMark.get(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода minus() без параметра")
    @Description("Тест проверяет уменьшение оценки на 1 в пределах допустимого диапазона")
    @TmsLink("TestCase-Mark-004")
    @Issue("BUG-Mark-004")
    public void minus_ShouldDecreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.minus();
        assertEquals(1, mark.get(), DELTA);

        Mark minMark = new Mark(0);
        minMark.minus();
        assertEquals(0, minMark.get(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода plus() с параметром")
    @Description("Тест проверяет увеличение оценки на заданное значение с валидацией")
    @TmsLink("TestCase-Mark-005")
    @Issue("BUG-Mark-005")
    public void plusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(2);
        mark.plus(2);
        assertEquals(4, mark.get(), DELTA);

        mark.plus(10);
        assertEquals(5, mark.get(), DELTA);

        Mark anotherMark = new Mark(2);
        anotherMark.plus(-1);
        assertEquals(1, anotherMark.get(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода minus() с параметром")
    @Description("Тест проверяет уменьшение оценки на заданное значение с валидацией")
    @TmsLink("TestCase-Mark-006")
    @Issue("BUG-Mark-006")
    public void minusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(4);
        mark.minus(2);
        assertEquals(2, mark.get(), DELTA);

        mark.minus(10);
        assertEquals(0, mark.get(), DELTA);

        Mark anotherMark = new Mark(3);
        anotherMark.minus(-2);
        assertEquals(5, anotherMark.get(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода set()")
    @Description("Тест проверяет установку значения через метод set() с корректировкой в допустимый диапазон")
    @TmsLink("TestCase-Mark-007")
    @Issue("BUG-Mark-007")
    public void set_ShouldAdjustToValidRange() {
        Mark mark = new Mark();
        mark.set(4);
        assertEquals(4, mark.get(), DELTA);

        mark.set(10);
        assertEquals(5, mark.get(), DELTA);

        mark.set(-5);
        assertEquals(0, mark.get(), DELTA);
    }
}
