package edu.lab.lab4.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFacultiesList() {
        return faculties;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public static University fromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, University.class);
    }

    public void saveToJsonFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University loadFromJsonFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String json = sb.toString();
            return fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
