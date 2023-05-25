package edu.lab.lab3.controller;

import edu.lab.lab3.model.*;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}