package mosolovatests;

import allclasses.mosolova.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;

/**
 * Тесты для класса Rectangle
 */
public class RectangleTest {

    @Test
    @DisplayName("Проверка вычисления площади прямоугольника")
    @Description("Тест проверяет корректность вычисления площади прямоугольника с размерами 5x10")
    public void testGetArea() {
        System.out.println("Тест вычисления площади прямоугольника *");
        Rectangle rect = createRectangle(5, 10);
        double area = calculateArea(rect);
        assertEquals("Площадь должна быть равна 50", 50, area, 0.001);
    }

    @Test
    @DisplayName("Проверка вычисления площади квадрата")
    @Description("Тест проверяет корректность вычисления площади квадрата со стороной 7")
    public void testGetAreaSquare() {
        System.out.println("Тест вычисления площади квадрата *");
        Rectangle rect = createRectangle(7, 7);
        double area = calculateArea(rect);
        assertEquals("Площадь квадрата должна быть равна 49", 49, area, 0.001);
    }

    @Test
    @DisplayName("Проверка вычисления периметра прямоугольника")
    @Description("Тест проверяет корректность вычисления периметра прямоугольника с размерами 5x10")
    public void testGetPerimeter() {
        System.out.println("Тест вычисления периметра прямоугольника *");
        Rectangle rect = createRectangle(5, 10);
        double perimeter = calculatePerimeter(rect);
        assertEquals("Периметр должен быть равен 30", 30, perimeter, 0.001);
    }

    @Test
    @DisplayName("Проверка вычисления периметра квадрата")
    @Description("Тест проверяет корректность вычисления периметра квадрата со стороной 6")
    public void testGetPerimeterSquare() {
        System.out.println("Тест вычисления периметра квадрата *");
        Rectangle rect = createRectangle(6, 6);
        double perimeter = calculatePerimeter(rect);
        assertEquals("Периметр квадрата должен быть равен 24", 24, perimeter, 0.001);
    }

    private Rectangle createRectangle(double width, double height) {
        return new Rectangle(width, height);
    }

    private double calculateArea(Rectangle rect) {
        return rect.getArea();
    }

    private double calculatePerimeter(Rectangle rect) {
        return rect.getPerimeter();
    }
}

