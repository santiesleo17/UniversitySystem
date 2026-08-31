
---

# University Management System

A Java-based console application designed to manage university operations—including teachers, students, and classes—while demonstrating core Object-Oriented Programming (OOP) concepts.

---

## Features

* **Teacher Directory:** View all teachers (Full-Time and Part-Time) along with their calculated total salaries based on experience or active hours.
* **Class Explorer:** Display registered university classes and inspect specific class details (classroom, assigned teacher, and enrolled student roster).
* **Student Registration:** Register new students with auto-incrementing IDs and instantly enroll them into an existing class.
* **Class Creation:** Create new classes, assign a teacher, and select existing students for enrollment.
* **Student Class Lookup:** Search and list all classes associated with a specific student using their unique ID.

---

## Object-Oriented Programming (OOP) Principles Applied

* **Encapsulation:** Private attributes across all models (`Teacher`, `Student`, `UniversityClass`, `University`) accessed via public getters and setters.
* **Abstraction:** The abstract class `Teacher` hides base implementation details while declaring the abstract method `calculateSalary()`.
* **Inheritance:** `FullTimeTeacher` and `PartTimeTeacher` extend `Teacher`, inheriting shared properties like `name` and `BASE_SALARY` while providing custom salary calculations.
* **Polymorphism:** The system handles instances of `FullTimeTeacher` and `PartTimeTeacher` uniformly through the parent type `Teacher`.
* **Static Usage:** A `static` counter (`idCounter`) inside the `Student` class automatically generates unique, sequential student IDs across all instances.

---

## Architecture & Class Hierarchy

```
src/
├── Main.java                 # Program entry point and menu loop
├── UniversityController.java   # Handles business logic and user interaction
├── University.java           # Data container for teachers, students, and classes
├── UniversityClass.java      # Model representing a course/class
├── Student.java              # Model representing a student
├── Teacher.java              # Abstract base model for teachers
├── FullTimeTeacher.java      # Concrete class for full-time faculty
└── PartTimeTeacher.java      # Concrete class for part-time faculty

```

---

## Data Models Summary

| Class | Type | Key Attributes | Specific Rules |
| --- | --- | --- | --- |
| `Teacher` | Abstract | `name`, `BASE_SALARY` | Base salary set to a fixed constant ($2,000,000). |
| `FullTimeTeacher` | Subclass | `experienceYears` | **Salary:** $\text{BASE\_SALARY} \times (1.10 \times \text{experienceYears})$ |
| `PartTimeTeacher` | Subclass | `activeHoursPerWeek` | **Salary:** $\text{BASE\_SALARY} \times \text{activeHoursPerWeek}$ |
| `Student` | Model | `id`, `name`, `age` | `id` is auto-incremented via a `static` counter. |
| `UniversityClass` | Model | `name`, `classroom`, `students`, `teacher` | Contains a list of enrolled students and one assigned teacher. |

---

## Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE:** IntelliJ IDEA (recommended), Eclipse, or VS Code.

### Installation & Execution

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/UniversitySystem.git
cd UniversitySystem

```


2. **Open in IntelliJ IDEA:**
* Open IntelliJ IDEA and select **File > Open**, then choose the project folder.
* Ensure `src/` is marked as the **Sources Root** (Right-click `src` $\rightarrow$ **Mark Directory as** $\rightarrow$ **Sources Root**).
* Verify your JDK is set in **File > Project Structure > Project > SDK**.


3. **Run the Application:**
* Open `Main.java`.
* Click the green **Run (►)** icon or press `Ctrl + Shift + F10` (`Control + Shift + R` on macOS).



---

## Interactive Menu Options

1. **Mostrar profesores con sus datos:** Displays name, base salary, specific parameters (experience/hours), and calculated total salary.
2. **Mostrar clases y detalle de una clase:** Lists all active classes and opens a sub-prompt to inspect classroom and roster details.
3. **Crear un nuevo estudiante y agregarlo a una clase:** Prompts for student details, generates an ID, and attaches the student to a chosen class.
4. **Crear una nueva clase y asignar profesor y alumnos:** Interactively builds a new course with an existing teacher and selected students.
5. **Listar clases de un estudiante (por ID):** Filters and displays all classes matching a given student ID.
6. **Salir:** Terminates the application.