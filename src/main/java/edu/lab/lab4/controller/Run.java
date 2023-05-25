package edu.lab.lab4.controller;

import edu.lab.lab4.model.*;

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

        university.saveToJsonFile("university.json");

        University loadedUniversity = University.loadFromJsonFile("university.json");

        University oldUniversity = createOldUniversity();
        boolean isEqual = oldUniversity.equals(loadedUniversity);
        System.out.println("Are universities equal? " + isEqual);
    }

    private static University createOldUniversity() {
        University university = new University("Old University", new Human("", "", "", Sex.MALE));

        for (int i = 0; i < 2; i++) {
            Faculty faculty = new Faculty("Faculty " + (i + 1), new Human("", "", "", Sex.FEMALE));
            university.addFaculty(faculty);

            for (int j = 0; j < 2; j++) {
                Department department = new Department("Department " + (j + 1), new Human("", "", "", Sex.MALE));
                faculty.addDepartment(department);

                for (int k = 0; k < 2; k++) {
                    String groupName = "Group " + (k + 1);
                    Student student1 = StudentCreator.createStudent("Student", "Lastname", "", Sex.MALE, groupName);
                    Student student2 = StudentCreator.createStudent("Student", "Lastname", "", Sex.FEMALE, groupName);
                    department.addStudent(student1);
                    department.addStudent(student2);
                }
            }
        }

        return university;
    }

}