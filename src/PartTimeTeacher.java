public class PartTimeTeacher extends Teacher{

    private double activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, double activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * this.activeHoursPerWeek;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", Type: Part time" + '\'' +
                ", Hours: " + activeHoursPerWeek;
    }
}
