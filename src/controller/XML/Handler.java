package controller.XML;

import models.entities.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Handler extends DefaultHandler {
    private List<Student> students;
    private Student student;
    private String currentElement;
    private Boolean isExisted;

    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) {
        if (qName.equals("students")) {
            students = new ArrayList<>();
        }

        if (qName.equals("student")) {
            student = new Student();
            isExisted = true;
        }

        currentElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("student")) {
            students.add(student);
            isExisted = false;
        }

        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement.equals("name") && isExisted) {
            student.setName(text(ch, start, length));
        }

        if (currentElement.equals("lastName") && isExisted) {
            student.setLastName(text(ch, start, length));
        }

        if (currentElement.equals("patronymic") && isExisted) {
            student.setPatronymic(text(ch, start, length));
        }

        if (currentElement.equals("group") && isExisted) {
            student.setGroup(text(ch, start, length));
        }

        if (currentElement.equals("byUnexcused") && isExisted) {
            student.setByUnexcused(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("bySickness") && isExisted) {
            student.setBySickness(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("byAnother") && isExisted) {
            student.setByAnother(parseInt(text(ch, start, length)));
        }

        if (currentElement.equals("total") && isExisted) {
            student.setTotal(parseInt(text(ch, start, length)));
        }

    }

    private String text(char[] ch, int start, int length) {
        return new String(ch, start, length);
    }

    public List<Student> getStudents() {
        return students;
    }
}
