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
    JTable table;
    JScrollPane scrollPane;

    public DisplayTask(Frame frame) {
        this.frame = frame;

        this.setBounds(0,0,400,200);
        this.setLayout(null);

        this.table = new JTable();
        update();
        this.scrollPane = new JScrollPane(this.table);
        scrollPane.setSize(400,200);
        this.add(scrollPane);
    }

    public void update(){

        Object[][] data = {};
        String[] columnNames = {"Name", "Time created"};
        this.model = new DefaultTableModel(data, columnNames);

        List<Task> allTasks;
        try {
            allTasks = taskDao.getTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Task task : allTasks) {
            model.addRow(new Object[]{task.getName(), task.getTimeCreated()});
        }

        this.table.setModel(model);
    }
}
