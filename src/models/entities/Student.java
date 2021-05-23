package models.entities;

public class Student {
    private String name;
    private String lastName;
    private String patronymic;
    private String group;
    private int bySickness;
    private int byAnother;
    private int byUnexcused;
    private int total;

    public Student(String name, String lastName, String patronymic, String group, int bySickness, int byAnother, int byUnexcused) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.group = group;
        this.bySickness = bySickness;
        this.byAnother = byAnother;
        this.byUnexcused = byUnexcused;
        this.total = bySickness + byAnother + byUnexcused;
    }

    public String getFullName() {
        return this.name + " " + this.lastName + " " + this.patronymic;
    }

    public Student() {
        this("", "", "", "", 0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getBySickness() {
        return bySickness;
    }

    public void setBySickness(int bySickness) {
        this.bySickness = bySickness;
    }

    public int getByAnother() {
        return byAnother;
    }

    public void setByAnother(int byAnother) {
        this.byAnother = byAnother;
    }

    public int getByUnexcused() {
        return byUnexcused;
    }

    public void setByUnexcused(int byUnexcused) {
        this.byUnexcused = byUnexcused;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
