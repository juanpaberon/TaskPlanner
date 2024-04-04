package com.database;

import java.sql.SQLException;
import java.util.List;

import com.model.Task;

public interface TaskDao {

    public int add(Task task) throws SQLException;
    public void delete(int taskID) throws SQLException;
    public Task getTask(int taskID) throws SQLException;
    public List<Task> getTasks() throws SQLException;
    public void update(Task task) throws SQLException;
}
