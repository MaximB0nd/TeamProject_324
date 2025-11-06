package allclasses.valaeva;


public class Cat {
    protected String name;
    protected int age;
    protected double weight;
    protected String color;


    public Cat(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }


    public String getInfo() {
        return "Кот: " + name + ", возраст: " + age + " лет, вес: " + weight + " кг, цвет: " + color;
    }

    // Простые методы
    public String eat() {
        return name + " кушает";
    }

    public String sleep() {
        return name + " спит";
    }


    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    public boolean isFat() {
        return weight > 6.0;
    }

    public String getColorInfo() {
        return name + " имеет " + color + " цвет";
    }
}