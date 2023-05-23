package MySql.StoredProcedure.CallableStatements;

import java.sql.*;
import java.util.Scanner;

public class WithInputAndOutputParameters {
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
        WithInputAndOutputParameters csdemo=new WithInputAndOutputParameters();
        Scanner scanner=new Scanner(System.in);
        while(true)
        {
            System.out.println("enter id:-");
            int empid=scanner.nextInt();
            if(empid==0)
                break;
            csdemo.inPutParameter(empid);
        }
    }
    private void inPutParameter(int id) throws SQLException {
        Connection conn=getConnectionObject();
        String query="{call inPutOutPut(?,?)}";
        CallableStatement clstmt=conn.prepareCall(query);
        clstmt.setInt(1,id);
        clstmt.registerOutParameter(2, Types.VARCHAR);
        clstmt.executeQuery();

        String name=clstmt.getString(2);
        System.out.println("name of the employee:-");
        System.out.println(name);

        clstmt.close();
        clstmt.close();
        conn.close();
    }
}
