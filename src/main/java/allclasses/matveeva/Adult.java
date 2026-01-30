package allclasses.matveeva;

public class Adult {
    private String name;
    private int age;

    public Adult(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getGreeting() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}