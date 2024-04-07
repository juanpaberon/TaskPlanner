import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.database.TaskDaoImplementation;
import com.model.Task;
import com.gui.Frame;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TaskPlanner {

    public static void main(String[] args) throws SQLException {

        TaskDaoImplementation taskDao = new TaskDaoImplementation();

        Object[][] data = {};
        String[] columnNames = {"Name", "Time created"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);


        List<Task> allTasks = taskDao.getTasks();

        for (Task task : allTasks) {
            model.addRow(new Object[]{task.getName(), task.getTimeCreated()});
        }

        Frame frame = new Frame();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);

    }
}
