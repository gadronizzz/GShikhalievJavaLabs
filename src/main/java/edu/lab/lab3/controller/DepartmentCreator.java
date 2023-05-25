package edu.lab.lab3.controller;

import edu.lab.lab3.model.*;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
