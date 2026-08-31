public abstract class Teacher {
    private String name;

    // The requirements doesn´t mention that the base salary should be edited, so in this release we can´t modify it.
    private final double BASE_SALARY = 2000000;

    public Teacher(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public String getName() { return name; }

    public double getBASE_SALARY() { return BASE_SALARY; }

    @Override
    public String toString() {
        return "Nombre: " + name + '\'' +
                ", Salario base: $" + BASE_SALARY + '\'' +
                ", Salario total: $" + calculateSalary();
    }
}
