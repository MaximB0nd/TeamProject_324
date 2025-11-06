import allclasses.prokudin.Fraction;

public class Main {
    static void bondarevMethod() {
        System.out.println("asdasd");
    }
    static void prokudinMethod() {
        Fraction fraction_a = new Fraction(1, 2);
        Fraction fraction_b = new Fraction(3, 4);

        System.out.println("Sum" + Fraction.Sum(fraction_a, fraction_b));
        System.out.println("Sub" + Fraction.Sub(fraction_a, fraction_b));
        System.out.println("Multi" + Fraction.Multi(fraction_a, fraction_b));
        System.out.println("Div" + Fraction.Div(fraction_a, fraction_b));
    }

    static void main() {
        bondarevMethod();
    }
}
