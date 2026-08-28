public abstract class Teacher {
    private String name;
    private double baseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\'' +
                ", Base salary: $" + baseSalary + '\'' +
                ", Total salary: $" + calculateSalary();
    }
}
