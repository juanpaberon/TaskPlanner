package com.gui;

import com.database.TaskDaoImplementation;
import com.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddNewTask extends JPanel implements ActionListener {

    Frame frame;
    int width;
    int height;
    JPanel inputNamePanel = new JPanel();
    JLabel nameLabel = new JLabel();
    JTextField nameTextField = new JTextField();
    JButton button = new JButton("Add task");

    public AddNewTask(Frame mainFrame, int x, int y, int width, int height) {
        this.frame = mainFrame;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        inputNamePanel.setBounds(0,0, 100,50);
        inputNamePanel.setLayout(new BorderLayout());
        this.add(inputNamePanel);

        nameLabel.setPreferredSize(new Dimension(100,25));
        nameLabel.setText("Task Name");
        inputNamePanel.add(nameLabel, BorderLayout.NORTH);

        nameTextField.setPreferredSize(new Dimension(100,25));
        nameTextField.setText("Task Name");
        inputNamePanel.add(nameTextField, BorderLayout.SOUTH);

        button.setBounds(100,75,100,50);
        button.addActionListener(this);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println(nameTextField.getText());
            try {
                createNewTask();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            nameTextField.setText("Task Name");
            this.frame.onButtonClicked();
        }
    }

    public void createNewTask() throws SQLException {
        String name = nameTextField.getText();
        LocalDateTime timeCreated = LocalDateTime.now();
        Task task = new Task(-1, name, timeCreated);

        TaskDaoImplementation taskDao = new TaskDaoImplementation();
        taskDao.add(task);
    }
}
