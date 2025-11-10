package allclasses.martyshev;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Привет, меня зовут " + name + ", мне " + age + " лет.");
    }

    public int getAgeInFiveYears() {
        return age + 5;
    }
}
