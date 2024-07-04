package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty name;
    private final StringProperty course;
    private final StringProperty grade;

    public Student(String name, String course, String grade) {
        this.name = new SimpleStringProperty(name);
        this.course = new SimpleStringProperty(course);
        this.grade = new SimpleStringProperty(grade);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public StringProperty gradeProperty() {
        return grade;
    }
}
