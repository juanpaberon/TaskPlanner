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
    JPanel panel;
    TaskDaoImplementation taskDao = new TaskDaoImplementation();
    List<Task> allTasks;

    public Displayer(Frame mainFrame) {
        this.frame = mainFrame;

        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setPreferredSize(new Dimension(410,200));

        update();

    }

    public void createMainPanel(int totalTask) {
        this.panel = new JPanel();

        int height = Math.max(200, totalTask * 65);

        this.panel.setPreferredSize(new Dimension(390,height));
        this.panel.setBackground(Color.lightGray);
        this.panel.setLayout(null);

        this.setViewportView(this.panel);
    }

    public void update(){

        if (!(this.panel == null)) {
            this.panel.removeAll();
        }

        try {
            allTasks = taskDao.getTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        createMainPanel(allTasks.size());

        int counter = 0;
        for (Task task : allTasks) {
            if (task.getTimeFinished() == null) {
                addTaskDisplay(task, counter);
                counter++;
            }
        }

        this.panel.revalidate();
        this.panel.repaint();

        this.revalidate();
        this.repaint();

    }

    private void addTaskDisplay(Task task, int counter) {
        TaskPanel taskPanel = new TaskPanel(task, this.frame, counter);
        this.panel.add(taskPanel);
    }


}
