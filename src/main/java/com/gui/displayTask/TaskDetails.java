package com.gui.displayTask;

import com.model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskDetails extends JFrame {

    public TaskDetails(Task task) {
        this.setSize(420, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        this.setTitle("Task details");

        JLabel taskName = new JLabel("Task Name");
        taskName.setPreferredSize(new Dimension(100, 20));
        taskName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(taskName);

        this.setVisible(true);
    }
}
