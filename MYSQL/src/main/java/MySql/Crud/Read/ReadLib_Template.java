package MySql.Crud.Read;

import java.sql.*;

public class ReadLib_Template {

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

            //get connection to data base
            Connection db= getConnectionObject();
            //creat statement 1
            PreparedStatement myState2=db.prepareStatement("select * from lib_template where name=?");
            myState2.setString(1,"soil");
            //execute query
            ResultSet myResult5=myState2.executeQuery();

            //process the result set
            while (myResult5.next())
            {
                System.out.println("ID : " + myResult5.getInt(1));
                System.out.println("CODE : " + myResult5.getString(2));
                System.out.println("NAME : " + myResult5.getString(3));
                System.out.println("DESCRIPTION : " + myResult5.getString(4));
                System.out.println("PARENT : " + myResult5.getInt(5));
                System.out.println("MODEL_TYPE_ID : " + myResult5.getInt(6));
                System.out.println("MODIFIED_DATE : " + myResult5.getString(7));
                System.out.println("CREATED_BY : " + myResult5.getString(9));

                System.out.println("----------------------*******-------------------------");

            }
            db.close();
    }
}
