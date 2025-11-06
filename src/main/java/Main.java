package allclasses.martyshev;



public class Main {
    public static void martyshevMethod() {
        SomeClass.Person person = new SomeClass.Person("Иван", 22);
        person.sayHello();
        System.out.println("Через 5 лет ему будет: " + person.getAgeInFiveYears());
    }

    public static void main(String[] args) {
        martyshevMethod();
    }
}
