package allclasses.sukhorukov;

public class Calculator {
    private String model;
    private boolean isScientific;
    private int age;
    
    public Calculator(String model, boolean isScientific) {
        this.model = model;
        this.isScientific = isScientific;
        this.age = 0;
    }
    
    // Метод сложения
    public double add(double a, double b) {
        return a + b;
    }
    
    // Метод умножения
    public double multiply(double a, double b) {
        return a * b;
    }
    
    // Метод проверки, может ли калькулятор вычислять проценты
    public boolean canCalculatePercentages() {
        return isScientific;
    }
    
    // Метод для получения информации о калькуляторе
    public String getCalculatorInfo() {
        String type = isScientific ? "научный" : "обычный";
        return String.format("Калькулятор: %s, тип: %s", model, type);
    }
    
    // Геттеры и сеттеры
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public boolean isScientific() { return isScientific; }
    public void setScientific(boolean scientific) { isScientific = scientific; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
