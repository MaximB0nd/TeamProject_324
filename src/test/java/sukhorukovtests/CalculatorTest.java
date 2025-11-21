package sukhorukovtests;
import allclasses.sukhorukov.Calculator;

public class CalculatorTest {
    
    public void testAdd() {
        Calculator calc = new Calculator("Test", true);
        assert calc.add(2.0, 3.0) == 5.0 : "Сложение работает неправильно";
        assert calc.add(-2.0, 2.0) == 0.0 : "Сложение с отрицательными числами работает неправильно";
        System.out.println("✓ testAdd пройден");
    }
    
    public void testMultiply() {
        Calculator calc = new Calculator("Test", true);
        assert calc.multiply(2.0, 3.0) == 6.0 : "Умножение работает неправильно";
        assert calc.multiply(5.0, 0.0) == 0.0 : "Умножение на ноль работает неправильно";
        System.out.println("✓ testMultiply пройден");
    }
    
    public void testCanCalculatePercentages() {
        Calculator scientificCalc = new Calculator("Scientific", true);
        Calculator basicCalc = new Calculator("Basic", false);
        
        assert scientificCalc.canCalculatePercentages() : "Научный калькулятор должен уметь вычислять проценты";
        assert !basicCalc.canCalculatePercentages() : "Обычный калькулятор не должен уметь вычислять проценты";
        System.out.println("✓ testCanCalculatePercentages пройден");
    }
    
    public void testGetCalculatorInfo() {
        Calculator calc = new Calculator("Casio FX-991", true);
        String expected = "Калькулятор: Casio FX-991, тип: научный";
        String actual = calc.getCalculatorInfo();
        assert actual.equals(expected) : "Информация о калькуляторе не совпадает. Ожидалось: " + expected + ", получено: " + actual;
        System.out.println("✓ testGetCalculatorInfo пройден");
    }
    
    public void testSettersAndGetters() {
        Calculator calc = new Calculator("Old Model", false);
        calc.setModel("New Model");
        calc.setScientific(true);
        
        assert calc.getModel().equals("New Model") : "Сеттер/геттер для model работает неправильно";
        assert calc.getAge() == 21 : "Сеттер/геттер для age работает неправильно";
        assert calc.isScientific() : "Сеттер/геттер для isScientific работает неправильно";
        System.out.println("✓ testSettersAndGetters пройден");
    }
    
    // Метод для запуска всех тестов
    public static void runAllTests() {
        CalculatorTest test = new CalculatorTest();
        System.out.println("Запуск всех тестов Calculator:");
        
        test.testAdd();
        test.testMultiply();
        test.testCanCalculatePercentages();
        test.testGetCalculatorInfo();
        test.testSettersAndGetters();
        
        System.out.println("Все тесты пройдены успешно! ✓");
    }
}
