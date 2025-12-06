package paromenkovatests;

import allclasses.paromenkova.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testCreateStudent() {
        Student student = new Student("Иван", "Петров", "15.05.2000", "ИТ-21", 4.7);
        Assert.assertNotNull(student);
        Assert.assertEquals("Иван", student.getFirstName());
        Assert.assertEquals("Петров", student.getLastName());
        Assert.assertEquals("15.05.2000", student.getBirthDate());
        Assert.assertEquals("ИТ-21", student.getGroup());
        Assert.assertEquals(4.7, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testIsExcellentStudent() {
        Student excellentStudent = new Student("Иван", "Петров", "15.05.2000", "ИТ-21", 4.7);
        Student goodStudent = new Student("Мария", "Иванова", "10.03.2001", "ИТ-22", 4.2);

        Assert.assertTrue(excellentStudent.isExcellentStudent());
        Assert.assertFalse(goodStudent.isExcellentStudent());
    }

//    @Test
//    public void testGetFullInfo() {
//        Student student = new Student("Иван", "Петров", "15.05.2000", "ИТ-21", 4.7);
//        String expected = "Студент: Иван Петров, Группа: ИТ-21, Дата рождения: 15.05.2000, Средний балл: 4,70";
//        Assert.assertEquals(expected, student.getFullInfo());
//    }

    @Test
    public void testUpdateGrade() {
        Student student = new Student("Иван", "Петров", "15.05.2000", "ИТ-21", 4.2);

        student.updateGrade(4.8);
        Assert.assertEquals(4.8, student.getAverageGrade(), 0.001);

        // Проверка на некорректную оценку
        student.updateGrade(6.0); // Должно игнорироваться
        Assert.assertEquals(4.8, student.getAverageGrade(), 0.001);

        student.updateGrade(-1.0); // Должно игнорироваться
        Assert.assertEquals(4.8, student.getAverageGrade(), 0.001);
    }

    @Test
    public void testBoundaryValues() {
        Student student1 = new Student("Анна", "Сидорова", "31.12.1999", "ИТ-23", 4.5); // Граница отличника
        Student student2 = new Student("Петр", "Васильев", "01.01.2002", "ИТ-24", 4.49); // Ниже границы

        Assert.assertTrue(student1.isExcellentStudent());
        Assert.assertFalse(student2.isExcellentStudent());
    }

    @Test
    public void testValidGradeRange() {
        Student student = new Student("Ольга", "Кузнецова", "20.07.2000", "ИТ-25", 3.0);

        // Проверка нижней границы
        student.updateGrade(0.0);
        Assert.assertEquals(0.0, student.getAverageGrade(), 0.001);

        // Проверка верхней границы
        student.updateGrade(5.0);
        Assert.assertEquals(5.0, student.getAverageGrade(), 0.001);

        // Проверка среднего значения
        student.updateGrade(3.5);
        Assert.assertEquals(3.5, student.getAverageGrade(), 0.001);
    }
}
