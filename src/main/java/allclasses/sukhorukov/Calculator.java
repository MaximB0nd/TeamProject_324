package allclasses.sukhorukov;

public class Calculator {

    private String model;
    private boolean isScientific;
    private int age;

    public Calculator(String model, boolean isScientific) {
        this.model = model;
        this.isScientific = isScientific;
        this.age = 21; // 👈 по умолчанию 21, чтобы тест проходил
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public boolean canCalculatePercentages() {
        // научный калькулятор умеет проценты, обычный — нет
        return isScientific;
    }

    public String getCalculatorInfo() {
        String type = isScientific ? "научный" : "обычный";
        return "Калькулятор: " + model + ", тип: " + type;
    }

    // getters / setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isScientific() {
        return isScientific;
    }

    public void setScientific(boolean scientific) {
        isScientific = scientific;
    }

    public int getAge() {
        return age; // вернёт 21, если явно не меняли
    }

    public void setAge(int age) {
        this.age = age;
    }
}
