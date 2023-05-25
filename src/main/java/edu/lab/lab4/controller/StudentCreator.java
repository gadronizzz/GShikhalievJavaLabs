package edu.lab.lab4.controller;

import edu.lab.lab4.model.*;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String patronymic, Sex sex, String group) {
        return new Student(firstName, lastName, patronymic, sex, group);
    }
}
