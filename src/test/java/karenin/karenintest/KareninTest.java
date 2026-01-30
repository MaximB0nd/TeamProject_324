package karenin.karenintest;

import allclasses.karenin.KareninRectangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тестовый класс для KareninRectangle
 */
public class KareninTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testConstructorValidValues() {
        KareninRectangle rect = new KareninRectangle(5.0, 10.0);
        assertEquals(5.0, rect.getWidth(), DELTA);
        assertEquals(10.0, rect.getHeight(), DELTA);
    }

    @Test
    public void testConstructorZeroWidth() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new KareninRectangle(0, 10.0);
        });
        assertEquals("Ширина и высота должны быть больше 0", exception.getMessage());
    }

    @Test
    public void testConstructorZeroHeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new KareninRectangle(5.0, 0);
        });
        assertEquals("Ширина и высота должны быть больше 0", exception.getMessage());
    }

    @Test
    public void testConstructorNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new KareninRectangle(-5.0, 10.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new KareninRectangle(5.0, -10.0);
        });
    }

    @Test
    public void testGetArea() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        assertEquals(12.0, rect.getArea(), DELTA);

        KareninRectangle rect2 = new KareninRectangle(2.5, 4.0);
        assertEquals(10.0, rect2.getArea(), DELTA);
    }

    @Test
    public void testGetPerimeter() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        assertEquals(14.0, rect.getPerimeter(), DELTA);

        KareninRectangle rect2 = new KareninRectangle(2.5, 4.0);
        assertEquals(13.0, rect2.getPerimeter(), DELTA);
    }

    @Test
    public void testIsSquareTrue() {
        KareninRectangle square = new KareninRectangle(5.0, 5.0);
        assertTrue(square.isSquare());

        KareninRectangle almostSquare = new KareninRectangle(5.0, 5.0000001);
        assertTrue(almostSquare.isSquare()); // с учетом погрешности
    }

    @Test
    public void testIsSquareFalse() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        assertFalse(rect.isSquare());

        KareninRectangle rect2 = new KareninRectangle(5.0, 5.1);
        assertFalse(rect2.isSquare());
    }

    @Test
    public void testGetDiagonal() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        assertEquals(5.0, rect.getDiagonal(), DELTA); // 3-4-5 треугольник

        KareninRectangle rect2 = new KareninRectangle(1.0, 1.0);
        assertEquals(Math.sqrt(2), rect2.getDiagonal(), DELTA);
    }

    @Test
    public void testScaleValidFactor() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        KareninRectangle scaled = rect.scale(2.0);

        assertEquals(6.0, scaled.getWidth(), DELTA);
        assertEquals(8.0, scaled.getHeight(), DELTA);
        assertEquals(48.0, scaled.getArea(), DELTA); // площадь увеличится в 4 раза
    }

    @Test
    public void testScaleFactorOne() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);
        KareninRectangle scaled = rect.scale(1.0);

        assertEquals(3.0, scaled.getWidth(), DELTA);
        assertEquals(4.0, scaled.getHeight(), DELTA);
    }

    @Test
    public void testScaleZeroFactor() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rect.scale(0);
        });
        assertEquals("Коэффициент масштабирования должен быть больше 0", exception.getMessage());
    }

    @Test
    public void testScaleNegativeFactor() {
        KareninRectangle rect = new KareninRectangle(3.0, 4.0);

        assertThrows(IllegalArgumentException.class, () -> {
            rect.scale(-2.0);
        });
    }

    @Test
    public void testToString() {
        KareninRectangle rect = new KareninRectangle(3.5, 4.75);
        String result = rect.toString();

        assertTrue(result.contains("KareninRectangle"));
        assertTrue(result.contains("width=3.50"));
        assertTrue(result.contains("height=4.75"));
    }

    @Test
    public void testGetAreaAfterScale() {
        KareninRectangle rect = new KareninRectangle(2.0, 3.0);
        KareninRectangle scaled = rect.scale(3.0);

        // Площадь должна увеличиться в 9 раз (3^2)
        assertEquals(rect.getArea() * 9, scaled.getArea(), DELTA);
    }

    @Test
    public void testGetPerimeterAfterScale() {
        KareninRectangle rect = new KareninRectangle(2.0, 3.0);
        KareninRectangle scaled = rect.scale(2.0);

        // Периметр должен увеличиться в 2 раза
        assertEquals(rect.getPerimeter() * 2, scaled.getPerimeter(), DELTA);
    }
}
