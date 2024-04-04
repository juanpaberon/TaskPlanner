package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    int ID;
    String name;
    int parentTaskID;
    String description;
    LocalDateTime timeCreated;
    LocalTime dueTime;
    LocalDate dueDate;

    public Task(int ID, String name, LocalDateTime timeCreated) {
        this.ID = ID;
        this.name = name;
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Task ID: " + ID + ". Name: " + name + ". Time Created: " + timeCreated;
    }


}
