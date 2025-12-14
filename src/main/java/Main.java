import allclasses.golubev.Piano;
import allclasses.prokudin.Fraction;
import allclasses.mosolova.Rectangle;
import allclasses.bartasevich.Complex;
import allclasses.prokofev.WalletProkofev;
import allclasses.martyshev.Person;
import java.math.BigDecimal;
import allclasses.larin.Book;
import allclasses.volkova.House;
import allclasses.bondarev.Mark;
import allclasses.shulga.Triangle;
import allclasses.simonenko.Fractions;
import allclasses.valaeva.Cat;
import allclasses.sukhorukov.Calculator;
import allclasses.ivanova.Pizza;
import allclasses.andreeva.Password;
import allclasses.paromenkova.Student;
import allclasses.povelichenko.meme;
import allclasses.skulyabina.student;
import allclasses.isakov.Parrot;


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

    static void volkovaMethod() {
        System.out.println("\n*************** Testing House Volkova ***************");
        System.out.println("Test work house class:");

        House firstHouse = new House("ул. Ленина, 10", 2, 85.5, "белый");
        // Выводим результаты методов
        System.out.println(firstHouse.build());
        System.out.println(firstHouse.renovate());

        House secondHouse = new House("ул. Центральная, 25", 3, 150.8, "желтый");
        // Выводим результаты методов
        System.out.println(secondHouse.build());
        System.out.println(secondHouse.renovate());
        System.out.println(secondHouse.renovate());

        // Дополнительня информация о домах
        System.out.println("\nИнформация о домах:");
        System.out.println(firstHouse.getInfo());
        System.out.println(secondHouse.getInfo());
        System.out.println("Первый дом большой? " + firstHouse.isBig());
        System.out.println("Второй дом большой? " + secondHouse.isBig());
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
    static void MartyshevMethod() {
        Person p = new Person("Иван", 20);

        System.out.println("\n=== Тест Мартышева ===");

        p.sayHello();

        System.out.println("Возраст через 5 лет: " + p.getAgeInFiveYears());
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

    public static void paromenkovaMetod(){
        Student student1 = new Student("Иван", "Петров", "15.05.2000", "ИТ-21", 4.7);
        Student student2 = new Student("Мария", "Иванова", "22.08.2001", "ИТ-22", 4.2);
        Student student3 = new Student("Алексей", "Сидоров", "10.12.1999", "ИТ-23", 4.9);

        System.out.println("\n\n\n=== ИНФОРМАЦИЯ О СТУДЕНТАХ ===");
        System.out.println(student1.getFullInfo());
        System.out.println(student2.getFullInfo());
        System.out.println(student3.getFullInfo());

        System.out.println("\n=== СТАТУС ОТЛИЧНИКА ===");
        checkExcellentStatus(student1);
        checkExcellentStatus(student2);
        checkExcellentStatus(student3);

        System.out.println("\n=== ОБНОВЛЕНИЕ ОЦЕНКИ ===");
        System.out.println("До обновления: " + student2.getFullInfo());
        student2.updateGrade(4.6);
        System.out.println("После обновления: " + student2.getFullInfo());
        checkExcellentStatus(student2);
    }

    private static void checkExcellentStatus(Student student) {
        if (student.isExcellentStudent()) {
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - отличник! Средний балл: " + student.getAverageGrade());
        } else {
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - не отличник. Средний балл: " + student.getAverageGrade());
        }
    }

    public static void IvanovaMethod() {
        System.out.println("Демонстрация работы класса Pizza:");

        Pizza pizza = new Pizza("medium", 2, true);

        System.out.println("Размер: " + pizza.getSize());
        System.out.println("Топпингов: " + pizza.getToppings());
        System.out.println("Сырный бортик: " + pizza.hasCheeseCrust());
        System.out.println("Калорийность: " + pizza.getCalories());

        pizza.addTopping();
        System.out.println("Добавили топпинг!");
        System.out.println("Теперь топпингов: " + pizza.getToppings());
        System.out.println("Новая калорийность: " + pizza.getCalories());
    }

    public static void povelichenkomethod() {
        meme.printRandomMeme();

        System.out.println();
        System.out.println("Отдельно фраза: " + meme.getRandomPhrase());
        System.out.println("Отдельно звук: " + meme.getRandomSound());
    }

    public static void SkulyabinaMetod() {
        System.out.println("=== Тестирование класса Student ===\n");

        // Создание студентов
        student student1 = new student("Иван Иванов", 20, "CS-101");
        student student2 = new student("Петр", -5, "AB-12");
        student student3 = new student("", 18, "Group-A");
        student student4 = new student("Анна", 21, null);

        System.out.println("Студент 1: " + student1);
        System.out.println("Студент 2: " + student2);
        System.out.println("Студент 3: " + student3);
        System.out.println("Студент 4: " + student4);
        System.out.println();

        // Тест отображения информации
        System.out.println("--- Тест displayInfo() ---");
        System.out.println("Информация о студенте 1:");
        student1.displayInfo();
        System.out.println();

        // Тест метода study()
        System.out.println("--- Тест study() ---");
        System.out.println("Студент 1 учится:");
        student1.study();
        System.out.println("Студент 3 (с пустым именем) учится:");
        student3.study();
        System.out.println();

        // Тест с null группой
        System.out.println("--- Тест с null группой ---");
        System.out.println("Информация о студенте 4 (группа = null):");
        student4.displayInfo();
        System.out.println();

        // Тест сравнения студентов
        System.out.println("--- Тест сравнения студентов ---");
        student student5 = new student("Иван Иванов", 20, "CS-101");
        System.out.println("Создан студент 5 с такими же данными как студент 1");
        System.out.println("Студент 1 и студент 5 должны иметь одинаковые поля");
        System.out.println();

        // Тест создания студентов с разными параметрами
        System.out.println("--- Тест создания студентов ---");
        System.out.println("Все студенты успешно созданы:");
        System.out.println("1. Нормальный студент");
        System.out.println("2. С отрицательным возрастом");
        System.out.println("3. С пустым именем");
        System.out.println("4. С null группой");
        System.out.println();

        // Вывод через reflection (аналог тестов полей)
        try {
            System.out.println("--- Проверка полей через reflection ---");

            java.lang.reflect.Field nameField = student1.getClass().getDeclaredField("name");
            java.lang.reflect.Field ageField = student1.getClass().getDeclaredField("age");
            java.lang.reflect.Field groupField = student1.getClass().getDeclaredField("group");

            nameField.setAccessible(true);
            ageField.setAccessible(true);
            groupField.setAccessible(true);

            System.out.println("Поля студента 1:");
            System.out.println("Имя: " + nameField.get(student1));
            System.out.println("Возраст: " + ageField.get(student1));
            System.out.println("Группа: " + groupField.get(student1));

        } catch (Exception e) {
            System.out.println("Ошибка при доступе к полям: " + e.getMessage());
        }
    }

    static void isakovMethod() {
        System.out.println("\n=== Testing Parrot Isakov ===");

        Parrot parrot = new Parrot("Кеша", 3);

        System.out.println("Имя попугая: " + parrot.getName());
        System.out.println("Возраст попугая: " + parrot.getAge());

        System.out.println("Проверка метода say():");
        parrot.say("Привет!");
        parrot.say("Я умный попугай!");
    }
    public static void golubevMethod(){
        System.out.println("\n=== Testing Piano Golubev ===");

        Piano piano1 = new Piano(6);

        System.out.println("Громкость пианино1: " + piano1.getVolume());

        System.out.println("Проверка метода increaseVolume():");
        piano1.increaseVolume();
        System.out.println("Громкость пианино1: " + piano1.getVolume());
        Piano piano2 = new Piano(15);
        System.out.println("Громкость пианино2: " + piano2.getVolume());
        System.out.println("Проверка метода setVolume():");
        piano2.setVolume(9);
        System.out.println("Громкость пианино2: " + piano2.getVolume());


    }


    public static void main(String[] args) {
        bondarevMethod();
        mosolovaMethod();
        BartasevichMethod();
        testWallet();
        larinMethod();
        volkovaMethod();
        MartyshevMethod();
        shulgaMethods();
        SimonenkoMetod();
        ValaevaMethod();
        sukhorukovMethod();
        IvanovaMethod();
        andreevaMethod();
        paromenkovaMetod();
        povelichenkomethod();
        prokudinMethod();
        SkulyabinaMetod();
        isakovMethod();
        golubevMethod();
    }
}


