import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.database.TaskDaoImplementation;
import com.model.Task;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class TaskDaoTest {

    static void cleanDatabase() throws SQLException  {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");
        List<Task> allTasks = taskDao.getTasks();

        for (Task task : allTasks) {
            taskDao.delete(task);
        }
    }

    void addTaskDatabase01(TaskDaoImplementation taskDao) throws SQLException {
        String newTaskName = "Change oil";
        LocalDateTime newTaskCreationTime = LocalDateTime.of(2024,4,5,15,30);
        Task newTask = new Task(0, newTaskName, newTaskCreationTime);
        taskDao.add(newTask);
    }

    @Test
    void addTaskTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        addTaskDatabase01(taskDao);

        List<Task> allTasks = taskDao.getTasks();
        Assertions.assertEquals(1, allTasks.size());
        cleanDatabase();
    }


    @Test
    void deleteTaskTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        addTaskDatabase01(taskDao);

        List<Task> allTasks = taskDao.getTasks();
        Task task = allTasks.get(0);
        taskDao.delete(task);
        allTasks = taskDao.getTasks();
        Assertions.assertEquals(0, allTasks.size());
        cleanDatabase();
    }


    @Test
    void deleteTaskDescriptionTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        addTaskDatabase01(taskDao);

        List<Task> allTasks = taskDao.getTasks();
        Task task = allTasks.get(0);
        task.setDescription(true);
        task.setDescriptionContent("Some test description");
        taskDao.update(task);

        int taskID = task.getID();
        File descriptionFile = new File("database\\descriptions\\" + taskID + ".txt");
        Assertions.assertTrue(taskDao.descriptionFileExists(task));
        Assertions.assertFalse(descriptionFile.isDirectory());

        taskDao.delete(task);
        allTasks = taskDao.getTasks();
        Assertions.assertEquals(0, allTasks.size());

        descriptionFile = new File("database\\descriptions\\" + taskID + ".txt");
        Assertions.assertFalse(descriptionFile.exists());
        Assertions.assertFalse(descriptionFile.isDirectory());

        cleanDatabase();
    }


    @Test
    void updateTaskTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        addTaskDatabase01(taskDao);
        List<Task> allTasks = taskDao.getTasks();
        Task task = allTasks.get(0);

        LocalTime dueTime = LocalTime.of(12,5,10);
        task.setDueTime(dueTime);

        LocalDate dueDate = LocalDate.of(2024,4,25);
        task.setDueDate(dueDate);

        LocalDateTime timeFinished = LocalDateTime.of(2024,4,29,23,25,25);
        task.setTimeFinished(timeFinished);

        taskDao.update(task);

        List<Task> allTasksDatabase = taskDao.getTasks();
        Task taskDatabase = allTasksDatabase.get(0);

        Assertions.assertNotEquals(task, taskDatabase);
        Assertions.assertEquals(task.getDueTime(), taskDatabase.getDueTime());
        Assertions.assertEquals(task.getDueDate(), taskDatabase.getDueDate());
        Assertions.assertEquals(task.getTimeFinished(), taskDatabase.getTimeFinished());

        cleanDatabase();
    }


    @Test
    void updateTaskDescriptionTest() throws SQLException {
        TaskDaoImplementation taskDao = new TaskDaoImplementation("Test");

        addTaskDatabase01(taskDao);
        List<Task> allTasks = taskDao.getTasks();
        Task task = allTasks.get(0);
        task.setDescription(true);
        task.setDescriptionContent("Some test description");
        taskDao.update(task);

        Assertions.assertTrue(taskDao.descriptionFileExists(task));

        task.setDescription(false);
        task.setDescriptionContent("");
        taskDao.update(task);

        Assertions.assertFalse(taskDao.descriptionFileExists(task));

        cleanDatabase();
    }
}
