package com.gui.displayTask;

import com.database.TaskDaoImplementation;
import com.gui.Frame;
import com.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        Task testTask = new Task(1, "Clean dishes", LocalDateTime.now());
        addTaskDisplay(testTask);
    }

    public void update(){

        try {
            allTasks = taskDao.getTasks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void addTaskDisplay(Task task) {
        task.setDueDate(LocalDate.now());
        task.setDueTime(LocalTime.now());
        TaskPanel taskPanel = new TaskPanel(task);
        this.add(taskPanel);
    }


}
