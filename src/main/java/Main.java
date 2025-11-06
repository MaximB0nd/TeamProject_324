import allclasses.bartasevich.Complex;

public class Main {
    public static void bondarevMethod() {
        System.out.println("asdasd");
    }

    public static void main(String[] args) {
        bondarevMethod();
        BartasevichMethod();
    }
    public static void BartasevichMethod(){

        Complex complex = new Complex();
        Complex complex1 = new Complex(2, 4);
        double modd = complex1.Abs();
        System.out.println(modd);

    }
}
