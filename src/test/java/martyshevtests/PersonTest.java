package martyshevtests;

import allclasses.martyshev.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testGetAgeInFiveYears() {
        Person p = new Person("Иван", 20);
        assertEquals(25, p.getAgeInFiveYears());
    }
}
