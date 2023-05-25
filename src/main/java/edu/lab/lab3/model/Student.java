package edu.lab.lab3.model;

public class Student extends Human {
    private String group;

    public Student(String firstName, String lastName, String patronymic, Sex sex, String group) {
        super(firstName, lastName, patronymic, sex);
        this.group = group;
    }

}
