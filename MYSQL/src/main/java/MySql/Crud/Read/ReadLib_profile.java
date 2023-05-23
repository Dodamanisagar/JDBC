package MySql.Crud.Read;

import java.sql.*;

public class ReadLib_profile {

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
            PreparedStatement myState2=db.prepareStatement("select * from lib_profile where MODEL_ID IN (select id from lib_model where name=?)");
            myState2.setString(1,"soil");
            //execute query
            ResultSet myResult2=myState2.executeQuery();

            //process the result set
            while (myResult2.next())
            {
                System.out.println("ID : " + myResult2.getInt(1));
                System.out.println("Name : " + myResult2.getString(3));
                System.out.println("Modle name" + myResult2.getString(4));
                System.out.println("----------------------*******-------------------------");

            }
            db.close();
    }
}
