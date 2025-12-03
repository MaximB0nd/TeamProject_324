import allclasses.prokudin.Fraction;
import allclasses.mosolova.Rectangle;
import allclasses.bartasevich.Complex;
import allclasses.prokofev.WalletProkofev;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.bondarev.Mark;
import allclasses.shulga.Triangle;
import allclasses.simonenko.Fractions;
import allclasses.valaeva.Cat;
import allclasses.sukhorukov.Calculator;
import allclasses.andreeva.Password;

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
     public static void sukhorukovMethod() {
        System.out.println("=== Демонстрация работы класса Calculator ===");
        Calculator calc1 = new Calculator("Casio FX-991", true);
        Calculator calc2 = new Calculator("Simple Calc", false);
        System.out.println(calc1.getCalculatorInfo());
        System.out.println("Может вычислять проценты: " + calc1.canCalculatePercentages());
        System.out.println("2 + 3 = " + calc1.add(2, 3));
        System.out.println("2 * 3 = " + calc1.multiply(2, 3));
        System.out.println(calc2.getCalculatorInfo());
        System.out.println("Может вычислять проценты: " + calc2.canCalculatePercentages());
        System.out.println("5 + 7 = " + calc2.add(5, 7));
        // Демонстрация изменения свойств
        calc2.setScientific(true);
        System.out.println("\nПосле изменения типа:");
        System.out.println(calc2.getCalculatorInfo());
        System.out.println("Может вычислять проценты: " + calc2.canCalculatePercentages());
        // Простые проверки вместо JUnit тестов
        System.out.println("\n=== Простые проверки ===");
        Calculator calc = new Calculator("Test", true);
        // Тест сложения
        boolean test1 = calc.add(2, 3) == 5;
        System.out.println("Тест сложения (2+3=5): " + (test1 ? "ПРОЙДЕН ✓" : "НЕ ПРОЙДЕН ✗"));
        // Тест умножения
        boolean test2 = calc.multiply(2, 3) == 6;
        System.out.println("Тест умножения (2*3=6): " + (test2 ? "ПРОЙДЕН ✓" : "НЕ ПРОЙДЕН ✗"));
        // Тест научного калькулятора
        boolean test3 = calc.canCalculatePercentages();
        System.out.println("Тест научного калькулятора: " + (test3 ? "ПРОЙДЕН ✓" : "НЕ ПРОЙДЕН ✗"));
        // Тест обычного калькулятора
        Calculator basicCalc = new Calculator("Basic", false);
        boolean test4 = !basicCalc.canCalculatePercentages();
        System.out.println("Тест обычного калькулятора: " + (test4 ? "ПРОЙДЕН ✓" : "НЕ ПРОЙДЕН ✗"));
        // Тест информации о калькуляторе
        String info = calc.getCalculatorInfo();
        boolean test5 = info.contains("Калькулятор: Test") && info.contains("научный");
        System.out.println("Тест информации о калькуляторе: " + (test5 ? "ПРОЙДЕН ✓" : "НЕ ПРОЙДЕН ✗"));
        System.out.println("\n" + (test1 && test2 && test3 && test4 && test5 ? 
            "Все тесты пройдены успешно! ✓" : "Некоторые тесты не пройдены"));
    
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

    public static void andreevaMethod(){
        String[] testPasswords = {
                "Weak1!", // слишком короткий
                "StrongPassword123", // нет специальных символов
                "qwerty123!@#", // содержит последовательность "qwe"
                "MySuperStrongP@ssw0rd!", // надежный пароль
                "abc123!@#", // слишком короткий
                "PasswordWith123Sequence!", // содержит "ord" (не запрещенная последовательность)
                "Test123qwe!", // содержит "qwe" - запрещенная последовательность
        };

        System.out.println("\n\nТестирование надежности паролей:\n");

        for (String pwd : testPasswords) {
            Password password = new Password(pwd);
            boolean isPowerful = password.isPowerful();

            System.out.println("Пароль: " + pwd);
            System.out.println("Надежный: " + (isPowerful ? "Да" : "Нет"));
        }
    }

    public static void main(String[] args) {
        bondarevMethod();
        mosolovaMethod();
        BartasevichMethod();
        testWallet();
        larinMethod();
        shulgaMethods();
        SimonenkoMetod();
        ValaevaMethod();
        sukhorukovMethod();
        andreevaMethod();
    }


}
   

