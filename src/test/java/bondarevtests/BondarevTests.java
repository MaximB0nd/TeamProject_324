package bondarevtests;

import allclasses.bondarev.Mark;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BondarevTests {

    private static final float DELTA = 0.0001f;

    @Test
    public void defaultConstructor_ShouldSetZero() {
        Mark mark = new Mark();
        assertEquals(0, mark.get(), DELTA);
    }

    @Test
    public void constructorWithValue_ShouldSetValueInValidRange() {
        assertEquals(3, new Mark(3).get(), DELTA);
        assertEquals(5, new Mark(7).get(), DELTA);
        assertEquals(0, new Mark(-2).get(), DELTA);
    }

    @Test
    public void plus_ShouldIncreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.plus();
        assertEquals(3, mark.get(), DELTA);

        mark = new Mark(5);
        mark.plus();
        assertEquals(5, mark.get(), DELTA);
    }

    @Test
    public void minus_ShouldDecreaseWithinBounds() {
        Mark mark = new Mark(2);
        mark.minus();
        assertEquals(1, mark.get(), DELTA);

        mark = new Mark(0);
        mark.minus();
        assertEquals(0, mark.get(), DELTA);
    }

    @Test
    public void plusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(2);
        mark.plus(2);
        assertEquals(4, mark.get(), DELTA);

        mark.plus(10);
        assertEquals(5, mark.get(), DELTA);

        mark = new Mark(2);
        mark.plus(-1);
        assertEquals(1, mark.get(), DELTA);
    }

    @Test
    public void minusWithValue_ShouldHandleValidAndInvalidCases() {
        Mark mark = new Mark(4);
        mark.minus(2);
        assertEquals(2, mark.get(), DELTA);

        mark.minus(10);
        assertEquals(0, mark.get(), DELTA);

        mark = new Mark(3);
        mark.minus(-2);
        assertEquals(5, mark.get(), DELTA);
    }

    @Test
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