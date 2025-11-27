package rozhnev;

import allclasses.rozhnev.Uchenick;
import org.junit.Test;

import static org.junit.Assert.*;

public class UchenikTest {

    @Test
    public void averageScoreReflectsAddedResults() {
        Uchenick uchenik = new Uchenick("Ivan", "Ivanov", 5);
        uchenik.addResult(5);
        uchenik.addResult(4);

        assertEquals(4.5, uchenik.getAverageScore(), 1e-9);
        assertEquals(2, uchenik.getCompletedAssignments());
    }

    @Test
    public void promoteIncrementsGradeLevel() {
        Uchenick uchenik = new Uchenick("Petr", "Petrov", 8);
        uchenik.promote();

        assertEquals(9, uchenik.getGradeLevel());
    }

    @Test
    public void excellentStudentRequiresHighAverage() {
        Uchenick uchenik = new Uchenick("Anna", "Sidorova", 6);
        uchenik.addResult(5);
        uchenik.addResult(5);

        assertTrue(uchenik.isExcellent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addResultRejectsInvalidScore() {
        Uchenick uchenik = new Uchenick("Olga", "Smirnova", 7);
        uchenik.addResult(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorRejectsInvalidGradeLevel() {
        new Uchenick("Max", "Nikolaev", 0);
    }
}
