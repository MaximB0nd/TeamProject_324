import allclasses.mosolova.Rectangle;

public class Main {
    static void bondarevMethod() {
        System.out.println("asdasd");
    }

    static void mosolovaMethod() {
        Rectangle rect = new Rectangle(5, 10);
        System.out.println("Прямоугольник 5x10:");
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }

    public static void main(String[] args) {
        bondarevMethod();
        mosolovaMethod();
    }
}
