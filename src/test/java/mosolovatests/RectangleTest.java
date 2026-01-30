package mosolovatests;

import allclasses.mosolova.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тесты для класса Rectangle
 */
public class RectangleTest {

    @Test
    public void testGetArea() {
        Rectangle rect = new Rectangle(5, 10);
        assertEquals(50, rect.getArea(), 0.001);
    }

    @Test
    public void testGetAreaSquare() {
        Rectangle rect = new Rectangle(7, 7);
        assertEquals(49, rect.getArea(), 0.001);
    }

    @Test
    public void testGetPerimeter() {
        Rectangle rect = new Rectangle(5, 10);
        assertEquals(30, rect.getPerimeter(), 0.001);
    }

    @Test
    public void testGetPerimeterSquare() {
        Rectangle rect = new Rectangle(6, 6);
        assertEquals(24, rect.getPerimeter(), 0.001);
    }
}

