package views;

import controller.service.StudentService;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControlsPartial {
    private final StudentService controller;
    private final JPanel panel = new JPanel(new GridLayout(15, 1, 0, 10));
    private final MainWindow indexWindow;

    public ControlsPartial(StudentService controller, MainWindow indexWindow) {
        this.indexWindow = indexWindow;
        this.controller = controller;
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Remove");

        panel.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));

        addButton.addActionListener(getAddButtonListener());
        searchButton.addActionListener(getSearchButtonListener());
        deleteButton.addActionListener(getDeleteButtonListener());

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel);
    }

    public JPanel getPanel() {
        return panel;
    }

    private ActionListener getAddButtonListener() {
        NewWindow window = new NewWindow(controller, this.indexWindow);
        return e -> window.show();
    }

    private ActionListener getSearchButtonListener() {
        SearchWindow window = new SearchWindow(controller);
        return e -> window.show();
    }

    private ActionListener getDeleteButtonListener() {
        RemovingWindow window = new RemovingWindow(controller, this.indexWindow);
        return e -> window.show();
    }
}
