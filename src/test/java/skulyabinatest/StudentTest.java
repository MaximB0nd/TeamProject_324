package skulyabinatest;

import allclasses.skulyabina.student;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Issue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class StudentTest {

    private student student;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        student = new student("Иван Иванов", 20, "CS-101");
    }

    @Test
    @DisplayName("Проверка создания студента")
    @Description("Тест проверяет корректное создание объекта студента")
    @TmsLink("TC-001")
    @Issue("BUG-001")
    public void testStudentCreation() {
        assertNotNull(student);
    }

    @Test
    @DisplayName("Проверка инициализации полей студента")
    @Description("Тест проверяет, что поля студента корректно инициализируются через reflection")
    @TmsLink("TC-002")
    public void testStudentFieldsInitialization() throws Exception {
        Field nameField = student.getClass().getDeclaredField("name");
        Field ageField = student.getClass().getDeclaredField("age");
        Field groupField = student.getClass().getDeclaredField("group");

        nameField.setAccessible(true);
        ageField.setAccessible(true);
        groupField.setAccessible(true);

        checkFieldValue("Имя студента", "Иван Иванов", nameField.get(student));
        checkFieldValue("Возраст студента", 20, ageField.get(student));
        checkFieldValue("Группа студента", "CS-101", groupField.get(student));
    }

    @Step("Проверка значения поля {fieldName}")
    private void checkFieldValue(String fieldName, Object expected, Object actual) {
        if (expected instanceof String) {
            assertEquals(expected, actual);
        } else if (expected instanceof Integer) {
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Проверка отображения информации о студенте")
    @Description("Тест проверяет вывод информации о студенте в консоль")
    @TmsLink("TC-003")
    public void testDisplayInfo() {
        setupConsoleCapture();
        student.displayInfo();
        String output = captureConsoleOutput();

        verifyOutputContains("Student: Иван Иванов", output);
        verifyOutputContains("Age: 20", output);
        verifyOutputContains("Group: CS-101", output);
    }

    @Step("Настройка перехвата вывода в консоль")
    private void setupConsoleCapture() {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Step("Получение вывода из консоли")
    private String captureConsoleOutput() {
        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

    @Step("Проверка, что вывод содержит: {expectedText}")
    private void verifyOutputContains(String expectedText, String actualOutput) {
        assertTrue("Вывод должен содержать: " + expectedText, actualOutput.contains(expectedText));
    }

    @Test
    @DisplayName("Проверка метода study()")
    @Description("Тест проверяет метод изучения студента")
    @TmsLink("TC-004")
    @Issue("BUG-002")
    public void testStudy() {
        setupConsoleCapture();
        student.study();
        String output = captureConsoleOutput();

        verifyOutputEquals("Иван Иванов is studying...", output);
    }

    @Step("Проверка точного совпадения вывода")
    private void verifyOutputEquals(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка студента с отрицательным возрастом")
    @Description("Тест проверяет создание студента с отрицательным возрастом")
    @TmsLink("TC-005")
    public void testStudentWithNegativeAge() throws Exception {
        student studentWithNegativeAge = createStudent("Петр", -5, "AB-12");
        Field ageField = studentWithNegativeAge.getClass().getDeclaredField("age");
        ageField.setAccessible(true);

        verifyFieldValue("Возраст", -5, ageField.get(studentWithNegativeAge));
    }

    @Step("Создание студента с именем: {name}, возрастом: {age}, группой: {group}")
    private student createStudent(String name, int age, String group) {
        return new student(name, age, group);
    }

    @Step("Проверка значения поля {fieldName}")
    private void verifyFieldValue(String fieldName, Object expected, Object actual) {
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка студента с пустым именем")
    @Description("Тест проверяет создание студента с пустым именем")
    @TmsLink("TC-006")
    public void testStudentWithEmptyName() throws Exception {
        student studentWithEmptyName = createStudent("", 18, "Group-A");
        Field nameField = studentWithEmptyName.getClass().getDeclaredField("name");
        nameField.setAccessible(true);

        verifyFieldValue("Имя", "", nameField.get(studentWithEmptyName));
    }

    @Test
    @DisplayName("Проверка студента с null группой")
    @Description("Тест проверяет создание студента с null значением группы")
    @TmsLink("TC-007")
    public void testStudentWithNullGroup() throws Exception {
        student studentWithNullGroup = createStudent("Анна", 21, null);
        Field groupField = studentWithNullGroup.getClass().getDeclaredField("group");
        groupField.setAccessible(true);

        verifyFieldValue("Группа", null, groupField.get(studentWithNullGroup));
    }

    @Test
    @DisplayName("Проверка displayInfo() с null группой")
    @Description("Тест проверяет вывод информации о студенте с null группой")
    @TmsLink("TC-008")
    @Issue("BUG-003")
    public void testDisplayInfoWithNullGroup() {
        student studentWithNullGroup = createStudent("Анна", 21, null);

        setupConsoleCapture();
        studentWithNullGroup.displayInfo();
        String output = captureConsoleOutput();

        verifyOutputNotNull(output);
        verifyOutputContains("Student: Анна", output);
        verifyOutputContains("Age: 21", output);
        verifyOutputContains("Group: null", output);
    }

    @Step("Проверка, что вывод не null")
    private void verifyOutputNotNull(String output) {
        assertNotNull(output);
    }

    @Test
    @DisplayName("Проверка study() с пустым именем")
    @Description("Тест проверяет метод study() для студента с пустым именем")
    @TmsLink("TC-009")
    public void testStudyWithEmptyName() {
        student studentWithEmptyName = createStudent("", 18, "Group-A");

        setupConsoleCapture();
        studentWithEmptyName.study();
        String output = captureConsoleOutput();

        verifyOutputEquals(" is studying...", output);
    }

    @Test
    @DisplayName("Сравнение двух студентов")
    @Description("Тест проверяет сравнение двух одинаковых студентов")
    @TmsLink("TC-010")
    public void testCompareTwoStudents() throws Exception {
        student student1 = createStudent("Иван Иванов", 20, "CS-101");
        student student2 = createStudent("Иван Иванов", 20, "CS-101");

        compareStudentFields(student1, student2);
    }

    @Step("Сравнение полей двух студентов")
    private void compareStudentFields(student student1, student student2) throws Exception {
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

        verifyFieldsEqual("Имена", name1, name2);
        verifyFieldsEqual("Возраст", age1, age2);
        verifyFieldsEqual("Группы", group1, group2);
    }

    @Step("Проверка равенства {fieldName}")
    private void verifyFieldsEqual(String fieldName, Object value1, Object value2) {
        assertEquals(fieldName + " должны совпадать", value1, value2);
    }
}