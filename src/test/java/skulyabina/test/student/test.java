package skulyabina.test.student;

import classes.skulyabina.student;

public class test {
    public static void main(String[] args) {
        // Создаем студентов
        student student1 = new student("Anna", 20, "CS-101");
        student student2 = new student("Alex", 22, "CS-102");

        // Тестируем методы
        System.out.println("=== Testing student class ===");
        student1.displayInfo();
        student1.study();

        student2.displayInfo();
        student2.study();

        // Тест с разными данными
        student student3 = new student("Maria", 19, "MATH-201");
        student3.displayInfo();
    }
}