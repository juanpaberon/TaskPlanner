package com.gui;

import javax.swing.JFrame;

public class Frame extends JFrame implements ButtonClickListener {

    public Frame() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        DisplayTask displayTask = new DisplayTask(this);
        this.add(displayTask);

        AddNewTask addNewTaskPanel = new AddNewTask(this,0,200,400,200);
        this.add(addNewTaskPanel);

        this.setVisible(true);
    }

    @Override
    public void onButtonClicked() {

    }
}
