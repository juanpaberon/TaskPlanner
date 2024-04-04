import com.database.DatabaseConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.ResultSet;

public class TaskPlanner {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Connection con = DatabaseConnection.getConnection();

        try {
            Statement statement;
            statement = con.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT * FROM Task");
            int taskId;
            String taskName;
            Timestamp timeCreated;
            while (resultSet.next()) {
                taskId = resultSet.getInt("ID");
                taskName = resultSet.getString("name").trim();
                timeCreated = resultSet.getTimestamp("timeCreated");
                System.out.println("id : " + taskId
                        + " name : " + taskName + " timeCreated:" + timeCreated);
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
