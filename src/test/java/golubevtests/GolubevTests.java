package golubevtests;

import allclasses.golubev.Piano;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GolubevTests {

    private static final float DELTA = 0.0001f;

    @Test
    @DisplayName("Проверка конструктора по умолчанию")
    @Description("Тест проверяет, что конструктор без параметров устанавливает громкость в 5.0")
    @TmsLink("TestCase-Piano-001")
    @Issue("BUG-Piano-001")
    public void defaultConstructor_ShouldSetDefaultVolume() {
        Piano piano = new Piano();
        assertEquals(5.0f, piano.getVolume(), DELTA);
    }

    @Test
    @DisplayName("Проверка конструктора с параметром")
    @Description("Тест проверяет установку начальной громкости с автоматической нормализацией в диапазоне [0, 10]")
    @TmsLink("TestCase-Piano-002")
    @Issue("BUG-Piano-002")
    public void constructorWithVolume_ShouldNormalizeValue() {
        assertEquals(3.0f, new Piano(3.0f).getVolume(), DELTA);

        assertEquals(10.0f, new Piano(15.0f).getVolume(), DELTA); // превышение

        assertEquals(0.0f, new Piano(-2.0f).getVolume(), DELTA); // меньше нуля
    }

    @Test
    @DisplayName("Проверка метода increaseVolume() без параметра")
    @Description("Тест проверяет увеличение громкости на 1.0 в пределах допустимого диапазона")
    @TmsLink("TestCase-Piano-003")
    @Issue("BUG-Piano-003")
    public void increaseVolume_ShouldWorkWithinBounds() {
        Piano piano = new Piano(4.0f);
        piano.increaseVolume();
        assertEquals(5.0f, piano.getVolume(), DELTA);

        Piano maxPiano = new Piano(10.0f);
        maxPiano.increaseVolume();
        assertEquals(10.0f, maxPiano.getVolume(), DELTA); // не должна превысить максимум
    }

    @Test
    @DisplayName("Проверка метода decreaseVolume() без параметра")
    @Description("Тест проверяет уменьшение громкости на 1.0 в пределах допустимого диапазона")
    @TmsLink("TestCase-Piano-004")
    @Issue("BUG-Piano-004")
    public void decreaseVolume_ShouldWorkWithinBounds() {
        Piano piano = new Piano(4.0f);
        piano.decreaseVolume();
        assertEquals(3.0f, piano.getVolume(), DELTA);

        Piano minPiano = new Piano(0.0f);
        minPiano.decreaseVolume();
        assertEquals(0.0f, minPiano.getVolume(), DELTA); // не должна уйти ниже нуля
    }

    @Test
    @DisplayName("Проверка метода increaseVolume() с параметром")
    @Description("Тест проверяет увеличение громкости на заданное значение с нормализацией")
    @TmsLink("TestCase-Piano-005")
    @Issue("BUG-Piano-005")
    public void increaseVolumeWithValue_ShouldHandleAllCases() {
        Piano piano = new Piano(2.0f);
        piano.increaseVolume(3.0f);
        assertEquals(5.0f, piano.getVolume(), DELTA);

        piano.increaseVolume(10.0f);
        assertEquals(10.0f, piano.getVolume(), DELTA); // ограничение сверху

        Piano negativeInc = new Piano(3.0f);
        negativeInc.increaseVolume(-1.0f); // эквивалентно уменьшению
        assertEquals(2.0f, negativeInc.getVolume(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода decreaseVolume() с параметром")
    @Description("Тест проверяет уменьшение громкости на заданное значение с нормализацией")
    @TmsLink("TestCase-Piano-006")
    @Issue("BUG-Piano-006")
    public void decreaseVolumeWithValue_ShouldHandleAllCases() {
        Piano piano = new Piano(5.0f);
        piano.decreaseVolume(2.0f);
        assertEquals(3.0f, piano.getVolume(), DELTA);

        piano.decreaseVolume(10.0f);
        assertEquals(0.0f, piano.getVolume(), DELTA); // ограничение снизу

        Piano negativeDec = new Piano(5.0f);
        negativeDec.decreaseVolume(-2.0f); // эквивалентно увеличению
        assertEquals(7.0f, negativeDec.getVolume(), DELTA);
    }

    @Test
    @DisplayName("Проверка метода setVolume()")
    @Description("Тест проверяет установку громкости напрямую с автоматической нормализацией")
    @TmsLink("TestCase-Piano-007")
    @Issue("BUG-Piano-007")
    public void setVolume_ShouldNormalizeInput() {
        Piano piano = new Piano();
        piano.setVolume(7.0f);
        assertEquals(7.0f, piano.getVolume(), DELTA);

        piano.setVolume(20.0f);
        assertEquals(10.0f, piano.getVolume(), DELTA);

        piano.setVolume(-5.0f);
        assertEquals(0.0f, piano.getVolume(), DELTA);
    }
}