package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewTask extends JPanel implements ActionListener {

    Frame frame;
    int width;
    int height;
    JPanel inputNamePanel = new JPanel();
    JLabel nameLabel = new JLabel();
    JTextField nameTextField = new JTextField();
    JButton button = new JButton("Add task");

    public AddNewTask(Frame mainFrame, int x, int y, int width, int height) {
        this.frame = mainFrame;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        inputNamePanel.setBounds(0,0, 100,50);
        inputNamePanel.setLayout(new BorderLayout());
        this.add(inputNamePanel);

        nameLabel.setPreferredSize(new Dimension(100,25));
        nameLabel.setText("Task Name");
        inputNamePanel.add(nameLabel, BorderLayout.NORTH);

        nameTextField.setPreferredSize(new Dimension(100,25));
        nameTextField.setText("Task Name");
        inputNamePanel.add(nameTextField, BorderLayout.SOUTH);

        button.setBounds(100,75,100,50);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            nameTextField.getText();
            this.frame.onButtonClicked();
        }
    }
}
