package views;

import controller.service.StudentService;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuPartial {
    private final JMenuBar menuBar;
    private final StudentService controller;
    private final MainWindow indexWindow;

    public MenuPartial(StudentService controller, MainWindow indexWindow) {
        this.controller = controller;
        this.indexWindow = indexWindow;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".xml","xml"));

        menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        JMenu action = new JMenu("Action");
        JMenuItem createItem = new JMenuItem("Add");
        JMenuItem deleteItem = new JMenuItem("Remove");
        JMenuItem searchItem = new JMenuItem("Search");

        openItem.addActionListener(getOpenItemListener(fileChooser));
        saveItem.addActionListener(getSaveItemListener(fileChooser));

        createItem.addActionListener(getCreateItemListener());
        deleteItem.addActionListener(getDeleteItemListener());
        searchItem.addActionListener(getSearchItemListener());

        menu.add(openItem);
        menu.add(saveItem);

        action.add(createItem);
        action.add(deleteItem);
        action.add(searchItem);

        menuBar.add(menu);
        menuBar.add(action);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private ActionListener getOpenItemListener(JFileChooser fileChooser) {
        return e -> {
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                controller.open(file);

                this.indexWindow.updateTable();
            }
        };
    }

    private ActionListener getSaveItemListener(JFileChooser fileChooser) {
        return e -> {
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                controller.save(file);
            }
        };
    }

    private ActionListener getCreateItemListener() {
        NewWindow window = new NewWindow(controller, this.indexWindow);
        return e -> window.show();
    }

    private ActionListener getDeleteItemListener() {
        RemovingWindow window = new RemovingWindow(controller, this.indexWindow);
        return e -> window.show();
    }

    private ActionListener getSearchItemListener() {
        SearchWindow window = new SearchWindow(controller);
        return e -> window.show();
    }
}
