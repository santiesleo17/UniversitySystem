public class FullTimeTeacher extends Teacher{

    private double experienceYears;

    public FullTimeTeacher(String name, double baseSalary, double experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * (1.10 * this.experienceYears);
    }
/**
    public String toString() {
        return "Name: " + name + '\'' +
                ", Base salary: $" + baseSalary + '\'' +
                ", Total salary: $" + calculateSalary();
    }**/

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", Type: Full time" + '\'' +
                ", Experience: " + experienceYears + "year(s)";
    }
}
