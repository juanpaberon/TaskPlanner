package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private int ID;
    private String name;
    private int parentTaskID;
    private String description;
    private LocalDateTime timeCreated;
    private LocalTime dueTime;
    private LocalDate dueDate;

    public Task(int ID, String name, LocalDateTime timeCreated) {
        this.ID = ID;
        this.name = name;
        this.timeCreated = timeCreated;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getParentTaskID() {
        return parentTaskID;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setID(int newID) {
        ID = newID;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setParentTaskID(int newParentTaskID) {
        parentTaskID = newParentTaskID;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setTimeCreated(LocalDateTime newTimeCreated) {
        this.timeCreated = newTimeCreated;
    }

    public void setDueTime(LocalTime newDueTime) {
        this.dueTime = newDueTime;
    }

    public void setDueDate(LocalDate newDueDate) {
        this.dueDate = newDueDate;
    }

    @Override
    public String toString() {
        return "Task ID: " + ID + ". Name: " + name + ". Time Created: " + timeCreated;
    }


}
