import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.database.TaskDaoImplementation;
import com.model.Task;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDaoTest {

    static void cleanDatabase() throws SQLException  {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");
        List<Task> allTasks = taskDao.getTasks();

        for (Task task : allTasks) {
            taskDao.delete(task.getID());
        }
    }

    @Test
    void addTaskTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        String newTaskName = "Change oil";
        LocalDateTime newTaskCreationTime = LocalDateTime.of(2024,4,5,15,30);
        Task newTask = new Task(-1, newTaskName, newTaskCreationTime);
        taskDao.add(newTask);

        List<Task> allTasks = taskDao.getTasks();
        Assertions.assertEquals(1, allTasks.size());
        cleanDatabase();
    }
}
