import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<UniversityClass> classes = new ArrayList<>();

    public University() {
    }

    public void addTeacher(Teacher teacher) { this.teachers.add(teacher); }
    public void addStudent(Student student) { this.students.add(student); }
    public void addClass(UniversityClass uClass) { this.classes.add(uClass); }

    public List<Teacher> getTeachers() { return teachers; }
    public List<Student> getStudents() { return students; }
    public List<UniversityClass> getClasses() { return classes; }
}