package views;

import models.forms.StudentForm;
import controller.service.StudentService;

import java.awt.event.ActionListener;
import javax.swing.*;

public class NewWindow {
    private final StudentService controller;
    private final JFrame newWindow;
    private final MainWindow indexWindow;

    public NewWindow(StudentService controller, MainWindow indexWindow) {
        this.indexWindow = indexWindow;
        this.controller = controller;
        newWindow = new JFrame("Addition menu");
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        StudentForm form = new StudentForm();
        JPanel panel = form.getPanel();

        JButton closeButton = new JButton("Close");
        JButton submitButton = new JButton("Submit");
        closeButton.addActionListener(getCloseButtonListener());
        submitButton.addActionListener(getSubmitButtonListener(form));
        panel.add(closeButton);
        panel.add(submitButton);

        contentPane.add(panel);

        newWindow.setContentPane(contentPane);
        newWindow.pack();
    }

    public void show() {
        newWindow.setVisible(true);
    }

    public void dispose() {
        newWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(StudentForm form) {
        return e -> {

            controller.createFromForm(form);
            form.clear();
            indexWindow.updateTable();
            indexWindow.show();
            newWindow.setVisible(false);
        };
    }
}
