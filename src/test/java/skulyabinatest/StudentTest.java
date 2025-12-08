package skulyabinatest;
import allclasses.skulyabina.student;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class StudentTest {

    private student student;

    @Before
    public void setUp() {
        student = new student("Иван Иванов", 20, "CS-101");
    }

    @Test
    public void testStudentCreation() {
        assertNotNull(student);
    }

    @Test
    public void testStudentFieldsInitialization() throws Exception {
        // Получаем доступ к приватным полям через reflection
        Field nameField = student.getClass().getDeclaredField("name");
        Field ageField = student.getClass().getDeclaredField("age");
        Field groupField = student.getClass().getDeclaredField("group");

        nameField.setAccessible(true);
        ageField.setAccessible(true);
        groupField.setAccessible(true);

        // Проверяем значения полей
        assertEquals("Иван Иванов", nameField.get(student));
        assertEquals(20, ageField.get(student));
        assertEquals("CS-101", groupField.get(student));
    }

    @Test
    public void testDisplayInfo() {
        // Перехватываем вывод в консоль
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        student.displayInfo();

        System.setOut(originalOut);
        String output = outputStream.toString().trim();

        // Проверяем, что вывод содержит все нужные данные
        assertTrue(output.contains("Student: Иван Иванов"));
        assertTrue(output.contains("Age: 20"));
        assertTrue(output.contains("Group: CS-101"));
    }

    @Test
    public void testStudy() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        student.study();

        System.setOut(originalOut);
        String output = outputStream.toString().trim();

        assertEquals("Иван Иванов is studying...", output);
    }

    @Test
    public void testStudentWithNegativeAge() throws Exception {
        student studentWithNegativeAge = new student("Петр", -5, "AB-12");

        Field ageField = studentWithNegativeAge.getClass().getDeclaredField("age");
        ageField.setAccessible(true);

        assertEquals(-5, ageField.get(studentWithNegativeAge));
    }

    @Test
    public void testStudentWithEmptyName() throws Exception {
        student studentWithEmptyName = new student("", 18, "Group-A");

        Field nameField = studentWithEmptyName.getClass().getDeclaredField("name");
        nameField.setAccessible(true);

        assertEquals("", nameField.get(studentWithEmptyName));
    }

    @Test
    public void testStudentWithNullGroup() throws Exception {
        student studentWithNullGroup = new student("Анна", 21, null);

        Field groupField = studentWithNullGroup.getClass().getDeclaredField("group");
        groupField.setAccessible(true);

        assertNull(groupField.get(studentWithNullGroup));
    }

    @Test
    public void testDisplayInfoWithNullGroup() {
        student studentWithNullGroup = new student("Анна", 21, null);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        studentWithNullGroup.displayInfo();

        System.setOut(originalOut);
        String output = outputStream.toString().trim();

        // Проверяем, что метод не падает и выводит что-то
        assertNotNull(output);
        assertTrue(output.contains("Student: Анна"));
        assertTrue(output.contains("Age: 21"));
        assertTrue(output.contains("Group: null"));
    }

    @Test
    public void testStudyWithEmptyName() {
        student studentWithEmptyName = new student("", 18, "Group-A");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        studentWithEmptyName.study();

        System.setOut(originalOut);
        String output = outputStream.toString().trim();

        assertEquals(" is studying...", output);
    }

    @Test
    public void testCompareTwoStudents() throws Exception {
        student student1 = new student("Иван Иванов", 20, "CS-101");
        student student2 = new student("Иван Иванов", 20, "CS-101");

        Field nameField = student1.getClass().getDeclaredField("name");
        Field ageField = student1.getClass().getDeclaredField("age");
        Field groupField = student1.getClass().getDeclaredField("group");

        nameField.setAccessible(true);
        ageField.setAccessible(true);
        groupField.setAccessible(true);

        String name1 = (String) nameField.get(student1);
        String name2 = (String) nameField.get(student2);
        int age1 = (int) ageField.get(student1);
        int age2 = (int) ageField.get(student2);
        String group1 = (String) groupField.get(student1);
        String group2 = (String) groupField.get(student2);

        assertEquals(name1, name2);
        assertEquals(age1, age2);
        assertEquals(group1, group2);
    }
}