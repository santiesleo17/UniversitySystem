package model;

public class PartTimeTeacher extends Teacher{
    //Part Time Teachers have active hours per week
    private double activeHoursPerWeek;

    public PartTimeTeacher(String name, double activeHoursPerWeek) {
        super(name);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBASE_SALARY() * this.activeHoursPerWeek;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", Tipo: Tiempo parcial" + '\'' +
                ", Horas: " + activeHoursPerWeek;
    }
}
