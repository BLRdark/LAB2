package controller.service;

import models.forms.StudentAbstractForm;
import models.forms.StudentForm;
import models.entities.Student;
import models.entities.StudentSearchByPasses;
import controller.repository.StudentRepo;
import views.Alert;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public StudentRepo studentRepository;

    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return this.studentRepository.getStudentFromList();
    }

    public void create(Student student) {
        studentRepository.addStudentToList(student);
    }

    public void remove(List<Student> forDeleting) {
        List<Student> students = this.studentRepository.getStudentFromList();
        students.removeAll(forDeleting);
        this.studentRepository.setStudentList(students);
    }

    public void open(File file) {
        studentRepository.setSourceFile(file);
        studentRepository.readAll();
    }

    public void save(File file) {
        studentRepository.setSourceFile(file);
        studentRepository.saveAll();
    }

    public List<Student> applyFilters(StudentAbstractForm form){
        StudentFormService getter = new StudentFormService();
        StudentSearchByPasses student = getter.getStudentSearchFormModel(form);
        StudentFilter filter = new StudentFilter();
        return filter.getSuitableStudents(student, this.getAllStudents());
    }

    public void createFromForm(StudentForm form) {
        StudentFormService getter = new StudentFormService();
        Student student = getter.getStudentFromForm(form);
        if(studentFormIsEmpty(form)){
            new Alert("Unable to create unit! \nSome fields are empty");
            return;
        }
        checkTotal(form, student);
        this.create(student);
    }

    public static boolean studentFormIsEmpty(StudentForm form){
        return form.getNameField().isEmpty() || form.getBySicknessField().isEmpty() || form.getLastNameField().isEmpty() || form.getPatronymicField().isEmpty() ||
                form.getGroupField().isEmpty() || form.getByUnexcusedField().isEmpty() || form.getByAnotherField().isEmpty();
    }

    private void checkTotal(StudentForm form, Student student){
        if(!studentFormIsEmpty(form) && form.getTotalField().isEmpty()){
            student.setTotal(Integer.parseInt(form.getByAnotherField()) + Integer.parseInt(form.getByUnexcusedField()) +Integer.parseInt(form.getBySicknessField()));
        }
    }
}
