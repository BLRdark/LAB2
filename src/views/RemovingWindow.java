package views;

import models.forms.StudentSearchModel;
import models.entities.Student;
import controller.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RemovingWindow {
    private final StudentService controller;
    private final JFrame deleteWindow;
    private final MainWindow indexWindow;
    private final StudentSearchModel form;

    public RemovingWindow(StudentService controller, MainWindow indexWindow) {
        this.controller = controller;
        this.indexWindow = indexWindow;
        deleteWindow = new JFrame("Remove");
        deleteWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form = new StudentSearchModel();
        JPanel panel = form.getPanel();
        JPanel window = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton closeButton = new JButton("Close");
        JButton deleteButton = new JButton("Remove");
        closeButton.addActionListener(getCloseButtonListener());
        deleteButton.addActionListener(getSubmitButtonListener(form)); ////////////////////////////////
        buttonPanel.add(closeButton, BorderLayout.EAST);
        buttonPanel.add(deleteButton, BorderLayout.WEST);
        window.add(panel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.add(window);

        deleteWindow.setContentPane(contentPane);
        deleteWindow.pack();
    }

    public void show() {
        deleteWindow.setVisible(true);
    }

    public void dispose() {
        deleteWindow.dispose();
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSubmitButtonListener(StudentSearchModel form) {
        return e -> {
            List<Student> searchResults = this.controller.applyFilters(form);

            controller.remove(searchResults);

            new Alert(getRemovedRecordsList(searchResults));
            indexWindow.updateTable();
            this.deleteWindow.setVisible(false);
        };
    }

    private String getRemovedRecordsList(List<Student> removedRecords) {
        if (removedRecords.size() == 0) {
            return "No matches found.";
        }
        StringBuilder text = new StringBuilder(removedRecords.size() + " entries were removed:\n");
        /*for (int index = 0; index < removedRecords.size(); index++) {
            Student student = removedRecords.get(index);
            text.append(student.getFullName()).append("\n");
            if (index >= 9) {
                return text + "And " + (removedRecords.size() - index - 1) + " more.";
            }
        }*/
        return text.toString();
    }

}