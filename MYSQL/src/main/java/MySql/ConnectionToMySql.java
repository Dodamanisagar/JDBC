package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToMySql {

    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/gdm9", "gdm9", "gdm9");//(particulare database url,user,password of the database)
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return;
        } finally
        {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

/*    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String URL="jdbc:mysql://localhost:3307/gdm9";
    static final String USER="gdm9";
    static final String PASS="gdm9";
    public static void main(String[] argv) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        Class.forName(JDBC_DRIVER);
        System.out.println("MySQL JDBC Driver Registered!");
        conn = DriverManager.getConnection(URL, USER, PASS);
        stmt = conn.createStatement();
        String sql = "CREATE DATABASE MYSQLDEMO";
        stmt.executeUpdate(sql);
        System.out.println("database is being created");
        ;
        stmt.close();
        conn.close();
    }*/

}

