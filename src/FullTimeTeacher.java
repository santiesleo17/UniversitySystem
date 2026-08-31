public class FullTimeTeacher extends Teacher{

    private double experienceYears;

    public FullTimeTeacher(String name, double experienceYears) {
        super(name);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return getBASE_SALARY() * (1.10 * this.experienceYears);
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", Type: Full time" + '\'' +
                ", Experience: " + experienceYears + "year(s)";
    }
}
