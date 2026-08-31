package controller;

import model.*;

import java.util.*;

public class UniversityController implements IUniversityController {
    private final University icesi;

    public UniversityController(University icesi) {
        this.icesi = icesi;
    }

    public void initData() {
        // 1. Initialize teachers
        Teacher teacher1 = new FullTimeTeacher("Santiago Escobar", 5);
        Teacher teacher2 = new FullTimeTeacher("Silvana Gómez", 8);
        Teacher teacher3 = new PartTimeTeacher("Juan David Calderón", 20);
        Teacher teacher4 = new PartTimeTeacher("Camilo Torres", 15);

        icesi.addTeacher(teacher1);
        icesi.addTeacher(teacher2);
        icesi.addTeacher(teacher3);
        icesi.addTeacher(teacher4);

        // 2. Initialize students
        Student student1 = new Student("Salomé Escobar", 17);
        Student student2 = new Student("Maria León", 20);
        Student student3 = new Student("Fabio Escobar", 22);
        Student student4 = new Student("Kiara Escobar", 18);
        Student student5 = new Student("Alejandra León", 21);
        Student student6 = new Student("Juan León", 17);

        icesi.addStudent(student1);
        icesi.addStudent(student2);
        icesi.addStudent(student3);
        icesi.addStudent(student4);
        icesi.addStudent(student5);
        icesi.addStudent(student6);

        // 3. Students list
        List<Student> class1Students = new ArrayList<>(Arrays.asList(student1, student2));
        List<Student> class2Students = new ArrayList<>(Arrays.asList(student3, student4));
        List<Student> class3Students = new ArrayList<>(Arrays.asList(student5, student6));
        List<Student> class4Students = new ArrayList<>(Arrays.asList(student1, student3, student5));

        // 4. Classes
        UniversityClass class1 = new UniversityClass("Matemáticas Discretas", "AULA-101", class1Students, teacher1);
        UniversityClass class2 = new UniversityClass("Programación Java", "LAB-202", class2Students, teacher2);
        UniversityClass class3 = new UniversityClass("Bases de Datos", "LAB-203", class3Students, teacher3);
        UniversityClass class4 = new UniversityClass("Estructuras de Datos", "AULA-104", class4Students, teacher4);

        icesi.addClass(class1);
        icesi.addClass(class2);
        icesi.addClass(class3);
        icesi.addClass(class4);
    }

    //Print all teachers with details (Option 4a)
    public void printAllProfessors() {
        System.out.println("\n*** LISTA DE PROFESORES ***");
        for (Teacher teacher : icesi.getTeachers()) {
            System.out.println(teacher);
        }
    }

