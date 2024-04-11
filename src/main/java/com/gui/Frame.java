package com.gui;

import javax.swing.JFrame;
import java.awt.*;
import java.sql.SQLException;

import com.gui.displayTask.Displayer;

public class Frame extends JFrame implements ButtonClickListener {

    DisplayTask displayTask;
    Displayer taskDisplayer;
    public Frame() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

//        this.displayTask = new DisplayTask(this);
//        this.add(this.displayTask);

        this.taskDisplayer = new Displayer(this);
        this.add(this.taskDisplayer);

        AddNewTask addNewTaskPanel = new AddNewTask(this,390,200);
        this.add(addNewTaskPanel);

        this.setVisible(true);
    }

    @Override
    public void onButtonClicked() {
        this.displayTask.update();
    }
}
