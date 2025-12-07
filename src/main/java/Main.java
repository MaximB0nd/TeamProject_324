import allclasses.prokudin.Fraction;
import allclasses.mosolova.Rectangle;
import allclasses.bartasevich.Complex;
import allclasses.prokofev.WalletProkofev;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.bondarev.Mark;
import allclasses.shulga.Triangle;
import allclasses.valaeva.Cat;


public class Main {
    public static void bondarevMethod() {
        Mark firstMark = new Mark(4);
        Mark secondMark = new Mark(0);
        Mark thirdMark = new Mark(5);
        Mark fourthMark = new Mark(10);
        firstMark.get();
        secondMark.plus();
        thirdMark.minus();
        fourthMark.set(5);
    }

    static void ValaevaMethod() {
        System.out.println("\n=== Testing Cat Valaeva ===");


        Cat cat = new Cat("Гера", 3, 4.5, "серый");
        System.out.println("Кошка: " + cat.getInfo());

        System.out.println(cat.eat());
        System.out.println(cat.sleep());

        System.out.println("Толстая ли кошка? " + cat.isFat());
    }
    static void testWallet() {
        System.out.println("\n=== Testing WalletProkofev ===");
        WalletProkofev wallet = new WalletProkofev("TestUser");
        System.out.println("Created wallet: " + wallet);
        
        wallet.deposit(new BigDecimal("100.50"), "Initial deposit");
        System.out.println("After deposit: " + wallet.getBalance());
        
        wallet.withdraw(new BigDecimal("30.00"), "Purchase");
        System.out.println("After withdraw: " + wallet.getBalance());
        
        System.out.println("History:");
        wallet.getHistorySnapshot().forEach(System.out::println);
    }
  
    static void mosolovaMethod() {
        Rectangle rect = new Rectangle(5, 10);
        System.out.println("Прямоугольник 5x10:");
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }

    static void larinMethod()
    {
        System.out.println("Test work book class:");
        Book firstBook = new Book("Алгоритмы и структуры данных", true);
        firstBook.borrowBook();
        firstBook.returnBook();
        Book secondBook = new Book("Два капитана", false);
        secondBook.borrowBook();
        secondBook.returnBook();
        secondBook.returnBook();
    }
    static void prokudinMethod() {
        Fraction fraction_a = new Fraction(1, 2);
        Fraction fraction_b = new Fraction(3, 4);

        System.out.println("Sum" + Fraction.Sum(fraction_a, fraction_b));
        System.out.println("Sub" + Fraction.Sub(fraction_a, fraction_b));
        System.out.println("Multi" + Fraction.Multi(fraction_a, fraction_b));
        System.out.println("Div" + Fraction.Div(fraction_a, fraction_b));
    }
  
    public static void BartasevichMethod(){

        Complex complex = new Complex();
        Complex complex1 = new Complex(2, 4);
        double modd = complex1.Abs();
        System.out.println(modd);
    }

    public static void shulgaMethods(){
        Triangle tr1 = new Triangle(1, 2, 3);
        Triangle tr2 = new Triangle(12, 12, 20);

        System.out.println("\nТреугольник 1 со сторонами А = " + tr1.GetA() + ", B = " + tr1.GetB() + ", C = " + tr1.GetC());
        System.out.println("Треугольник 2 со сторонами А = " + tr2.GetA() + ", B = " + tr2.GetB() + ", C = " + tr2.GetC());

        System.out.println("\nПроверка что треугольники существуют:");
        if (tr1.IsExist()) {
            System.out.println("Треугольник 1 существует");
        } else {
            System.out.println("Треугольник 1 НЕ существует");
        }

        if (tr2.IsExist()) {
            System.out.println("Треугольник 2 существует\n");
        } else {
            System.out.println("Треугольник 2 НЕ существует\n");
        }

        if (tr1.IsExist()){
            System.out.println("Площадь треугольника 1: "+ tr1.GetSquare());
            System.out.println("Периметр треугольника 1: " + tr1.GetPerimetr());
        }

        if (tr2.IsExist()){
            System.out.println("Площадь треугольника 2: "+ tr2.GetSquare());
            System.out.println("Периметр треугольника 2: " + tr2.GetPerimetr());
        }

        return;
    }

    public static void main(String[] args) {
        bondarevMethod();
        mosolovaMethod();
        BartasevichMethod();
        testWallet();
        larinMethod();
        shulgaMethods();
        ValaevaMethod();
        prokudinMethod();
    }

}
