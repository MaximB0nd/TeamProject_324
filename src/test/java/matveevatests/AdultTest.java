package matveevatests;

import allclasses.matveeva.Adult;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdultTest {

    @Test
    @DisplayName("Checking for the correctness of the string")
    public void testGetGreeting() {
        allclasses.matveeva.Adult person = new allclasses.matveeva.Adult("Alex", 25);
        String expected = "Hello, my name is Alex and I am 25 years old.";
        assertEquals(expected, person.getGreeting());
    }

    @Test
    public void testIsAdult_true() {
        allclasses.matveeva.Adult person = new allclasses.matveeva.Adult("Maria", 20);
        assertTrue(person.isAdult());
    }

    @Test
    public void testIsAdult_false() {
        allclasses.matveeva.Adult person = new allclasses.matveeva.Adult("Sasha", 15);
        assertFalse(person.isAdult());
    }
}