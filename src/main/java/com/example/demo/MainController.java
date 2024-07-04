package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private TextField namefield;

    @FXML
    private TextField coursefield;

    @FXML
    private TextField gradefield;

    @FXML
    private TableView<Student> studenttable;

    @FXML
    private TableColumn<Student, String> namecolumn;

    @FXML
    private TableColumn<Student, String> coursecolumn;

    @FXML
    private TableColumn<Student, String> gradecolumn;

    private ObservableList<Student> students = FXCollections.observableArrayList();

    public void initialize(){
        namecolumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        coursecolumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
        gradecolumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());

        studenttable.setItems(students);
    }

    @FXML
    private void addstudent(){
        String name = namefield.getText();
        String course = coursefield.getText();
        String grade = gradefield.getText();

        if (name.isEmpty() || course.isEmpty() || grade.isEmpty()) {
            return;
        }

        Student student = new Student(name, course, grade);
        students.add(student);
        clearfields();
    }

    @FXML
    private void updatestudent(){
        Student selectedStudent = (Student) studenttable.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            // Show an error message here if necessary
            return;
        }

        selectedStudent.setName(namefield.getText());
        selectedStudent.setCourse(coursefield.getText());
        selectedStudent.setGrade(gradefield.getText());
        studenttable.refresh();
        clearfields();
    }

    @FXML
    private void deletestudent(){
        Student selectedStudent = (Student) studenttable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            students.remove(selectedStudent);
            clearfields();
        }
    }

    @FXML
    private void clearfields(){
        namefield.clear();
        coursefield.clear();
        gradefield.clear();
    }

    private void loadstudents(){
        // Load students from the database or any other source
        // For now, let's add some dummy data
        students.add(new Student("John Doe", "Math", "A"));
        students.add(new Student("Jane Smith", "History", "B"));
        students.add(new Student("Emily Johnson", "Science", "A"));
    }

}
