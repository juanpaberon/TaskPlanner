import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.database.TaskDaoImplementation;
import com.model.Task;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDaoTest {

    @Test
    void testDemo() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        String newTaskName = "Change oil";
        LocalDateTime newTaskCreationTime = LocalDateTime.of(2024,4,5,15,30);
        Task newTask = new Task(-1, newTaskName, newTaskCreationTime);
        taskDao.add(newTask);

        List<Task> allTasks = taskDao.getTasks();
        Assertions.assertEquals(1, allTasks.size());

        for (Task task : allTasks) {
            taskDao.delete(task.getID());
        }

        allTasks = taskDao.getTasks();
        Assertions.assertEquals(0, allTasks.size());
    }
}
