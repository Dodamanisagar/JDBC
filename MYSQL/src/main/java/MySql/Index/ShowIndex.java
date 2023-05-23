package MySql.Index;

import java.sql.*;

public class ShowIndex {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void creatTable() throws SQLException {
        Connection conn=getConnectionObject();
        Statement stmt=conn.createStatement();
        String index="CREATE TABLE contacts(" +
                " contact_id INT AUTO_INCREMENT," +
                " first_name VARCHAR(100) NOT NULL," +
                " last_name VARCHAR(100) NOT NULL," +
                " email VARCHAR(100)," +
                " phone VARCHAR(20)," +
                " PRIMARY KEY(contact_id)," +
                " UNIQUE(email)," +
                " INDEX phone(phone)," +
                " INDEX name(first_name, last_name) comment 'By first name and/or last name'" +
                ") ";
        stmt.executeUpdate(index);
        System.out.println("table created successfully");

    }
    public static void showIndexes() throws SQLException {
        Connection conn =getConnectionObject();
        Statement stmt = conn.createStatement();
        String showIndex="SHOW INDEXES FROM contacts";
        ResultSet rs = stmt.executeQuery(showIndex);
        while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println();
            System.out.println("\n---------------------------------");

        }
        conn.close();
        System.out.println("indexes of contacts");


    }
    public static void main(String[] args) throws SQLException {

    }
}
