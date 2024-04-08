package com.gui;

import javax.swing.JFrame;
import java.sql.SQLException;

public class Frame extends JFrame implements ButtonClickListener {

    DisplayTask displayTask;
    public Frame() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.displayTask = new DisplayTask(this);
        this.add(this.displayTask);

        AddNewTask addNewTaskPanel = new AddNewTask(this,0,200,400,200);
        this.add(addNewTaskPanel);

        this.setVisible(true);
    }

    @Override
    public void onButtonClicked() {
        this.displayTask.update();
    }
}
