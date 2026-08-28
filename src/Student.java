public class Student {
    private static int idCounter = 1;
    private String name;
    private int id;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.id = idCounter++;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
