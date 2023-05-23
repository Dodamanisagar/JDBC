package MySql.Index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateIndex {
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
        Connection conn =getConnectionObject();
        Statement stmt = conn.createStatement();

        String index="CREATE TABLE IF NOT EXISTS IndexTable " +
                " (ID INT  not NULL auto_increment, " +
                " CODE VARCHAR (50) NOT NULL unique, " +
                " NAME VARCHAR (50) NOT NULL UNIQUE, " +
                " DEFAULT_ATTRIBUTE VARCHAR(50), " +
                " ICONID INT," +
                " IS_SYSTEM INT,"+
                " PRIMARY KEY ( ID ),"+
                " index(CODE,NAME)) ";
        stmt.executeUpdate(index);

        String indexForColumn="CREATE INDEX AGE ON employee (AGE)";
        stmt.executeUpdate(indexForColumn);

        System.out.println("table created successfully");
    }
}
