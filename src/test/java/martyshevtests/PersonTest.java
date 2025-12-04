package martyshevtests;

import allclasses.martyshev.Person;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testGetAgeInFiveYears() {
        Person p = new Person("Иван", 20);
        assertEquals(25, p.getAgeInFiveYears());
    }

    // 1. Тест на метод sayHello() - проверяем вывод в консоль
    @Test
    public void testSayHelloOutput() {
        Person p = new Person("Анна", 25);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        p.sayHello();

        System.setOut(originalOut);
        String expectedOutput = "Привет, меня зовут Анна, мне 25 лет." + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

    // 2. Тест на граничное значение возраста (0 лет)
    @Test
    public void testGetAgeInFiveYearsWithZeroAge() {
        Person p = new Person("Ребенок", 0);
        assertEquals(5, p.getAgeInFiveYears());
    }

    // 3. Тест на максимальное значение возраста
    @Test
    public void testGetAgeInFiveYearsWithMaxIntAge() {
        Person p = new Person("Долгожитель", Integer.MAX_VALUE - 5);
        assertEquals(Integer.MAX_VALUE, p.getAgeInFiveYears());
    }

    // 4. Тест на отрицательный возраст (если такая возможность есть)
    @Test
    public void testGetAgeInFiveYearsWithNegativeAge() {
        Person p = new Person("Тест", -3);
        assertEquals(2, p.getAgeInFiveYears());
    }

    // 5. Тест на пустое имя
    @Test
    public void testSayHelloWithEmptyName() {
        Person p = new Person("", 30);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        p.sayHello();

        System.setOut(originalOut);
        String expectedOutput = "Привет, меня зовут , мне 30 лет." + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
}