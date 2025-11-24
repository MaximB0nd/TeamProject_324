package kukushkintests;

import allclasses.kukushkin.Student;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("Ivan Petrov", 20);
    }

    @Test
    public void testStudentCreation() {
        assertEquals("Ivan Petrov", student.getName());
        assertEquals(20, student.getAge());
        assertTrue(student.getGrades().isEmpty());
    }

    @Test
    public void testAddValidGrade() {
        student.addGrade(9);
        student.addGrade(10);

        List<Integer> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertTrue(grades.contains(9));
        assertTrue(grades.contains(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidGradeTooLow() {
        student.addGrade(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidGradeTooHigh() {
        student.addGrade(11);
    }

    @Test
    public void testCalculateAverageGrade() {
        student.addGrade(8);
        student.addGrade(9);
        student.addGrade(10);

        assertEquals(9.0, student.calculateAverageGrade(), 0.001);
    }

    @Test
    public void testCalculateAverageGradeEmpty() {
        assertEquals(0.0, student.calculateAverageGrade(), 0.001);
    }

    @Test
    public void testIsExcellentStudent() {
        student.addGrade(9);
        student.addGrade(10);
        student.addGrade(9);

        assertTrue(student.isExcellentStudent());
    }

    @Test
    public void testIsNotExcellentStudent() {
        student.addGrade(6);
        student.addGrade(7);
        student.addGrade(8);

        assertFalse(student.isExcellentStudent());
    }

    @Test
    public void testHasGrade() {
        student.addGrade(8);
        student.addGrade(9);

        assertTrue(student.hasGrade(8));
        assertTrue(student.hasGrade(9));
        assertFalse(student.hasGrade(10));
    }

    @Test
    public void testToString() {
        student.addGrade(9);
        student.addGrade(10);

        String result = student.toString();
        assertTrue(result.contains("Ivan Petrov"));
        assertTrue(result.contains("20"));
        assertTrue(result.contains("grades=[9, 10]"));
    }
}