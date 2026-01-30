import allclasses.prokofev.WalletProkofev;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.karenin.KareninRectangle;

public class Main {
    static void bondarevMethod() {
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

    public static void kareninMethod() {
        System.out.println("=== Демонстрация работы класса Rectangle (Karenin) ===\n");

        // Создаем несколько прямоугольников
        System.out.println("1. Создание прямоугольников:");
        KareninRectangle rect1 = new KareninRectangle(3.0, 4.0);
        KareninRectangle rect2 = new KareninRectangle(5.0, 5.0); // квадрат
        KareninRectangle rect3 = new KareninRectangle(2.5, 6.0);

        System.out.println("   " + rect1);
        System.out.println("   " + rect2);
        System.out.println("   " + rect3);

        // Демонстрация методов
        System.out.println("\n2. Расчет характеристик прямоугольников:");

        System.out.println("\n   Прямоугольник 1 (3x4):");
        System.out.println("   - Площадь: " + rect1.getArea());
        System.out.println("   - Периметр: " + rect1.getPerimeter());
        System.out.println("   - Диагональ: " + rect1.getDiagonal());
        System.out.println("   - Квадрат? " + rect1.isSquare());

        System.out.println("\n   Прямоугольник 2 (5x5):");
        System.out.println("   - Площадь: " + rect2.getArea());
        System.out.println("   - Периметр: " + rect2.getPerimeter());
        System.out.println("   - Диагональ: " + rect2.getDiagonal());
        System.out.println("   - Квадрат? " + rect2.isSquare());

        // Демонстрация масштабирования
        System.out.println("\n3. Масштабирование:");
        KareninRectangle scaledRect = rect1.scale(2.0);
        System.out.println("   Исходный: " + rect1);
        System.out.println("   Увеличенный в 2 раза: " + scaledRect);
        System.out.println("   Площадь увеличилась с " + rect1.getArea() + " до " + scaledRect.getArea());

        // Демонстрация обработки исключений
        System.out.println("\n4. Обработка исключений:");

        try {
            System.out.println("   Попытка создать прямоугольник с нулевой шириной:");
            new KareninRectangle(0, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("   Попытка масштабировать с коэффициентом 0:");
            rect1.scale(0);
        } catch (IllegalArgumentException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Демонстрация завершена ===");
    }

    public static void main(String[] args) {
        bondarevMethod();
        testWallet();
        larinMethod();
        kareninMethod();
    }
}
