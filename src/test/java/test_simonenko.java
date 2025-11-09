import org.junit.Assert;
import org.junit.Test;
import allclasses.Simonenko.Fractions;
import org.junit.Test;
import static org.junit.Assert.*;

public class test_simonenko {

    public class FractionsTest {

        public void testAdd() {
            Fractions a = new Fractions(1, 2);
            Fractions b = new Fractions(1, 3);
            Fractions result = a.add(b);
            assertEquals("5/6", result.toString());
        }

        public void testSubtract() {
            Fractions a = new Fractions(1, 2);
            Fractions b = new Fractions(1, 3);
            Fractions result = a.subtract(b);
            assertEquals("1/6", result.toString());
        }

        public void testWholeNumber() {
            Fractions frac = new Fractions(5);
            assertEquals("5", frac.toString());
        }

        public void testConstructor() {
            Fractions frac = new Fractions(1, 2);
            assertEquals("1/2", frac.toString());
        }

        public void testConstructorWithZeroDenominator() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Fractions(1, 0);
            });
        }
    }

}
