import classes.skulyabina.student;

public class Main {
    static void bondarevMethod() {
        System.out.println("asdasd");
    }
    static void skulyabinaMethod() {
        // Тестируем класс Student
        System.out.println("\n=== Testing Student class ===");
        student student1 = new student("Anna", 20, "CS-101");
        student student2 = new student("Alex", 22, "CS-102");

        student1.displayInfo();
        student1.study();

        student2.displayInfo();
        student2.study();
    }

    static void main() {
        bondarevMethod();
        skulyabinaMethod();
    }
}
