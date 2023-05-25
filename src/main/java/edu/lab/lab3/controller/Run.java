package edu.lab.lab3.controller;

import edu.lab.lab3.model.*;

public class Run {
    public static void createTypicalUniversity() {
        Human universityHead = new Human("John", "Doe", "", Sex.MALE);
        University university = new University("Example University", universityHead);

        Human facultyHead = new Human("Jane", "Smith", "", Sex.FEMALE);
        Faculty faculty = new Faculty("Faculty of Science", facultyHead);
        university.addFaculty(faculty);

        Human departmentHead = new Human("Mark", "Johnson", "", Sex.MALE);
        Department department = new Department("Physics Department", departmentHead);
        faculty.addDepartment(department);

        Student student1 = StudentCreator.createStudent("Alice", "Johnson", "", Sex.FEMALE, "Group A");
        Student student2 = StudentCreator.createStudent("Bob", "Smith", "", Sex.MALE, "Group B");
        department.addStudent(student1);
        department.addStudent(student2);

        System.out.println("University: " + university.getName());
        System.out.println("University Head: " + university.getHead().getFullName());
        System.out.println("Faculties: " + university.getFaculties().size());
    }
}

