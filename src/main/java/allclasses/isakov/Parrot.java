package allclasses.isakov;

public class Parrot {
    private String name;
    private int age; // в годах

    public Parrot(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void say(String phrase) {
        System.out.println(name + " говорит: " + phrase);
    }
}
