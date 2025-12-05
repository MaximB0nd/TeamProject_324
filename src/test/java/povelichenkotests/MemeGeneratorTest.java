package povelichenkotests;

import allclasses.povelichenko.meme;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemeGeneratorTest {

    @Test
    public void testRandomPhraseNotNull() {
        assertNotNull(meme.getRandomPhrase());
    }

    @Test
    public void testRandomSoundNotNull() {
        assertNotNull(meme.getRandomSound());
    }

    @Test
    public void testPrintDoesNotThrow() {
        try {
            meme.printRandomMeme();
        } catch (Exception e) {
            fail("Метод printRandomMeme() не должен выбрасывать исключения");
        }
    }
}
