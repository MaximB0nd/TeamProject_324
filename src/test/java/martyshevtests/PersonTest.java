package martyshevtests;

import allclasses.martyshev.SomeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testGetAgeInFiveYears() {
        SomeClass.Person p = new SomeClass.Person("Иван", 20);
        assertEquals(25, p.getAgeInFiveYears());
    }
}
