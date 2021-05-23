package views;

import models.forms.StudentAbstractForm;
import models.forms.StudentSearchModel;
import models.entities.Student;
import controller.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchWindow {
    private final StudentService controller;
    private final JFrame searchWindow;
    private final TablePanel table;
    private final StudentSearchModel form;

    public SearchWindow(StudentService controller) {
        this.controller = controller;
        searchWindow = new JFrame("Search");
        searchWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        form = new StudentSearchModel();


        JPanel panel = form.getPanel();
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel test = new JPanel(new BorderLayout());
        JButton closeButton = new JButton("Close");
        JButton searchButton = new JButton("Search");
        panel2.add(closeButton, BorderLayout.EAST);
        panel2.add(Box.createHorizontalStrut(15));
        panel2.add(searchButton, BorderLayout.WEST);
        closeButton.addActionListener(getCloseButtonListener());
        searchButton.addActionListener(getSearchButtonListener(form));

        test.add(panel2, BorderLayout.SOUTH);
        test.add(panel, BorderLayout.NORTH);

        table = new TablePanel(controller.getAllStudents());
        contentPane.add(table.getPanel(), BorderLayout.CENTER);
        contentPane.add(test, BorderLayout.WEST);

        searchWindow.setContentPane(contentPane);
        searchWindow.pack();
    }

    public void show() {
        searchWindow.setVisible(true);
    }

    public void dispose() {
        searchWindow.dispose();
    }

    public void updateTable(List<Student> students) {
        table.setData(students);
    }

    private ActionListener getCloseButtonListener() {
        return e -> dispose();
    }

    private ActionListener getSearchButtonListener(StudentAbstractForm form) {
            return e -> updateTable(controller.applyFilters(form));

    }
}
