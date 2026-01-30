package allclasses.skulyabina;

public class student {
    private String name;
    private int age;
    private String group;

    public student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public void displayInfo() {
        System.out.println("Student: " + name + ", Age: " + age + ", Group: " + group);
    }

    public void study() {
        System.out.println(name + " is studying...");
    }
}

