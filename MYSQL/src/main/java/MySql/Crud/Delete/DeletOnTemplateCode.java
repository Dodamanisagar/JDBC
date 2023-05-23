package MySql.Crud.Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletOnTemplateCode {
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
        //  deletion("CAR_BRAND");
        deletion(177);
    }

    public static void deletion(String code) throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();

        String deleteProfile = "DELETE \n" +
                "FROM LIB_PROFILE\n" +
                "WHERE MODEL_ID IN(SELECT ID FROM LIB_MODEL WHERE TEMPLATE_ID IN(SELECT ID FROM LIB_TEMPLATE WHERE CODE ='" + code + "'))";
        stmt.executeUpdate(deleteProfile);
        String deleteModel = "DELETE \n" +
                "FROM LIB_model\n" +
                "WHERE template_id IN(SELECT ID FROM LIB_TEMPLATE WHERE CODE ='" + code + "')";
        stmt.executeUpdate(deleteModel);

        String deleteTemplate = "DELETE \n" +
                "FROM LIB_TEMPLATE WHERE CODE ='" + code + "'";
        stmt.executeUpdate(deleteTemplate);
        conn.close();

    }

    public static void deletion(int id) throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();
        String deleteProfile = "DELETE \n" +
                "FROM LIB_PROFILE\n" +
                "WHERE MODEL_ID IN(SELECT ID FROM LIB_MODEL WHERE TEMPLATE_ID IN(SELECT ID FROM LIB_TEMPLATE WHERE ID ='" + id + "'))";
        stmt.executeUpdate(deleteProfile);
        String deleteModel = "DELETE \n" +
                "FROM LIB_model\n" +
                "WHERE template_id IN(SELECT ID FROM LIB_TEMPLATE WHERE ID ='" + id + "')";
        stmt.executeUpdate(deleteModel);
        String deleteTemplate = "DELETE \n" +
                "FROM LIB_TEMPLATE WHERE ID ='" + id + "'";
        stmt.executeUpdate(deleteTemplate);
        conn.close();
    }


}
