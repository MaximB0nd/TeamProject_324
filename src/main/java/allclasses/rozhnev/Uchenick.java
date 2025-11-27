package allclasses.rozhnev;

public class Uchenick {
    private final String firstName;
    private final String lastName;
    private int gradeLevel;
    private int completedAssignments;
    private double totalScore;

    public Uchenick(String firstName, String lastName, int gradeLevel) {
        if (gradeLevel < 1) {
            throw new IllegalArgumentException("Grade level must be positive");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public int getCompletedAssignments() {
        return completedAssignments;
    }

    public double getAverageScore() {
        return completedAssignments == 0 ? 0.0 : totalScore / completedAssignments;
    }

    public void addResult(double score) {
        if (score < 0 || score > 5) {
            throw new IllegalArgumentException("Score must be between 0 and 5");
        }
        totalScore += score;
        completedAssignments++;
    }

    public void promote() {
        gradeLevel++;
    }

    public boolean isExcellent() {
        return getAverageScore() >= 4.5 && completedAssignments > 0;
    }

    public String getInfo() {
        return String.format("%s %s, класс: %d, средний балл: %.2f", firstName, lastName, gradeLevel, getAverageScore());
    }
}