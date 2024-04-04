package com.database;

import com.model.Task;
import com.database.DatabaseConnection;
import com.mysql.cj.protocol.a.LocalDateValueEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImplementation implements TaskDao{

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Task task) throws SQLException {
        String query = "INSERT INTO Task VALUES" +
                "(NULL, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, task.getName());
        ps.setInt(2, task.getParentTaskID());
        ps.setString(3, task.getDescription());
        ps.setTimestamp(4, Timestamp.valueOf(task.getTimeCreated()));
        ps.setTime(5, Time.valueOf(task.getDueTime()));
        ps.setDate(6, Date.valueOf(task.getDueDate()));

        return ps.executeUpdate();
    }

    @Override
    public void delete(int taskID) throws SQLException {

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
        List<Task> taskList = new ArrayList();
        return taskList;
    }

    @Override
    public void update(Task task) throws SQLException {

    }
}
