package MySql.Crud.Creat;

import java.sql.*;

public class CreateDatabase {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException
    {
        // Open a connection
        Connection conn =getConnectionObject();
             Statement stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS MYSQLDATABASE";
           // String sql1="DROP DATABASE MYSQLDATABASE";
            stmt.executeUpdate(sql);
          //  stmt.executeUpdate(sql1);
            System.out.println("Database created successfully...");
            conn.close();
    }
}