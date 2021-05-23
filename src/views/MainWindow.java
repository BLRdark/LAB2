package views;

import controller.service.StudentService;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private final StudentService controller;
    private final JFrame mainWindow;
    private final TablePanel table;

    public MainWindow(StudentService controller) {
        this.controller = controller;
        mainWindow = new JFrame("Students Repository");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table = new TablePanel(controller.getAllStudents());
        contentPanel.add(table.getPanel(), BorderLayout.CENTER);
        contentPanel.add(new ControlsPartial(controller, this).getPanel(), BorderLayout.WEST);

        mainWindow.setJMenuBar(new MenuPartial(controller, this).getMenuBar());
        mainWindow.setContentPane(contentPanel);
        mainWindow.pack();
    }

    public void show() {
        mainWindow.setVisible(true);
    }


    public void updateTable() {
        table.setData(controller.getAllStudents());
    }
}
