import com.database.TaskDaoImplementation;
import com.model.Task;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class TaskPlanner {

    public static void main(String[] args) throws SQLException {

        TaskDaoImplementation taskDao = new TaskDaoImplementation();

        int taskID = 1;
        Task task = taskDao.getTask(taskID);
        System.out.println(task);

        List<Task> allTasks = taskDao.getTasks();
        for (Task taskList : allTasks) {
            System.out.println(taskList);
        }

        String newTaskName = "Change oil";
        LocalDateTime newTaskCreationTime = LocalDateTime.of(2024,4,5,15,30);
        Task newTask = new Task(-1, newTaskName, newTaskCreationTime);
        int addResult = taskDao.add(newTask);
        System.out.println(addResult);

        allTasks = taskDao.getTasks();
        for (Task taskList : allTasks) {
            System.out.println(taskList);
        }

        taskDao.delete(3);

        allTasks = taskDao.getTasks();
        for (Task taskList : allTasks) {
            System.out.println(taskList);
        }
    }
}
