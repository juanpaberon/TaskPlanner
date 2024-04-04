import com.database.TaskDaoImplementation;
import com.model.Task;

import java.sql.*;
import java.time.LocalDateTime;

public class TaskPlanner {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");

        TaskDaoImplementation taskDao = new TaskDaoImplementation();

        int taskID = 1;
        Task task = taskDao.getTask(taskID);
        System.out.println(task);
    }
}
