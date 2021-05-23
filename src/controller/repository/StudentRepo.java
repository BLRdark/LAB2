package controller.repository;

import controller.XML.*;
import models.entities.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo {
    private List<Student> students = new ArrayList<>();
    private File sourceFile;

    public StudentRepo() { }


    public void readAll() {
        students = new XMLReader(sourceFile).readAll();
        if (students == null) {
            students = new ArrayList<>();
        }
    }

    public void saveAll() {
        new XMLWriter(sourceFile).writeAll(students);
    }

    public void addStudentToList(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudentFromList() {
        return new ArrayList<>(students);
    }

    public void setStudentList(List<Student> students) {
        this.students = students;
    }

    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }


}
