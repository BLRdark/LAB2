package models.forms;

import models.entities.Student;

import javax.swing.*;
import java.awt.*;

public abstract class StudentAbstractForm {
    protected JPanel panel;
    protected JTextField nameField;
    protected JTextField lastNameField;
    protected JTextField patronymicField;
    protected JTextField groupField;
    protected JTextField byUnexcusedField;
    protected JTextField bySicknessField;
    protected JTextField byAnotherField;
    protected JTextField totalField;
    protected JTextField upperBoundsOfPassesField;
    protected JTextField lowerBoundsOfPassesField;
    protected JTextField upperBoundOfUnexcusedPassesField;
    protected JTextField lowerBoundOfUnexcusedPassesField;
    protected JTextField upperBoundOfAnotherPassesField;
    protected JTextField lowerBoundOfAnotherPassesField;
    protected JTextField upperBoundOfSicknessPassesField;
    protected JTextField lowerBoundOfSicknessPassesField;
    protected JLabel nameLabel;
    protected JLabel lastNameLabel;
    protected JLabel patronymicLabel;
    protected JLabel groupLabel;
    protected JLabel byUnexcusedLabel;
    protected JLabel bySicknessLabel;
    protected JLabel byAnotherLabel;
    protected JLabel totalLabel;
    protected JLabel upperBoundOfPassesLabel;
    protected JLabel lowerBoundOfPassesLabel;
    protected JLabel upperBoundOfUnexcusedPassesLabel;
    protected JLabel lowerBoundOfUnexcusedPassesLabel;
    protected JLabel upperBoundOfAnotherPassesLabel;
    protected JLabel lowerBoundOfAnotherPassesLabel;
    protected JLabel upperBoundOfSicknessPassesLabel;
    protected JLabel lowerBoundOfSicknessPassesLabel;

    StudentAbstractForm() {

        panel = new JPanel(new GridLayout(17, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nameLabel = new JLabel("Student's name:");
        lastNameLabel = new JLabel("Student's last name:");
        patronymicLabel = new JLabel("Student's patronymic:");
        groupLabel = new JLabel("Group:");
        byUnexcusedLabel = new JLabel("By Unexcused:");
        bySicknessLabel = new JLabel("By Sickness:");
        byAnotherLabel = new JLabel("By Another:");
        totalLabel = new JLabel("Total:");
        upperBoundOfPassesLabel = new JLabel("Upper Bound Of passes");
        lowerBoundOfPassesLabel = new JLabel("Lower Bound of passes");
        upperBoundOfUnexcusedPassesLabel = new JLabel("UB by Unexcused");
        lowerBoundOfUnexcusedPassesLabel = new JLabel("LB by Unexcused");
        upperBoundOfAnotherPassesLabel = new JLabel("UB by Another Reason");
        lowerBoundOfAnotherPassesLabel = new JLabel("LB by Another Reason");
        upperBoundOfSicknessPassesLabel = new JLabel("UB by Sickness");
        lowerBoundOfSicknessPassesLabel = new JLabel("LB by Sickness");

        nameField = new JTextField(20);
        lastNameField = new JTextField(20);
        patronymicField = new JTextField(20);
        groupField = new JTextField(20);
        byUnexcusedField = new JTextField(20);
        bySicknessField = new JTextField(20);
        byAnotherField = new JTextField(20);
        totalField = new JTextField(20);
        upperBoundsOfPassesField = new JTextField(20);
        lowerBoundsOfPassesField = new JTextField(20);
        upperBoundOfUnexcusedPassesField = new JTextField(20);
        lowerBoundOfUnexcusedPassesField = new JTextField(20);
        upperBoundOfAnotherPassesField = new JTextField(20);
        lowerBoundOfAnotherPassesField = new JTextField(20);
        upperBoundOfSicknessPassesField = new JTextField(20);
        lowerBoundOfSicknessPassesField = new JTextField(20);
    }

    public String getGroupField() {
        return groupField.getText().trim();
    }

    public String getByUnexcusedField() {
        return byUnexcusedField.getText().trim();
    }

    public String getByAnotherField() {
        return byAnotherField.getText().trim();
    }

    public String getBySicknessField() {
        return bySicknessField.getText().trim();
    }

    public String getTotalField() {
        return totalField.getText().trim();
    }

    public JPanel getPanel() {
        return panel;
    }


    public String getNameField() {
        return nameField.getText().trim();
    }

    public String getLastNameField() {
        return lastNameField.getText().trim();
    }

    public String getPatronymicField() {
        return patronymicField.getText().trim();
    }

    public String getUpperBoundOfUnexcusedPassesField() {
        return upperBoundOfUnexcusedPassesField.getText().trim();
    }

    public String getLowerBoundOfUnexcusedPassesField() {
        return lowerBoundOfUnexcusedPassesField.getText().trim();
    }

    public String getUpperBoundOfAnotherPassesField() {
        return upperBoundOfAnotherPassesField.getText().trim();
    }

    public String getLowerBoundOfAnotherPassesField() {
        return lowerBoundOfAnotherPassesField.getText().trim();
    }

    public String getUpperBoundOfSicknessPassesField() {
        return upperBoundOfSicknessPassesField.getText().trim();
    }

    public String getLowerBoundOfSicknessPassesField() {
        return lowerBoundOfSicknessPassesField.getText().trim();
    }

    public String getUpperBoundsOfPassesField() {
        return upperBoundsOfPassesField.getText().trim();
    }

    public String getLowerBoundsOfPassesField() {
        return lowerBoundsOfPassesField.getText().trim();
    }

    public void clear() {
        for(Component element : panel.getComponents())
            if(element instanceof JTextField)
                ((JTextField) element).setText("");
    }

    public boolean verify(){
        return this.getByAnotherField() instanceof String || this.getBySicknessField() instanceof String || this.getByUnexcusedField() instanceof String
                || this.getTotalField() instanceof  String;
    }
}
