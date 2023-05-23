package MySql.StoredProcedure.CallableStatements;

import java.sql.*;

public class CallableStatementWithInput {
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
        CallableStatementWithInput csdemo=new CallableStatementWithInput();
        csdemo.inPutParameter();
    }
    private void inPutParameter() throws SQLException {
        Connection conn=getConnectionObject();
        String query="{call GetEmployeeAgeOnSkills(?)}";
        CallableStatement clstmt=conn.prepareCall(query);
        clstmt.setString(1,"java");
        ResultSet rs= clstmt.executeQuery();
        while(rs.next())
        {
            int age=rs.getInt("AGE");
            System.out.println("age of the employee:");
            System.out.println("AGE: "+age);

        }
        rs.close();
        clstmt.close();
        conn.close();
    }
}
