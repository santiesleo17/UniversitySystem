public abstract class Teacher {
    private String name;
    private final double BASE_SALARY = 2000000;

    public Teacher(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public String getName() { return name; }

    public double getBASE_SALARY() { return BASE_SALARY; }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", Base salary: $" + BASE_SALARY + '\'' +
                ", Total salary: $" + calculateSalary();
    }
}
