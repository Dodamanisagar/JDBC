package MySql.Crud.Creat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingDataUsingPreparedStatement {

    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO lib_template (ID,CODE,NAME,DESCRIPTION, PARENT , MODEL_TYPE_ID , MODIFIED_DATE , DEFAULT_PROPERTY , CREATED_BY,IS_VIEW,IS_ABSTRACT) "+
                                       " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = getConnectionObject();

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "gold");
            pstmt.setString(3, "gold");
            pstmt.setString(4, "gold");

            pstmt.setInt(5, 1);
            pstmt.setInt(6,  3);
            pstmt.setString(7, "2022-02-27");
            pstmt.setString(8, " ");

            pstmt.setString(9, "admin");
            pstmt.setInt(10, 0);
            pstmt.setInt(11, 0);

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected !!");
            connection.close();

    }
}
