package MySql.StoredProcedure.CreateStoredProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProcedureWithoutParameter {
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
        createStoredProcedure();
    }
    public static void createStoredProcedure() throws SQLException {
        Connection conn =getConnectionObject();
        Statement stmt = conn.createStatement();

        String storedProcedure1="CREATE PROCEDURE `retrieveData`() " +
                "BEGIN "+
                " SELECT * FROM employee; "+
                "END";
       // stmt.executeUpdate(storedProcedure1);

        String GetEmployeeAge="CREATE PROCEDURE `GetEmployeeAge`()" +
                "BEGIN "+
                " SELECT "+
                " age "+
                " FROM "+
                " employee;"+
                "END";
       // stmt.executeUpdate(GetEmployeeAge);

        String GetEmployeeId="CREATE PROCEDURE `GetEmployeeId`()\n" +
                "BEGIN\n" +
                "\tSELECT \n" +
                "\t\tID\n" +
                "\tFROM\n" +
                "\t\temployee;    \n" +
                "END";
        //stmt.executeUpdate(GetEmployeeId);
        String GetEmployeeName="CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEmployeeName`()\n" +
                "BEGIN\n" +
                "\tSELECT \n" +
                "\t\tname\n" +
                "\tFROM\n" +
                "\t\temployee;    \n" +
                "END";
       // stmt.executeUpdate(GetEmployeeName);
        String GetEmployeePhoneNumber="CREATE DEFINER=`root`@`localhost` PROCEDURE `GetEmployeePhoneNumber`()\n" +
                "BEGIN\n" +
                "\tSELECT \n" +
                "\t\tPHONE\n" +
                "\tFROM\n" +
                "\t\temployee;    \n" +
                "END";
        stmt.executeUpdate(GetEmployeePhoneNumber);
        conn.close();
    }
}
