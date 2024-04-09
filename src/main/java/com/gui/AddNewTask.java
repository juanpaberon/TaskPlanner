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
    JPanel buttonPanel = new JPanel();
    JPanel dueDatePanel = new JPanel();
    JPanel dueTimePanel = new JPanel();
    JLabel nameLabel = new JLabel();
    JTextField nameTextField = new JTextField();
    JButton button = new JButton("Add task");

    public AddNewTask(Frame mainFrame, int x, int y, int width, int height) {
        this.frame = mainFrame;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        inputNamePanelSetUp();
        buttonPanelSetUp();
        dueDatePanelSetUp();
        dueTimePanelSetUp();

    }

    private void inputNamePanelSetUp() {
        inputNamePanel.setBounds(0,0, 100,50);
        inputNamePanel.setLayout(new BorderLayout());
        this.add(inputNamePanel);

        nameLabel.setPreferredSize(new Dimension(100,25));
        nameLabel.setText("Task Name");
        inputNamePanel.add(nameLabel, BorderLayout.NORTH);

        nameTextField.setPreferredSize(new Dimension(100,25));
        nameTextField.setText("Name");
        inputNamePanel.add(nameTextField, BorderLayout.SOUTH);
    }

    private void buttonPanelSetUp() {
        buttonPanel.setBounds(0,50,400,100);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);
        this.add(buttonPanel);
        button.addActionListener(this);
    }

    private void dueDatePanelSetUp() {
        dueDatePanel.setBounds(0,100, 100, 50);
        dueDatePanel.setLayout(new BorderLayout());
        this.add(dueDatePanel);
    }

    private void dueTimePanelSetUp() {
        dueTimePanel.setBounds(0,200, 100, 50);
        dueTimePanel.setLayout(new BorderLayout());
        this.add(dueTimePanel);
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
