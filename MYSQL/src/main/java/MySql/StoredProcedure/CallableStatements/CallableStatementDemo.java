package MySql.StoredProcedure.CallableStatements;

import java.sql.*;

public class CallableStatementDemo {
    private static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        CallableStatementDemo csdemo=new CallableStatementDemo();
        csdemo.getEmployeeDetail();
    }

    private void getEmployeeDetail() throws SQLException {
        Connection conn=getConnectionObject();
        String query="{call getall()}";
        CallableStatement clstmt=conn.prepareCall(query);
        ResultSet rs= clstmt.executeQuery();
        while(rs.next())
        {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int age=rs.getInt("age");
            long phone=rs.getLong("phone");
            String address=rs.getString("address");
            String skills=rs.getString("skill");

            System.out.println("ID: "+id);
            System.out.println("NAME: "+name);
            System.out.println("AGE: "+age);
            System.out.println("PHONE: "+phone);
            System.out.println("ADDRESS: "+address);
            System.out.println("SKILLS: "+skills);
            System.out.println("****************************");
        }
        rs.close();
        clstmt.close();
        conn.close();
    }
}
