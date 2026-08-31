package model;

public class FullTimeTeacher extends Teacher{
    // Full time teachers have experience years
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
                ", Tipo: Tiempo completo" + '\'' +
                ", Experiencia: " + experienceYears + "año(s)";
    }
}
