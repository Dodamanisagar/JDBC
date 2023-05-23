package MySql.Crud.Delete;

import java.sql.*;

public class DeleteProfileOnDeletingModel {
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
        // Open a connection
        deleteProfile();
    }

    public static void deleteProfile() throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();
        String sql = "ALTER TABLE lib_PROFILE\n" +
                "ADD FOREIGN KEY(MODEL_ID) REFERENCES LIB_MODEL(ID) ON DELETE CASCADE";
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql);
        conn.close();
    }
}
