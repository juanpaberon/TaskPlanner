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

public class Displayer extends JScrollPane {

    Frame frame;
    JScrollPane scrollPane;
    JPanel panel;
    TaskDaoImplementation taskDao = new TaskDaoImplementation();
    List<Task> allTasks;

    public Displayer(Frame mainFrame) {
        this.frame = mainFrame;

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setPreferredSize(new Dimension(390,200));

        update();

    }

    public void createMainPanel() {
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(390,200));
        this.panel.setBackground(Color.lightGray);
        this.panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        this.setViewportView(this.panel);
    }

    public void update(){

        if (!(this.panel == null)) {
            this.panel.removeAll();
        }

        createMainPanel();

        try {
            allTasks = taskDao.getTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Task task : allTasks) {
            addTaskDisplay(task);
        }

        this.panel.revalidate();
        this.panel.repaint();

        this.revalidate();
        this.repaint();

    }

    private void addTaskDisplay(Task task) {
        TaskPanel taskPanel = new TaskPanel(task, this.frame);
        this.panel.add(taskPanel);
    }


}
