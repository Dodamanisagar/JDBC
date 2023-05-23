package MySql.StoredProcedure.CreateStoredProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProcedureWithParameter {
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
         withParameterStoredProcedure();
    }
    public static void withParameterStoredProcedure() throws SQLException {
        Connection conn=getConnectionObject();
        Statement stmt= conn.createStatement();
        String getAll="CREATE PROCEDURE `GETALL`(IN EMPID INT) \n" +
                " BEGIN \n" +
                " SELECT * FROM employee\n" +
                " WHERE ID=EMPID; \n" +
                " END";
        //stmt.executeUpdate(getAll);

        String getAgeOnSkill="CREATE PROCEDURE `GetEmployeeAgeOnSkills`(in empSkills varchar(20) )\n" +
                "BEGIN  \n" +
                "SELECT  age  \n" +
                "FROM  employee\n" +
                "where skill=empSkills;\n" +
                "END";
        stmt.executeUpdate(getAgeOnSkill);

       /**
        * in mysql:-
        DELIMITER $$
        CREATE PROCEDURE `GetEmployeeSkills`(in empSkills varchar(20) )
        BEGIN
        SELECT  age
        FROM  employee
        where skill=empSkills;
        END$$
        */
        System.out.println("stored procedure created successfully");
        conn.close();
    }
}
