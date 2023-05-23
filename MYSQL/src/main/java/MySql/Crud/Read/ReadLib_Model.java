package MySql.Crud.Read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadLib_Model {

    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) {
        try
        {

            //get connection to data base
            Connection db= getConnectionObject();

            //creat statement 1
            PreparedStatement myState1=db.prepareStatement("select * from lib_model where template_id in(select id from lib_template  where name=?)");
            myState1.setString(1,"soil");
            //execute query
            ResultSet myResult1=myState1.executeQuery();

            //process the result set
            while (myResult1.next())
            {
                System.out.println("ID : " + myResult1.getInt(1));
                System.out.println("Name : " + myResult1.getString(2));
                System.out.println("Description " + myResult1.getString(3));
                System.out.println("Category : " + myResult1.getString(5));
                System.out.println("----------------------*******-------------------------");

            }
            db.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
