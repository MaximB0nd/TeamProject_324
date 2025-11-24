package allclasses.kukushkin;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Integer> grades;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades); // возвращаем копию для защиты от изменений
    }

    // Методы для работы с оценками
    public void addGrade(int grade) {
        if (grade < 1 || grade > 10) {
            throw new IllegalArgumentException("Grade must be between 1 and 10");
        }
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean isExcellentStudent() {
        return calculateAverageGrade() >= 8.5;
    }

    public boolean hasGrade(int grade) {
        return grades.contains(grade);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grades=" + grades + "}";
    }
}