package edu.lab.lab3.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Human head;
    private List<Student> students;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
