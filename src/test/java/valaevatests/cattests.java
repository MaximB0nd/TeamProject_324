package valaevatests;

import allclasses.valaeva.Cat;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.junit.Test;
import static org.junit.Assert.*;

public class cattests {

    @Test
    @DisplayName("Проверка создания кота с корректными параметрами")
    @Description("Тест проверяет корректность создания объекта Cat и его геттеров")
    @TmsLink("TC-001")
    @Issue("BUG-001")
    public void testCatCreation() {
        Cat cat = createCat("Барсик", 3, 4.5, "рыжий");
        verifyCatAttributes(cat, "Барсик", 3, 4.5, "рыжий");
    }

    @Step("Создание кота с параметрами: имя={name}, возраст={age}, вес={weight}, цвет={color}")
    public Cat createCat(String name, int age, double weight, String color) {
        return new Cat(name, age, weight, color);
    }

    @Step("Проверка атрибутов кота")
    public void verifyCatAttributes(Cat cat, String name, int age, double weight, String color) {
        assertEquals(name, cat.getName());
        assertEquals(age, cat.getAge());
        assertEquals(weight, cat.getWeight(), 0.01);
        assertEquals(color, cat.getColor());
    }

    @Test
    @DisplayName("Проверка получения информации о коте")
    @Description("Тест проверяет метод getInfo, который должен возвращать строку с данными о коте")
    @TmsLink("TC-002")
    public void testGetInfo() {
        Cat cat = createCat("Мурзик", 2, 3.8, "черный");
        String info = cat.getInfo();
        assertEquals("Кот: Мурзик, возраст: 2 лет, вес: 3.8 кг, цвет: черный", info);
    }

    @Test
    @DisplayName("Проверка метода кормления кота")
    @Description("Тест проверяет, что метод eat возвращает корректное сообщение")
    @TmsLink("TC-003")
    public void testEat() {
        Cat cat = createCat("Васька", 4, 5.2, "серый");
        assertEquals("Васька кушает", cat.eat());
    }

    @Test
    @DisplayName("Проверка метода сна кота")
    @Description("Тест проверяет, что метод sleep возвращает корректное сообщение")
    @TmsLink("TC-004")
    public void testSleep() {
        Cat cat = createCat("Пушок", 1, 2.5, "белый");
        assertEquals("Пушок спит", cat.sleep());
    }

    @Test
    @DisplayName("Проверка изменения веса кота")
    @Description("Тест проверяет сеттер веса и его корректное применение")
    @TmsLink("TC-005")
    @Issue("BUG-002")
    public void testSetWeight() {
        Cat cat = createCat("Толстяк", 5, 6.0, "черный");
        setCatWeight(cat, 7.5);
        assertEquals(7.5, cat.getWeight(), 0.01);
    }

    @Step("Установка веса кота: {weight}")
    public void setCatWeight(Cat cat, double weight) {
        cat.setWeight(weight);
    }

    @Test
    @DisplayName("Проверка определения, является ли кот толстым")
    @Description("Тест проверяет метод isFat для определения ожирения кота")
    @TmsLink("TC-006")
    public void testIsFat() {
        Cat fatCat = createCat("Толстый", 4, 6.5, "серый");
        Cat thinCat = createCat("Худой", 2, 5.5, "рыжий");
        assertTrue(fatCat.isFat());
        assertFalse(thinCat.isFat());
    }

    @Test
    @DisplayName("Проверка получения информации о цвете кота")
    @Description("Тест проверяет метод getColorInfo, возвращающий строку с информацией о цвете")
    @TmsLink("TC-007")
    public void testGetColorInfo() {
        Cat cat = createCat("Рыжик", 3, 4.1, "рыжий");
        assertEquals("Рыжик имеет рыжий цвет", cat.getColorInfo());
    }
}