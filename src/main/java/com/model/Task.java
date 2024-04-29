package com.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private int ID;
    private String name;
    private int parentTaskID;
    boolean description = false;
    String descriptionContent = null;
    private LocalDateTime timeCreated;
    private LocalTime dueTime = null;
    private LocalDate dueDate = null;
    private LocalDateTime timeFinished = null;

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

    public boolean getDescription() {
        return description;
    }

    public String getDescriptionContent() {
        return descriptionContent;
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
    public LocalDateTime getTimeFinished() {
        return timeFinished;
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

    public void setDescription(boolean newDescription) {
        this.description = newDescription;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
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
    public void setTimeFinished(LocalDateTime newTimeFinished) {
        this.timeFinished = newTimeFinished;
    }

    @Override
    public String toString() {
        return "Task ID: " + ID + ". Name: " + name + ". Time Created: " + timeCreated;
    }


}
