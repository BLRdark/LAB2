package controller.service;


import models.forms.StudentAbstractForm;
import models.forms.StudentForm;
import models.forms.StudentSearchModel;
import models.entities.Student;
import models.entities.StudentSearchByPasses;
import views.Alert;

public class StudentFormService {
    public Student getStudentFromForm(StudentForm form) {

        Student student = new Student();

        setStudentFromForm(form, student);
        return student;
    }

    public StudentSearchByPasses getStudentSearchFormModel(StudentAbstractForm form) {
        StudentSearchByPasses student = new StudentSearchByPasses();

        setStudentFromForm(form, student);
        student.setLowerBoundOfAnotherPasses(
                form.getLowerBoundOfAnotherPassesField().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(form.getLowerBoundOfAnotherPassesField()));
        student.setUpperBoundOfAnotherPasses(
                form.getUpperBoundOfAnotherPassesField().isEmpty() ? Integer.MIN_VALUE: Integer.parseInt(form.getUpperBoundOfAnotherPassesField()));
        student.setLowerBoundOfSicknessPasses(
                form.getLowerBoundOfSicknessPassesField().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(form.getLowerBoundOfSicknessPassesField()));
        student.setUpperBoundOfSicknessPasses(
                form.getUpperBoundOfSicknessPassesField().isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(form.getUpperBoundOfSicknessPassesField()));

        student.setLowerBoundOfUnexcusedPasses(
                form.getLowerBoundOfUnexcusedPassesField().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(form.getLowerBoundOfUnexcusedPassesField()));
        student.setUpperBoundOfUnexcusedPasses(
                form.getUpperBoundOfUnexcusedPassesField().isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(form.getUpperBoundOfUnexcusedPassesField()));
        return student;
    }

    private void setStudentFromForm(StudentAbstractForm form, Student student) {
        student.setName(form.getNameField());
        student.setLastName(form.getLastNameField());
        student.setPatronymic(form.getPatronymicField());
        student.setGroup(form.getGroupField());
        student.setByAnother(form.getByAnotherField().isEmpty() ? -1 : Integer.parseInt(form.getByAnotherField()));
        student.setBySickness(form.getBySicknessField().isEmpty() ? -1 : Integer.parseInt(form.getBySicknessField()));
        student.setByUnexcused(form.getByUnexcusedField().isEmpty() ? -1 : Integer.parseInt(form.getByUnexcusedField()));
        student.setTotal(form.getTotalField().isEmpty() ? 0 : Integer.parseInt(form.getTotalField()));
    }


}
