package models.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StudentSearchModel extends StudentAbstractForm {


    private final JComboBox<JButton> comboBox;


    public StudentSearchModel() {
        super();
        JPanel searchPanel = new JPanel();
        comboBox = new JComboBox(new String[]{"Choose Option", "Group &  Surname", "Surname & Passes", "Surname & Bounds of passes"});

        clear();
        panel.add(comboBox);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    clear();
                    if(e.getItem().toString().equals("Choose Option")){
                        panel.removeAll();
                        panel.add(comboBox);
                        panel.repaint();
                        panel.revalidate();
                    }
                    if (e.getItem().toString().equals("Group &  Surname")) {
                        panel.removeAll();
                        panel.add(comboBox);
                        panel.add(lastNameLabel);
                        panel.add(lastNameField);
                        panel.add(groupLabel);
                        panel.add(groupField);
                        panel.repaint();
                        panel.revalidate();
                    } else if (e.getItem().toString().equals("Surname & Passes")) {
                        panel.removeAll();
                        panel.add(comboBox);
                        panel.add(lastNameLabel);
                        panel.add(lastNameField);
                        panel.add(byUnexcusedLabel);
                        panel.add(byUnexcusedField);
                        panel.add(byAnotherLabel);
                        panel.add(byAnotherField);
                        panel.add(bySicknessLabel);
                        panel.add(bySicknessField);
                        panel.repaint();
                        panel.revalidate();
                    } else if (e.getItem().toString().equals("Surname & Bounds of passes")) {
                        panel.removeAll();
                        panel.add(comboBox);
                        panel.add(lastNameLabel);
                        panel.add(lastNameField);


                        panel.add(lowerBoundOfAnotherPassesLabel);
                        panel.add(lowerBoundOfAnotherPassesField);
                        panel.add(upperBoundOfAnotherPassesLabel);
                        panel.add(upperBoundOfAnotherPassesField);


                        panel.add(lowerBoundOfSicknessPassesLabel);
                        panel.add(lowerBoundOfSicknessPassesField);
                        panel.add(upperBoundOfSicknessPassesLabel);
                        panel.add(upperBoundOfSicknessPassesField);

                        panel.add(lowerBoundOfUnexcusedPassesLabel);
                        panel.add(lowerBoundOfUnexcusedPassesField);
                        panel.add(upperBoundOfUnexcusedPassesLabel);
                        panel.add(upperBoundOfUnexcusedPassesField);


                        panel.repaint();
                        panel.revalidate();
                    }
                }
            }
        });

    }
@Override
    public void clear() {
            for(Component element : panel.getComponents())
                if(element instanceof JTextField)
                    ((JTextField) element).setText("");
        panel.repaint();
        panel.revalidate();
    }

}
