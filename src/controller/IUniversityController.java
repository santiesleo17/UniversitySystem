package controller;

import java.util.Scanner;

public interface IUniversityController {
    void initData();
    void printAllProfessors();
    void printClassesMenu(Scanner scanner);
    void createNewStudent(Scanner scanner);
    void createNewClass(Scanner scanner);
    void searchClassesByStudentId(Scanner scanner);
}