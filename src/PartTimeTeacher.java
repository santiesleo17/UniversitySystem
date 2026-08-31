public class PartTimeTeacher extends Teacher{

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
                ", Type: Part time" + '\'' +
                ", Hours: " + activeHoursPerWeek;
    }
}
