import java.math.BigDecimal;
import allclasses.nikiforov.CalculatorFirst;


public class Main
{
    static void bondarevMethod() {
        System.out.println("asdasd");
    }
    


    static void nikiforovMethod() {
        System.out.println("########Тестирование работы класса CalculatorFirst:########");

        CalculatorFirst firstCalc = new CalculatorFirst();
        int sum   = firstCalc.add(10, 5);
        int sub   = firstCalc.subtract(10, 5);
        int multi = firstCalc.multiply(10, 5);
        double div   = firstCalc.divide(10, 5);

        System.out.printf("First calc results - sum: %d; sub: %d; multi: %d; div: %d",
                sum,
                sub,
                multi,
                div
        );

        CalculatorFirst secondCalc = new CalculatorFirst();
        secondCalc.add(20, 10);
        secondCalc.divide(20, 4);
        secondCalc.divide(20, 2);
        System.out.println("################Успех!################");
    }

    public static void main(String[] args) {
        nikiforovMethod();
    }
}
