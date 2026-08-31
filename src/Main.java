import controller.IUniversityController;
import controller.UniversityController;
import model.University;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        University university = new University();

        IUniversityController controller = new UniversityController(university);

        controller.initData();

        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 6) {
            System.out.println("\n*** BIENVENIDO AL SISTEMA UNIVERSITARIO ***");
            System.out.println("1. Mostrar profesores con sus datos");
            System.out.println("2. Mostrar clases y detalle de una clase");
            System.out.println("3. Crear un nuevo estudiante y agregarlo a una clase");
            System.out.println("4. Crear una nueva clase y asignar profesor y alumnos");
            System.out.println("5. Listar clases de un estudiante (por ID)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        controller.printAllProfessors();
                        break;
                    case 2:
                        controller.printClassesMenu(scanner);
                        break;
                    case 3:
                        controller.createNewStudent(scanner);
                        break;
                    case 4:
                        controller.createNewClass(scanner);
                        break;
                    case 5:
                        controller.searchClassesByStudentId(scanner);
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema! Hasta luego.");
                        break;
                    default:
                        System.out.println("Opción inválida, intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar entrada errónea
            }
        }

        scanner.close();
    }
}