package com.gui;

import javax.swing.*;
import java.awt.*;

import com.gui.displayTask.Displayer;

public class Frame extends JFrame implements ButtonClickListener {

    Displayer taskDisplayer;
    public Frame() {
        this.setSize(420, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        this.taskDisplayer = new Displayer(this);
        this.add(this.taskDisplayer);

        AddNewTask addNewTaskPanel = new AddNewTask(this,390,200);
        this.add(addNewTaskPanel);

        this.setVisible(true);
    }

    @Override
    public void onButtonClicked() {
        this.taskDisplayer.update();
    }
}
