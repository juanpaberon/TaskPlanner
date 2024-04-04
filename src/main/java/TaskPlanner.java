import com.database.DatabaseConnection;

import java.sql.*;

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
            while (resultSet.next()) {
                taskId = resultSet.getInt("ID");
                taskName = resultSet.getString("name").trim();
                System.out.println("id : " + taskId
                        + " name : " + taskName);
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
