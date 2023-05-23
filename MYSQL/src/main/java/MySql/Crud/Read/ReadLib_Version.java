package MySql.Crud.Read;

import java.sql.*;

public class ReadLib_Version {

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
        Connection db = getConnectionObject();

        //creat statement 1
        PreparedStatement myState2 = db.prepareStatement("select * from lib_version where profile_id IN (select id from lib_profile where model_id IN (select id from lib_model where name=?))");
        myState2.setString(1, "SOIL");
        //execute query
        ResultSet myResult4 = myState2.executeQuery();

        //process the result set
        while (myResult4.next()) {
            System.out.println("ID : " + myResult4.getString(1));
            System.out.println("PROFILE ID : " + myResult4.getString(2));

            System.out.println("----------------------*******-------------------------");

        }
        db.close();
    }
}
