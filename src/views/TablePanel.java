package views;

import models.entities.Student;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TablePanel {
    private final JPanel panel = new JPanel(new BorderLayout());
    private final DefaultTableModel tableModel = getModel();
    private final JLabel currentPageLabel;
    private final JTextField updatePerPageField;
    private List<Student> students;
    private int page = 1;
    private int perPage = 20;

    public TablePanel(List<Student> students) {
        this.students = students;

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        String[] columnNames = {"Name", "Group", "Sickness absences", "Another reason absences", "Unexcused absences", "Total"};
        tableModel.setColumnIdentifiers(columnNames);
        table.setModel(tableModel);
        scrollPane.setPreferredSize(new Dimension(1000,600 ));

        JButton nextButton = new JButton("->");
        JButton prevButton = new JButton("<-");
        JButton lastPageButton = new JButton("Last page");
        JButton firstPageButton = new JButton("First page");

        nextButton.addActionListener(goToNextPage(this));
        prevButton.addActionListener(goToPrevPage(this));
        lastPageButton.addActionListener(goToLastPage(this));
        firstPageButton.addActionListener(goToFirstPage(this));
        currentPageLabel = new JLabel();
        JLabel updatePerPageLabel = new JLabel("Number of elements\n per page");
        updatePerPageField = new JTextField(String.valueOf(perPage), 4);
        updatePerPageField.getDocument().addDocumentListener(getUpdatePerPageListener(this));

        JPanel pageControlPanel = new JPanel();
        pageControlPanel.add(updatePerPageLabel);
        pageControlPanel.add(updatePerPageField);
        pageControlPanel.add(firstPageButton);
        pageControlPanel.add(prevButton);
        pageControlPanel.add(currentPageLabel);
        pageControlPanel.add(nextButton);
        pageControlPanel.add(lastPageButton);



        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pageControlPanel, BorderLayout.SOUTH);
        if(students != null && students.size() != 0 && !students.isEmpty()) rerender();
    }

    public void setData(List<Student> students) {
        this.students = students;
        rerender();
    }

    public void rerender() {
        List<Student> students = dataToDisplay(page, perPage);
        tableModel.setRowCount(0);
        if (students == null || students.isEmpty() || students.size() == 0) return;
        for (Student student : students) {
            Object[] row = new Object[] {
                    student.getFullName(),
                    student.getGroup(),
                    student.getBySickness(),
                    student.getByAnother(),
                    student.getByUnexcused(),
                    student.getTotal(),
            };
            tableModel.addRow(row);
        }
        if(pageCount()==0){
            currentPageLabel.setText("0" + "/" + pageCount());
        }
        else{
            currentPageLabel.setText(getPage() + "/" + pageCount());
        }

    }

    public JPanel getPanel() {
        return panel;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getPage() {
        return page;
    }

    public int recordCount() {
        return students.size();
    }

    public int pageCount() {
        if (perPage == 0) {
            return 1;
        } else {
            return (int) Math.ceil((double)recordCount() / perPage);
        }
    }

    private void setPerPage(int perPage) {
        if (perPage > recordCount()) {
            perPage = recordCount();
        } else if (perPage < 0) {
            perPage = 0;
        }
        this.perPage = perPage;
        rerender();
    }

    private void setPage(int page) {
        if (page > pageCount()){
            page = pageCount();
        } else if (page <= 0) {
            page = 1;
        }
        this.page = page;
        rerender();
    }

    private ActionListener goToNextPage(TablePanel table) {
        return e -> table.setPage(table.getPage() + 1);
    }

    private ActionListener goToPrevPage(TablePanel table) {
        return e -> table.setPage(table.getPage() - 1);
    }

    private ActionListener goToLastPage(TablePanel table) {
        return e -> table.setPage(table.pageCount());
    }

    private ActionListener goToFirstPage(TablePanel table) {
        return e -> table.setPage(1);
    }

    private DefaultTableModel getModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private DocumentListener getUpdatePerPageListener(TablePanel table) {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionForPageListener(table);
            }
        };
    }

    private void actionForPageListener(TablePanel table) {
        String newPerPage = updatePerPageField.getText();
        newPerPage = newPerPage.equals("") ? "0" : newPerPage;
        table.setPerPage(Integer.parseInt(newPerPage));
        table.setPage(1);
    }
    
    private List<Student> dataToDisplay(int page, int perPage) {
        int first = (page - 1) * perPage;
        int last  = first + perPage;
        if(students == null){
            new Alert("No Students found");
            return null;
        }
        last = Math.min(last, students.size());
        return new ArrayList<>(students.subList(first, last));
    }
}
