package com.gui;

import com.database.TaskDaoImplementation;
import com.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddNewTask extends JPanel implements ActionListener {

    Frame frame;
    int width;
    int height;
    JPanel inputNamePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel dueDatePanel = new JPanel();
    ButtonGroup dueDateEnable = new ButtonGroup();
    JRadioButton yesRadioButtonDueDate = new JRadioButton("Yes");
    JRadioButton noRadioButtonDueDate = new JRadioButton("No");
    JTextField dueDate = new JTextField();
    JPanel dueTimePanel = new JPanel();
    ButtonGroup dueTimeEnable = new ButtonGroup();
    JRadioButton yesRadioButtonDueTime = new JRadioButton("Yes");
    JRadioButton noRadioButtonDueTime = new JRadioButton("No");
    JTextField dueTime = new JTextField();
    JTextField nameTextField = new JTextField();
    JButton button = new JButton("Add task");

    public AddNewTask(Frame mainFrame, int width, int height) {
        this.frame = mainFrame;
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);

        inputNamePanelSetUp();
        buttonPanelSetUp();
        dueDatePanelSetUp();
        dueTimePanelSetUp();

    }

    private void inputNamePanelSetUp() {
        inputNamePanel.setBounds(0,0, 125,100);
        inputNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,-2));
        this.add(inputNamePanel);

        JLabel nameLabel = new JLabel();
        nameLabel.setPreferredSize(new Dimension(100,25));
        nameLabel.setText("Task Name");
        inputNamePanel.add(nameLabel);

        nameTextField.setPreferredSize(new Dimension(100,25));
        nameTextField.setText("Name");
        inputNamePanel.add(nameTextField);
    }

    private void buttonPanelSetUp() {
        buttonPanel.setBounds(0,75,400,100);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);
        this.add(buttonPanel);
        button.addActionListener(this);
    }

    private void dueDatePanelSetUp() {
        dueDatePanel.setBounds(125,0, 125, 100);
        dueDatePanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,-2));
        this.add(dueDatePanel);

        JLabel dueDateEnableLabel = new JLabel("Add due date");
        dueDateEnableLabel.setPreferredSize(new Dimension(100,25));
        dueDatePanel.add(dueDateEnableLabel);

        yesRadioButtonDueDate.setPreferredSize(new Dimension(60,25));
        dueDatePanel.add(yesRadioButtonDueDate);
        dueDateEnable.add(yesRadioButtonDueDate);

        noRadioButtonDueDate.setPreferredSize(new Dimension(50,25));
        dueDatePanel.add(noRadioButtonDueDate);
        dueDateEnable.add(noRadioButtonDueDate);

        dueDate.setPreferredSize(new Dimension(120,25));
        dueDate.setText("YYYY.MM.DD");
        dueDatePanel.add(dueDate);
    }

    private void dueTimePanelSetUp() {
        dueTimePanel.setBounds(250,0, 125, 100);
        dueTimePanel.setLayout(new FlowLayout(FlowLayout.LEADING,0,-2));
        this.add(dueTimePanel);

        JLabel dueTimeEnableLabel = new JLabel("Add due time");
        dueTimeEnableLabel.setPreferredSize(new Dimension(100,25));
        dueTimePanel.add(dueTimeEnableLabel);

        yesRadioButtonDueTime.setPreferredSize(new Dimension(60,25));
        dueTimePanel.add(yesRadioButtonDueTime);
        dueTimeEnable.add(yesRadioButtonDueTime);

        noRadioButtonDueTime.setPreferredSize(new Dimension(50,25));
        dueTimePanel.add(noRadioButtonDueTime);
        dueTimeEnable.add(noRadioButtonDueTime);

        dueTime.setPreferredSize(new Dimension(120,25));
        dueTime.setText("HH:MM");
        dueTimePanel.add(dueTime);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
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
