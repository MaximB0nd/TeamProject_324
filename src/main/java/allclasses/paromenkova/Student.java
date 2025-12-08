package allclasses.paromenkova;
import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String group;
    private double averageGrade;

    public Student(String firstName, String lastName, String birthDate, String group, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.group = group;
        this.averageGrade = averageGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGroup() {
        return group;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public boolean isExcellentStudent() {
        return averageGrade >= 4.5;
    }

    public String getFullInfo() {
        return String.format("Студент: %s %s, Группа: %s, Дата рождения: %s, Средний балл: %.2f",
                firstName, lastName, group, birthDate, averageGrade);
    }

    public void updateGrade(double newGrade) {
        if (newGrade >= 0 && newGrade <= 5) {
            this.averageGrade = newGrade;
        }
    }
}
