package martyshevtests;

import allclasses.martyshev.Person;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;

public class PersonTest {




    @Step("Создаём объект Person: имя = {name}, возраст = {age}")
    public Person createPerson(String name, int age) {
        return new Person(name, age);
    }

    @Step("Перехватываем вывод метода sayHello()")
    public String captureSayHello(Person p) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        p.sayHello();

        System.setOut(originalOut);
        return outputStream.toString();
    }

    @Step("Проверяем вывод: ожидается = \"{expected}\"")
    public void verifyOutput(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Возраст через 5 лет считается корректно")
    @Description("Проверяет корректность вычисления возраста через 5 лет при нормальном значении возраста.")
    @TmsLink("TC-001")
    @Issue("BUG-001")
    public void testGetAgeInFiveYears() {
        Person p = createPerson("Иван", 20);
        assertEquals(25, p.getAgeInFiveYears());
    }


    @Test
    @DisplayName("Метод sayHello выводит корректное сообщение")
    @Description("Проверяем, что sayHello() выводит правильное приветствие.")
    @TmsLink("TC-002")
    @Issue("BUG-002")
    public void testSayHelloOutput() {
        Person p = createPerson("Анна", 25);
        String actual = captureSayHello(p);
        String expected = "Привет, меня зовут Анна, мне 25 лет." + System.lineSeparator();
        verifyOutput(expected, actual);
    }


    @Test
    @DisplayName("Возраст 0 лет → через 5 лет будет 5")
    @Description("Проверяем, что метод правильно обрабатывает возраст = 0.")
    @TmsLink("TC-003")
    @Issue("BUG-003")
    public void testGetAgeInFiveYearsWithZeroAge() {
        Person p = createPerson("Ребенок", 0);
        assertEquals(5, p.getAgeInFiveYears());
    }


    @Test
    @DisplayName("Максимальный возраст не переполняется")
    @Description("Проверяем, что результат не выходит за пределы Integer.MAX_VALUE.")
    @TmsLink("TC-004")
    @Issue("BUG-004")
    public void testGetAgeInFiveYearsWithMaxIntAge() {
        Person p = createPerson("Долгожитель", Integer.MAX_VALUE - 5);
        assertEquals(Integer.MAX_VALUE, p.getAgeInFiveYears());
    }


    @Test
    @DisplayName("Отрицательный возраст корректно обрабатывается")
    @Description("Проверяем корректность вычислений при отрицательном возрасте.")
    @TmsLink("TC-005")
    @Issue("BUG-005")
    public void testGetAgeInFiveYearsWithNegativeAge() {
        Person p = createPerson("Тест", -3);
        assertEquals(2, p.getAgeInFiveYears());
    }


    @Test
    @DisplayName("Пустое имя корректно выводится в сообщении")
    @Description("Проверяем сообщение sayHello() при пустом имени.")
    @TmsLink("TC-006")
    @Issue("BUG-006")
    public void testSayHelloWithEmptyName() {
        Person p = createPerson("", 30);
        String actual = captureSayHello(p);
        String expected = "Привет, меня зовут , мне 30 лет." + System.lineSeparator();
        verifyOutput(expected, actual);
    }
}
