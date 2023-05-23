package MySql.StoredProcedure.CallableStatements;

import java.sql.*;
import java.util.Scanner;

public class WithMultipleInputAndOutputParameter {
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
        WithMultipleInputAndOutputParameter csdemo=new WithMultipleInputAndOutputParameter();
        Scanner scanner=new Scanner(System.in);
        while(true)
        {
            System.out.println("enter id:-");
            int empid=scanner.nextInt();
            System.out.println("enter name:-");
            String name=scanner.next();
            if(empid==0 && name==null)
                break;
            csdemo.inPutParameter(empid,name);
        }
    }
    private void inPutParameter(int id,String name) throws SQLException {
        Connection conn=getConnectionObject();
        String query="{call MultipleInPutOutPut(?,?,?,?,?)}";
        CallableStatement clstmt=conn.prepareCall(query);
        clstmt.setInt(1,id);
        clstmt.setString(2,"sagar");
        clstmt.registerOutParameter(3, Types.INTEGER);
        clstmt.registerOutParameter(4, Types.VARCHAR);
        clstmt.registerOutParameter(5, Types.INTEGER);
        clstmt.executeQuery();

        int AGE=clstmt.getInt(3);
        String SKILL=clstmt.getString(4);
        long PHONE=clstmt.getLong(5);

        System.out.println("AGE :"+AGE);
        System.out.println("SKILL :"+SKILL);
        System.out.println("PHONE :"+PHONE);

        clstmt.close();
        clstmt.close();
        conn.close();
    }
}
