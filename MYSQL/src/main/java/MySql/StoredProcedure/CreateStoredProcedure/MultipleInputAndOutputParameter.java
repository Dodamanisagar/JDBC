package MySql.StoredProcedure.CreateStoredProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MultipleInputAndOutputParameter {
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
        withInputAndOutputParameter();
    }
    public static void withInputAndOutputParameter() throws SQLException {
        Connection connection=getConnectionObject();
        Statement stmt= connection.createStatement();

        String inputOutput="CREATE PROCEDURE MultipleInPutOutPut(IN EMPid VARCHAR(20),IN EMPNAME VARCHAR(20),OUT EMPAGE INT(3),OUT EMPSKILL VARCHAR(20),OUT EMPPHONE INT(10))\n" +
                "BEGIN\n" +
                "SELECT AGE,SKILL,PHONE into EMPAGE,EMPSKILL,EMPPHONE\n" +
                "FROM EMPLOYEE\n" +
                "WHERE id=EMPid AND NAME=EMPNAME;\n" +
                "END";
        stmt.executeUpdate(inputOutput);
        System.out.println("created successfully");
        connection.close();
    }
}
