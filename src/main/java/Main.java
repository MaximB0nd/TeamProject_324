import allclasses.bartasevich.Complex;
import allclasses.prokofev.WalletProkofev;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.shulga.Triangle;
import allclasses.simonenko.Fractions;

public class Main {
    public static void bondarevMethod() {
        System.out.println("asdasd");
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

    public static void SimonenkoMetod () {
        // Создание дробей
        Fractions frac1 = new Fractions(1, 2);
        Fractions frac2 = new Fractions(3, 4);
        Fractions frac3 = new Fractions(5);

        System.out.println("Дробь 1: " + frac1);
        System.out.println("Дробь 2: " + frac2);
        System.out.println("Дробь 3: " + frac3);

        // Сложение
        Fractions sum = frac1.add(frac2);
        System.out.println(frac1 + " + " + frac2 + " = " + sum);

        // Вычитание
        Fractions difference = frac1.subtract(frac2);
        System.out.println(frac1 + " - " + frac2 + " = " + difference);

        // Сокращение дробей
        Fractions simplified = new Fractions(4, 8);
        System.out.println("Сокращение 4/8: " + simplified);
    }

    public static void main(String[] args) {
        bondarevMethod();
        BartasevichMethod();
        testWallet();
        larinMethod();
        shulgaMethods();
        SimonenkoMetod();
    }
    
}
