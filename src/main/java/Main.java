import allclasses.korobova.circle;

public class Main {
    public static void korobovaMethod() {
        System.out.println("\n=== Testing Circle Korobova ===");

        circle circle1 = new circle(5);
        circle circle2 = new circle(2.5);

        System.out.println("Circle 1 (radius = 5):");
        System.out.println("  Area: " + circle1.getArea());
        System.out.println("  Circumference: " + circle1.getCircumference());

        System.out.println("Circle 2 (radius = 2.5):");
        System.out.println("  Area: " + circle2.getArea());
        System.out.println("  Circumference: " + circle2.getCircumference());
    }

    public static void main(String[] args) {
        korobovaMethod();
    }
}