package com.gui;

import com.database.TaskDaoImplementation;
import com.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class DisplayTask extends JPanel{

    TaskDaoImplementation taskDao = new TaskDaoImplementation();
    Frame frame;
    DefaultTableModel model;

    public DisplayTask(Frame frame) {
        this.frame = frame;

        this.setBounds(0,0,400,200);

        Object[][] data = {};
        String[] columnNames = {"Name", "Time created"};
        model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

    public void update() throws SQLException {
        List<Task> allTasks = taskDao.getTasks();

        for (Task task : allTasks) {
            model.addRow(new Object[]{task.getName(), task.getTimeCreated()});
        }
        frame.setVisible(true);
    }
}
