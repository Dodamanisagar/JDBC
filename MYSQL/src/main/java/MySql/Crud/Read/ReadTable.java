package MySql.Crud.Read;

import java.sql.*;

public class ReadTable {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    static final String QUERY = "SELECT * FROM model_type";

    public static void main(String[] args) throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.println();
                System.out.print("code: " + rs.getString("code"));
                System.out.println();
                System.out.print("name: " + rs.getString("name"));
                System.out.println();
                System.out.print("iconid: " + rs.getInt("iconid"));
                System.out.println();
                System.out.print("isSystem: " + rs.getInt("is_system"));
                System.out.println();
                System.out.print("DefaultAttribute: " + rs.getString("Default_Attribute"));
                System.out.println("\n---------------------------------");

            }
          conn.close();
    }
}

