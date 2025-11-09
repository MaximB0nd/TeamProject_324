import allclasses.Simonenko.Fractions;

    public class Main {
        public static void main(String[] args) {
            SimonenkoMetod();
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
        }
