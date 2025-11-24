package kukushkintests;

import allclasses.kukushkin.Student;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentBoundaryTest {

    @Test
    public void testMinimumValidGrade() {
        Student student = new Student("Test", 18);
        student.addGrade(1);
        assertTrue(student.hasGrade(1));
    }

    @Test
    public void testMaximumValidGrade() {
        Student student = new Student("Test", 18);
        student.addGrade(10);
        assertTrue(student.hasGrade(10));
    }

    @Test
    public void testAverageGradePrecision() {
        Student student = new Student("Test", 18);
        student.addGrade(5);
        student.addGrade(6);
        student.addGrade(7);

        // (5+6+7)/3 = 18/3 = 6.0
        assertEquals(6.0, student.calculateAverageGrade(), 0.001);
    }

    @Test
    public void testExcellentStudentBoundary() {
        Student student1 = new Student("Good", 20);
        student1.addGrade(8);
        student1.addGrade(9);
        student1.addGrade(8); // average = 8.33

        Student student2 = new Student("Excellent", 20);
        student2.addGrade(9);
        student2.addGrade(9);
        student2.addGrade(8); // average = 8.67

        assertFalse(student1.isExcellentStudent());
        assertTrue(student2.isExcellentStudent());
    }
}