package com.gui.displayTask;

import com.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class TaskDetails extends JFrame implements ActionListener {

    Task task;
    JTextField nameTextField = new JTextField();
    JTextField dueDateTextField = new JTextField();
    JTextField dueTimeTextField = new JTextField();
    JTextArea descriptionField = new JTextArea();
    JButton resetButton = new JButton("reset");
    JButton saveButton = new JButton("save");

    public TaskDetails(Task task) {
        this.task = task;
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        this.setTitle("Task details");

        JLabel taskName = new JLabel("Task Name");
        taskName.setPreferredSize(new Dimension(100, 20));
        taskName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskName);

        nameTextField.setPreferredSize(new Dimension(290, 20));
        nameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(nameTextField);

        JLabel taskDueDate = new JLabel("Due Date");
        taskDueDate.setPreferredSize(new Dimension(100, 20));
        taskDueDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskDueDate);

        dueDateTextField.setPreferredSize(new Dimension(290, 20));
        dueDateTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(dueDateTextField);

        JLabel taskDueTime = new JLabel("Due Time");
        taskDueTime.setPreferredSize(new Dimension(100, 20));
        taskDueTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskDueTime);

        dueTimeTextField.setPreferredSize(new Dimension(290, 20));
        dueTimeTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(dueTimeTextField);

        JLabel taskCreationDate = new JLabel("Creation Date");
        taskCreationDate.setPreferredSize(new Dimension(100, 20));
        taskCreationDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskCreationDate);

        JLabel taskCreationDateExp = new JLabel(getDateFromLDT(task.getTimeCreated()));
        taskCreationDateExp.setPreferredSize(new Dimension(290, 20));
        taskCreationDateExp.setFont(new Font(null, Font.PLAIN, 12));
        taskCreationDateExp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskCreationDateExp);

        JLabel taskCreationTime = new JLabel("Creation Time");
        taskCreationTime.setPreferredSize(new Dimension(100, 20));
        taskCreationTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskCreationTime);

        JLabel taskCreationTimeExp = new JLabel(getTimeFromLDT(task.getTimeCreated()));
        taskCreationTimeExp.setPreferredSize(new Dimension(290, 20));
        taskCreationTimeExp.setFont(new Font(null, Font.PLAIN, 12));
        taskCreationTimeExp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskCreationTimeExp);

        JLabel taskDescription = new JLabel("Description");
        taskDescription.setPreferredSize(new Dimension(100, 20));
        taskDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskDescription);

        descriptionField.setPreferredSize(new Dimension(395, 360));
        descriptionField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(descriptionField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(395, 40));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        this.add(buttonPanel);

        resetButton.setPreferredSize(new Dimension(60,25));
        resetButton.setFont(new Font(null, Font.PLAIN, 10));
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        saveButton.setPreferredSize(new Dimension(60,25));
        saveButton.setFont(new Font(null, Font.PLAIN, 10));
        buttonPanel.add(saveButton);

        populateFields();

        this.setVisible(true);
    }

    public void populateFields() {
        nameTextField.setText(task.getName());
        if (!(task.getDueDate() == null)) {
            dueDateTextField.setText(task.getDueDate().toString());
        }
        if (!(task.getDueTime() == null)) {
            dueTimeTextField.setText(task.getDueTime().toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton){
            populateFields();
        } else if (e.getSource() == saveButton) {

        }
    }

    public String getDateFromLDT(LocalDateTime LDTtoConvert) {
        return LDTtoConvert.getYear() + "-" + LDTtoConvert.getMonthValue() + "-" + LDTtoConvert.getDayOfMonth();
    }

    public String getTimeFromLDT(LocalDateTime LDTtoConvert) {
        return LDTtoConvert.getHour() + ":" + LDTtoConvert.getMinute();
    }


}
