import java.math.BigDecimal;

import allclasses.andreeva.Password;
import allclasses.bartasevich.Complex;
import allclasses.bondarev.Mark;
import allclasses.ivanova.Pizza;
import allclasses.larin.Book;
import allclasses.martyshev.Person;
import allclasses.mosolova.Rectangle;
import allclasses.paromenkova.Student;
import allclasses.povelichenko.meme;
import allclasses.prokofev.WalletProkofev;

import allclasses.shulga.Triangle;


import allclasses.valaeva.Cat;
import allclasses.volkova.House;


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
        System.out.println();
        meme.printRandomMeme();

        System.out.println();
        System.out.println("Отдельно фраза: " + meme.getRandomPhrase());
        System.out.println("Отдельно звук: " + meme.getRandomSound());
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
        ValaevaMethod();

        IvanovaMethod();
        andreevaMethod();
        paromenkovaMetod();
        povelichenkomethod();
    }


}


