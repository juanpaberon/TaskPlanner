package com.gui.displayTask;

import com.model.Task;
import com.database.TaskDaoImplementation;
import com.gui.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TaskPanel extends JPanel implements ActionListener {

    TaskDaoImplementation taskDao = new TaskDaoImplementation();
    JLabel taskName = new JLabel();
    JLabel taskDueDate = new JLabel();
    JLabel taskDueTime = new JLabel();
    JButton finishTask = new JButton("F");
    JButton deleteTask = new JButton("X");
    Task task;
    Frame listener;


    public TaskPanel(Task task, Frame listener) {
        this.listener = listener;
        this.task = task;
        this.setPreferredSize(new Dimension(390,60));
        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));

        taskName.setPreferredSize(new Dimension(330,20));
        taskName.setFont(new Font(null, Font.PLAIN, 10));
        taskName.setText(task.getName());
        this.add(taskName);

        finishTask.setPreferredSize(new Dimension(40,20));
        finishTask.setFont(new Font(null, Font.PLAIN, 10));
        finishTask.addActionListener(this);
        this.add(finishTask);

        taskDueDate.setPreferredSize(new Dimension(165,20));
        taskDueDate.setFont(new Font(null, Font.PLAIN, 10));
        taskDueDate.setText(task.getDueDate().toString());
        this.add(taskDueDate);

        taskDueTime.setPreferredSize(new Dimension(160,20));
        taskDueTime.setFont(new Font(null, Font.PLAIN, 10));
        taskDueTime.setText(task.getDueTime().toString());
        this.add(taskDueTime);

        deleteTask.setPreferredSize(new Dimension(40,20));
        deleteTask.setFont(new Font(null, Font.PLAIN, 10));
        deleteTask.addActionListener(this);
        this.add(deleteTask);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteTask) {
            try {
                taskDao.delete(task.getID());
                this.listener.onButtonClicked();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
