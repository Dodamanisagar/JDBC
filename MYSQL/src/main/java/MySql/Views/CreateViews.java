package MySql.Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateViews {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://host.docker.internal:3307/gdm5", "gdm5", "gdm5");
            if (connection != null) System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        withParameter();
    }
    public static void withParameter() throws SQLException {
        Connection connection=getConnectionObject();
        Statement stmt= connection.createStatement();
        String onNameAndSkill="create view gettingEmpDetails\n " +
                " as\n " +
                " select *\n " +
                " from emp ";
         stmt.executeUpdate(onNameAndSkill);
        System.out.println("created successfully");
        connection.close();
    }
}
