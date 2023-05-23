package MySql.StoredProcedure.CreateStoredProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProcedureWithMultipleParameter {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
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
        String onNameAndSkill="CREATE PROCEDURE search(IN EMPNAME VARCHAR(20),IN EMPSKILL VARCHAR(20))\n" +
                "BEGIN\n" +
                "SELECT *\n" +
                "FROM EMPLOYEE\n" +
                "WHERE NAME=EMPNAME AND SKILL=EMPSKILL;\n" +
                "END";
       // stmt.executeUpdate(onNameAndSkill);
        System.out.println("created successfully");
        connection.close();
    }
}