    //Show classes and submenu to see details (Option 4b)
    public void printClassesMenu(Scanner scanner) {
        List<UniversityClass> classes = icesi.getClasses();
        System.out.println("\n*** LISTA DE CLASES ***");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getName());
        }

        System.out.print("\nIngrese el número de la clase para ver sus detalles (o 0 para regresar): ");
        if (scanner.hasNextInt()) {
            int selectedIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (selectedIndex >= 0 && selectedIndex < classes.size()) {
                UniversityClass uClass = classes.get(selectedIndex);
                System.out.println("\n*** DETALLES DE LA CLASE ***");
                System.out.println("Nombre: " + uClass.getName());
                System.out.println("Aula: " + uClass.getClassroom());
                System.out.println("Profesor: " + uClass.getTeacher().getName());
                System.out.println("Estudiantes inscritos:");
                for (Student student : uClass.getStudents()) {
                    System.out.println("  - " + student.toString());
                }
            } else if (selectedIndex != -1) {
                System.out.println("Número de clase inválido.");
            }
        } else {
            System.out.println("Entrada no válida.");
            scanner.nextLine();
        }
    }

    //Create a new student and assign the student to an existing class (Option 4c)
    public void createNewStudent(Scanner scanner) {
        System.out.println("\n*** REGISTRAR NUEVO ESTUDIANTE ***");
        System.out.print("Ingrese el nombre del estudiante: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int age = 0;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Edad inválida. Operación cancelada.");
            scanner.nextLine();
            return;
        }

        //Create the student and add to the model.University
        Student newStudent = new Student(name, age);
        icesi.addStudent(newStudent);

        //Select a class for the student
        List<UniversityClass> classes = icesi.getClasses();
        System.out.println("\nSeleccione la clase a la que desea inscribir al estudiante:");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getName());
        }

        System.out.print("Número de clase: ");
        if (scanner.hasNextInt()) {
            int classIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (classIndex >= 0 && classIndex < classes.size()) {
                classes.get(classIndex).getStudents().add(newStudent);
                System.out.println("¡Estudiante creado y agregado exitosamente a " + classes.get(classIndex).getName() + "!");
            } else {
                System.out.println("Clase no encontrada. El estudiante fue guardado pero no se asignó a ninguna clase.");
            }
        } else {
            System.out.println("Entrada no válida.");
            scanner.nextLine();
        }
    }

    //Create a new class and assign an existing teacher and students (Option 4d)
    public void createNewClass(Scanner scanner) {
        System.out.println("\n--- CREAR NUEVA CLASE ---");
        System.out.print("Ingrese el nombre de la materia: ");
        String className = scanner.nextLine();

        System.out.print("Ingrese el aula asignada: ");
        String classroom = scanner.nextLine();

        // Assign teacher
        List<Teacher> teachers = icesi.getTeachers();
        System.out.println("\nSeleccione el profesor para esta clase:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getName());
        }

        System.out.print("Número de profesor: ");
        int teacherIndex = -1;
        if (scanner.hasNextInt()) {
            teacherIndex = scanner.nextInt() - 1;
            scanner.nextLine();
        } else {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
            return;
        }

        if (teacherIndex < 0 || teacherIndex >= teachers.size()) {
            System.out.println("Profesor no válido. Cancelando creación de clase.");
            return;
        }
        Teacher selectedTeacher = teachers.get(teacherIndex);

        // Select and assign existing students
        List<Student> allStudents = icesi.getStudents();
        List<Student> classStudents = new ArrayList<>();

        System.out.println("\nSeleccione los estudiantes a incluir (ingrese el número o 0 para terminar):");
        while (true) {
            for (int i = 0; i < allStudents.size(); i++) {
                System.out.println((i + 1) + ". " + allStudents.get(i).getName() + " (ID: " + allStudents.get(i).getId() + ")");
            }
            System.out.print("Número de estudiante a agregar (0 para finalizar): ");

            if (scanner.hasNextInt()) {
                int studentIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                if (studentIndex == -1) {
                    break; // Finish selection
                }

                if (studentIndex >= 0 && studentIndex < allStudents.size()) {
                    Student selectedStudent = allStudents.get(studentIndex);
                    if (!classStudents.contains(selectedStudent)) {
                        classStudents.add(selectedStudent);
                        System.out.println("-> " + selectedStudent.getName() + " agregado.");
                    } else {
                        System.out.println("El estudiante ya está en la lista.");
                    }
                } else {
                    System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("Entrada no válida.");
                scanner.nextLine();
            }
        }

        // Save new class
        UniversityClass newClass = new UniversityClass(className, classroom, classStudents, selectedTeacher);
        icesi.addClass(newClass);
        System.out.println("¡Clase '" + className + "' creada exitosamente!");
    }

    // Search and list classes in which a student is enrolled by ID (Option 4e)
    public void searchClassesByStudentId(Scanner scanner) {
        System.out.println("\n*** BUSCAR CLASES POR ID DE ESTUDIANTE ***");
        System.out.print("Ingrese el ID del estudiante: ");

        if (scanner.hasNextInt()) {
            int studentId = scanner.nextInt();
            scanner.nextLine();

            List<UniversityClass> enrolledClasses = new ArrayList<>();

            for (UniversityClass uClass : icesi.getClasses()) {
                for (Student student : uClass.getStudents()) {
                    if (student.getId() == studentId) {
                        enrolledClasses.add(uClass);
                        break;
                    }
                }
            }

            if (enrolledClasses.isEmpty()) {
                System.out.println("No se encontraron clases para el estudiante con ID " + studentId);
            } else {
                System.out.println("El estudiante con ID " + studentId + " está inscrito en:");
                for (UniversityClass uClass : enrolledClasses) {
                    System.out.println("  - " + uClass.getName() + " (Aula: " + uClass.getClassroom() + ")");
                }
            }
        } else {
            System.out.println("ID inválido.");
            scanner.nextLine();
        }
    }
}