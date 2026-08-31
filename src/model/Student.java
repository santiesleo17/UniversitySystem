package model;

public class Student {
    // Static counter to generate unique auto-incrementing IDs for all students
    private static int idCounter = 1;
    private String name;
    private int id;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.id = idCounter++;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nombre: " + name +
                ", id: " + id +
                ", edad: " + age;
    }

    public String getName() { return name; }

    public int getId() { return id; }
}
