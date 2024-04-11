package com.gui.displayTask;

import com.database.TaskDaoImplementation;
import com.gui.Frame;
import com.model.Task;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Displayer extends JPanel {

    Frame frame;

    TaskDaoImplementation taskDao = new TaskDaoImplementation();
    List<Task> allTasks;

    public Displayer(Frame mainFrame) {
        this.frame = mainFrame;

        this.setPreferredSize(new Dimension(390,200));
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        update();

    }

    public void update(){

        this.removeAll();

        try {
            allTasks = taskDao.getTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Task task : allTasks) {
            addTaskDisplay(task);
        }

        this.repaint();
        this.revalidate();

    }

    private void addTaskDisplay(Task task) {
        TaskPanel taskPanel = new TaskPanel(task, this.frame);
        this.add(taskPanel);
    }


}
