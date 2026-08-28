import java.util.List;

//  Each class has a name, an
//assigned classroom, a list of students and a teacher.
public class UniversityClass {
    private String name;
    private String classroom;
    private List<Student> students;
    private Teacher teacher;


    public UniversityClass(String name, String classroom, List<Student> students, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
    }
}
