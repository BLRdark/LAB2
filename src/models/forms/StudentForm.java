package models.forms;


import javax.swing.*;
import java.awt.*;

public class StudentForm extends StudentAbstractForm{

    public StudentForm() {
        super();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(patronymicLabel);
        panel.add(patronymicField);
        panel.add(groupLabel);
        panel.add(groupField);
        panel.add(byUnexcusedLabel);
        panel.add(byUnexcusedField);
        panel.add(bySicknessLabel);
        panel.add(bySicknessField);
        panel.add(byAnotherLabel);
        panel.add(byAnotherField);
        panel.add(totalLabel);
        panel.add(totalField);
    }

}
