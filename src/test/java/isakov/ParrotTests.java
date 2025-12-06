package isakov;

import allclasses.isakov.Parrot;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParrotTests {

    @Test
    public void getName_ReturnsCorrectName() {
        Parrot parrot = new Parrot("Kesha", 2);
        String expected = "Kesha";
        Assert.assertEquals(expected, parrot.getName());
    }

    @Test
    public void getAge_ReturnsCorrectAge() {
        Parrot parrot = new Parrot("Kesha", 2);
        int expected = 2;
        Assert.assertEquals(expected, parrot.getAge());
    }

    @Test
    public void say_PrintsCorrectPhrase() {
        Parrot parrot = new Parrot("Kesha", 2);

        // Перехватываем System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        parrot.say("Привет!");

        String expected = "Kesha говорит: Привет!\n";

        Assert.assertEquals(expected, output.toString());
    }
}
