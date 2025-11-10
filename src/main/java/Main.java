import allclasses.bartasevich.Complex;
import allclasses.prokofev.WalletProkofev;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.sukhorukov.Calculator;

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
    public static void main(String[] args) {
        bondarevMethod();
        BartasevichMethod();
        testWallet();
        larinMethod();
	sukhorukovMethod();
    }
    
}
