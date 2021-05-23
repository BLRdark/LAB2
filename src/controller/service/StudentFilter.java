package controller.service;

import models.entities.Student;
import models.entities.StudentSearchByPasses;

import java.util.List;
import java.util.stream.Collectors;

public class StudentFilter {
    private StudentSearchByPasses condition;

    public List<Student> getSuitableStudents(StudentSearchByPasses condition, List<Student> records) {
        this.condition = condition;

        return records
                .stream()
                .filter(this::applyCondition)
                .collect(Collectors.toList());
    }

    private boolean applyCondition(Student student) {
        if (lastNameFilter(student) || groupFilter(student))
            return true;
        if (lastNameFilter(student) || passesByUnexcusedFilter(student) && passesByAnotherFilter(student) && passesBySicknessFilter(student) )
            return true;
        return  (lastNameFilter(student) || boundOfAnotherFilter(student) && boundOfUnexcusedFilter(student) && boundOfSicknessFilter(student));
    }

    private boolean boundOfUnexcusedFilter(Student student) {
        return (this.condition.getLowerBoundOfUnexcusedPasses() <= student.getByUnexcused() &&
                this.condition.getUpperBoundOfUnexcusedPasses() >= student.getByUnexcused());
    }

    private boolean boundOfAnotherFilter(Student student) {
        return (this.condition.getLowerBoundOfAnotherPasses() <= student.getByAnother() &&
                this.condition.getUpperBoundOfAnotherPasses() >= student.getByAnother());
    }

    private boolean boundOfSicknessFilter(Student student) {
        return (this.condition.getLowerBoundOfSicknessPasses() <= student.getBySickness() &&
                this.condition.getUpperBoundOfSicknessPasses() >= student.getBySickness());
    }

    private boolean nameFilter(Student student) {
        return this.condition.getName().equals(student.getName());
    }

    private boolean lastNameFilter(Student student) {
        return this.condition.getLastName().equals(student.getLastName());
    }

    private boolean patronymicFilter(Student student) {
        return this.condition.getPatronymic().equals(student.getPatronymic());
    }

    private boolean groupFilter(Student student) {
        return this.condition.getGroup().equals(student.getGroup());
    }

    private boolean passesBySicknessFilter(Student student) {
        return (this.condition.getBySickness() == (student.getBySickness()));
    }

    private boolean passesByUnexcusedFilter(Student student) {
        return (this.condition.getByUnexcused() == (student.getByUnexcused()));
    }

    private boolean passesByAnotherFilter(Student student) {
        return (this.condition.getByAnother() == (student.getByAnother()));
    }

    private boolean totalPassesFilter(Student student) {
        return (this.condition.getTotal() == (student.getTotal()));
    }


}
