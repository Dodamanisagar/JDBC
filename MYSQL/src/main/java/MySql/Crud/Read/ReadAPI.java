package MySql.Crud.Read;

import java.sql.*;

public class ReadAPI {
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
        System.out.println("*************** READING MODEL FOR TEMPLATE CODE *******************");
        readModel("CURVETEST2");
        System.out.println("******************* READING PROFILE FOR MODEL URI **************");
        readProfile("model://TEMPLATE/CURVETEST");
    }

    public static void readModel(String code) throws SQLException {
        String QUERY = "SELECT * FROM lib_model\n" +
                "WHERE TEMPLATE_ID IN(SELECT ID\n" +
                "FROM lib_template\n" +
                "WHERE CODE='" + code + "')";
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(QUERY);
        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println();
            System.out.print("name: " + rs.getString("name"));
            System.out.println();
            System.out.print("DESCRIPTION: " + rs.getString("DESCRIPTION"));
            System.out.println();
            System.out.print("MODEL_TYPE: " + rs.getInt("MODEL_TYPE"));
            System.out.println();
            System.out.print("CATEGORY: " + rs.getString("CATEGORY"));
            System.out.println();
            System.out.print("CODE: " + rs.getString("CODE"));
            System.out.println();
            System.out.print("DEFAULT_ATTRIBUTE: " + rs.getString("DEFAULT_ATTRIBUTE"));
            System.out.println();
            System.out.print("IS_TEMPLATE: " + rs.getInt("IS_TEMPLATE"));
            System.out.println();
            System.out.print("TEMPLATE_ID: " + rs.getInt("TEMPLATE_ID"));
            System.out.println();
            System.out.print("STATUS: " + rs.getString("STATUS"));
            System.out.println();
            System.out.print("DATASET_PACKAGE_ID: " + rs.getInt("DATASET_PACKAGE_ID"));
            System.out.println();
            System.out.print("URI: " + rs.getString("URI"));
            System.out.println();

            System.out.println("\n---------------------------------");
            conn.close();
        }

    }

    public static void readProfile(String uri) throws SQLException {
        String QUERY = "SELECT * FROM lib_profile\n" +
                "where MODEL_ID in (select id from lib_model where uri='" + uri + "')";
        // Open a connection
        Connection conn = getConnectionObject();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(QUERY);
        while (rs.next()) {
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println();
            System.out.print("DATATYPE: " + rs.getInt("DATATYPE"));
            System.out.println();
            System.out.print("NAME: " + rs.getString("NAME"));
            System.out.println();
            System.out.print("MODEL_ID: " + rs.getInt("MODEL_ID"));
            System.out.println();
            System.out.print("DEFAULT_VERSION: " + rs.getString("DEFAULT_VERSION"));
            System.out.println();
            System.out.print("PROVIDER: " + rs.getString("PROVIDER"));
            System.out.println();
            System.out.print("CURRENCY: " + rs.getString("CURRENCY"));
            System.out.println();
            System.out.print("TIMEZONE: " + rs.getInt("TIMEZONE"));
            System.out.println();
            System.out.print("UNIT: " + rs.getInt("UNIT"));

            System.out.println("\n---------------------------------");
           conn.close();
        }

    }
}
