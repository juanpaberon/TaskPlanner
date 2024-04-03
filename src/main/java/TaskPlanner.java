import java.sql.*;

public class TaskPlanner {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taskPlanner",
                    "root", "root");

            Statement statement;
            statement = connection.createStatement();
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
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
