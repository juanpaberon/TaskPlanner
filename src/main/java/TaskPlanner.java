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

//        Connection con = DatabaseConnection.getConnection();
//
//        try {
//            Statement statement;
//            statement = con.createStatement();
//            ResultSet resultSet;
//            resultSet = statement.executeQuery(
//                    "SELECT * FROM Task");
//            int taskId;
//            String taskName;
//            LocalDateTime timeCreated;
//            while (resultSet.next()) {
//                taskId = resultSet.getInt("ID");
//                taskName = resultSet.getString("name").trim();
//                timeCreated = resultSet.getTimestamp("timeCreated").toLocalDateTime();
//                System.out.println("id : " + taskId
//                        + " name : " + taskName + " timeCreated:" + timeCreated);
//            }
//            resultSet.close();
//            statement.close();
//        }
//        catch (Exception exception) {
//            System.out.println(exception);
//        }
    }
}
