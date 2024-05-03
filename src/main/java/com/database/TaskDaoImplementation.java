package com.database;

import com.model.Task;
import com.database.DatabaseConnection;
import com.mysql.cj.protocol.a.LocalDateValueEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskDaoImplementation implements TaskDao{

    Connection con = DatabaseConnection.getConnection();

    public TaskDaoImplementation() {}

    public TaskDaoImplementation(String purpose) {
        if (purpose.equals("Test")) {
            con = DatabaseConnectionTest.getConnection();
        }
    }

    @Override
    public int add(Task task) throws SQLException {
        String query = "INSERT INTO `Task` VALUES" +
                "(NULL, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, task.getName());
        ps.setInt(2, task.getParentTaskID());
        ps.setBoolean(3, task.getDescription());
        ps.setTimestamp(4, Timestamp.valueOf(task.getTimeCreated()));

        LocalTime taskDueTime = task.getDueTime();
        if (taskDueTime == null) {
            ps.setNull(5, Types.TIME);
        } else {
            ps.setTime(5, Time.valueOf(taskDueTime));
        }

        LocalDate taskDueDate = task.getDueDate();
        if (taskDueDate == null) {
            ps.setNull(6, Types.TIME);
        } else {
            ps.setDate(6, Date.valueOf(taskDueDate));
        }

        LocalDateTime taskTimeFinished = task.getTimeFinished();
        if (taskTimeFinished == null) {
            ps.setNull(7, Types.TIMESTAMP);
        } else {
            ps.setTimestamp(7, Timestamp.valueOf(taskTimeFinished));
        }

        if (task.getDescription()) {
            addDescription(task);
        }

        return ps.executeUpdate();
    }

    @Override
    public void delete(int taskID) throws SQLException {
        String query = "DELETE FROM Task WHERE ID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, taskID);
        ps.executeUpdate();
    }

    @Override
    public Task getTask(int taskID) throws SQLException {

        String query = "SELECT * FROM Task WHERE ID = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, taskID);
        ResultSet rs = ps.executeQuery();

        String name = "";
        LocalDateTime timeCreated = LocalDateTime.now();
        boolean check = false;

        while (rs.next()) {
            check = true;
            name = rs.getString("name");
            timeCreated = rs.getTimestamp("timeCreated").toLocalDateTime();
        }
        if (check) {
            return new Task(taskID, name, timeCreated);
        } else {
            return null;
        }
    }

    @Override
    public List<Task> getTasks() throws SQLException {
        String query = "SELECT * FROM Task";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Task> taskList = new ArrayList();
        while (rs.next()) {
            int taskID = rs.getInt("ID");
            String name = rs.getString("name");
            LocalDateTime timeCreated = rs.getTimestamp("timeCreated").toLocalDateTime();
            Task task = new Task(taskID, name, timeCreated);
            if (!(rs.getDate("dueDate") == null)) {
                task.setDueDate(rs.getDate("dueDate").toLocalDate());
            }
            if (!(rs.getTime("dueTime") == null)) {
                task.setDueTime(rs.getTime("dueTime").toLocalTime());
            }
            task.setDescription(rs.getBoolean("description"));
            if (task.getDescription()) {
                task.setDescriptionContent(readDescription(task));
            }
            if (!(rs.getTimestamp("timeFinished") == null)) {
                task.setTimeFinished(rs.getTimestamp("timeFinished").toLocalDateTime());
            }
            taskList.add(task);
        }
        return taskList;
    }

    @Override
    public void update(Task task) throws SQLException {
        String query = "UPDATE Task " +
                "SET name=?, parentTaskID=?, description=?, timeCreated=?, dueTime=?, dueDate=?, timeFinished=? " +
                "WHERE ID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, task.getName());
        ps.setInt(2, task.getParentTaskID());
        ps.setBoolean(3, task.getDescription());
        ps.setTimestamp(4, Timestamp.valueOf(task.getTimeCreated()));

        LocalTime taskDueTime = task.getDueTime();
        if (taskDueTime == null) {
            ps.setNull(5, Types.TIME);
        } else {
            ps.setTime(5, Time.valueOf(taskDueTime));
        }

        LocalDate taskDueDate = task.getDueDate();
        if (taskDueDate == null) {
            ps.setNull(6, Types.TIME);
        } else {
            ps.setDate(6, Date.valueOf(taskDueDate));
        }

        LocalDateTime taskTimeFinished = task.getTimeFinished();
        if (taskTimeFinished == null) {
            ps.setNull(7, Types.TIMESTAMP);
        } else {
            ps.setTimestamp(7, Timestamp.valueOf(taskTimeFinished));
        }

        ps.setInt(8, task.getID());

        if (task.getDescription()) {
            addDescription(task);
        }

        ps.executeUpdate();
    }

    public void addDescription(Task task) {
        try {
            FileWriter descriptionFile = new FileWriter("database\\descriptions\\" + task.getID() + ".txt", false);
            descriptionFile.write(task.getDescriptionContent());
            descriptionFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readDescription(Task task) {
        StringBuilder description = new StringBuilder();
        try {
            File descriptionFile = new File("database\\descriptions\\" + task.getID() + ".txt");
            Scanner descriptionReader = new Scanner(descriptionFile);
            while (descriptionReader.hasNextLine()) {
                if (!description.toString().equals("")) {
                    description.append(System.lineSeparator());
                }
                String data = descriptionReader.nextLine();
                description.append(data);
            }
            descriptionReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return description.toString();
    }
}
