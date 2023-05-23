package MySql.Crud.Update;

import java.sql.*;

public class UpdateTable {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    static final String QUERY = "SELECT * FROM lib_template";

    public static void main(String[] args) throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();
        String sql = "UPDATE lib_template " +
                "SET name = 'steel' WHERE id in (7)";
        stmt.executeUpdate(sql);
        ResultSet rs = stmt.executeQuery(QUERY);
        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("ID"));
            System.out.print(", code: " + rs.getString("CODE"));
            System.out.print(", name: " + rs.getString("NAME"));
            System.out.println(", description: " + rs.getString("DESCRIPTION"));
        }
        rs.close();
    }
}
