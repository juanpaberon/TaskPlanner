import java.sql.SQLException;
import java.time.LocalDateTime;

import com.gui.Frame;
import com.gui.displayTask.TaskDetails;
import com.model.Task;

public class TaskPlanner {

    public static void main(String[] args) throws SQLException {

        String newTaskName = "Change oil";
        LocalDateTime newTaskCreationTime = LocalDateTime.of(2024,4,5,15,30);
        Task newTask = new Task(-1, newTaskName, newTaskCreationTime);

        TaskDetails taskDetails = new TaskDetails(newTask);
//        Frame frame = new Frame();


    }
}
