import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.database.TaskDaoImplementation;
import com.gui.DisplayTask;
import com.model.Task;
import com.gui.Frame;
import com.gui.AddNewTask;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskPlanner {

    public static void main(String[] args) throws SQLException {

        Frame frame = new Frame();
        frame.setLayout(null);

        DisplayTask displayTask = new DisplayTask(frame);
        frame.add(displayTask);
        AddNewTask addNewTaskPanel = new AddNewTask(0,200,400,200);
        frame.add(addNewTaskPanel);

        frame.setVisible(true);

    }
}
