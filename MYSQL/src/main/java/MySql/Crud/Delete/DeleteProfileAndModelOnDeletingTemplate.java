package MySql.Crud.Delete;

import java.sql.*;

public class DeleteProfileAndModelOnDeletingTemplate {
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

        // dropForeignKey();
        addForeignKey();
    }

    public static void dropForeignKey() throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();
        //droping foreign keys
        String deleteProfile = "ALTER TABLE lib_profile " +
                " DROP FOREIGN KEY lib_profile_ibfk_1 ";
        stmt.executeUpdate(deleteProfile);
        String deleteModel = "ALTER TABLE lib_model " +
                " DROP FOREIGN KEY lib_model_ibfk_2 ";
        stmt.executeUpdate(deleteModel);
        String deleteModel_type_id = "ALTER TABLE lib_model " +
                " DROP FOREIGN KEY lib_model_ibfk_1 ";
        stmt.executeUpdate(deleteModel_type_id);
       conn.close();

    }

    public static void addForeignKey() throws SQLException {
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();
        //adding new foreign constraints
        String Profile = "ALTER TABLE lib_PROFILE\n" +
                "ADD FOREIGN KEY(MODEL_ID) REFERENCES LIB_MODEL(ID) ON DELETE CASCADE ON UPDATE CASCADE ";
        stmt.executeUpdate(Profile);
        String Model_type_id = "ALTER TABLE lib_model\n" +
                "ADD FOREIGN KEY(MODEL_TYPE_ID) REFERENCES LIB_MODEL_TYPE(ID) ON DELETE CASCADE ON UPDATE CASCADE";
        stmt.executeUpdate(Model_type_id);
        String Model = "ALTER TABLE lib_model\n" +
                "ADD FOREIGN KEY(TEMPLATE_ID) REFERENCES LIB_TEMPLATE(ID) ON DELETE CASCADE ON UPDATE CASCADE";
        stmt.executeUpdate(Model);
        conn.close();

    }
}
