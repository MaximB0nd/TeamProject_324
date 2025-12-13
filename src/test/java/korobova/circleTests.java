package korobova;

import org.junit.Test;
import static org.junit.Assert.*;
import allclasses.korobova.circle;

public class circleTests {

    @Test
    public void testGetArea() {
        circle c = new circle(5);
        assertEquals(78.539816, c.getArea(), 0.000001);
    }

    @Test
    public void testGetAreaSmall() {
        circle c = new circle(2.5);
        assertEquals(19.634954, c.getArea(), 0.000001);
    }

    @Test
    public void testGetCircumference() {
        circle c = new circle(5);
        assertEquals(31.415926, c.getCircumference(), 0.000001);
    }

    @Test
    public void testGetCircumferenceSmall() {
        circle c = new circle(2.5);
        assertEquals(15.707963, c.getCircumference(), 0.000001);
    }
}