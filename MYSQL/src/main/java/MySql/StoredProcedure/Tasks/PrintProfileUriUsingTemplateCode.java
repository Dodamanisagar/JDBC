package MySql.StoredProcedure.Tasks;

import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PrintProfileUriUsingTemplateCode {
    private static String tempCode = null;
    private static String[] code = null;
    private static String[] category = null;

    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/gdm9?noAccessToProcedureBodies=true", "gdm9", "gdm9");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        PrintProfileUriUsingTemplateCode csdemo = new PrintProfileUriUsingTemplateCode();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("enter template Code:-");
            tempCode = scanner.next();
            if (tempCode == null)
                break;
            code = csdemo.getModelCode(tempCode);
            category = csdemo.getModelCategory(tempCode);

            for (int i = 0; i < category.length; i++) {
                String[] profilName = csdemo.getProfilename(tempCode, category[i], code[i]);
                for (int k = 0; k < profilName.length; k++) {
                    System.out.println("model://" + category[i] + "/" + code[i] + "/" + profilName[k]);
                }
            }
        }
    }

    private String[] getModelCategory(String tempCode) throws SQLException {
        Connection conn = getConnectionObject();
        String query = "{call ModelCategory(?,?)}";
        CallableStatement clstmt = conn.prepareCall(query);
        clstmt.setString(1, tempCode);
        clstmt.registerOutParameter(2, Types.VARCHAR);
        clstmt.executeQuery();
        String[] modelCategory = clstmt.getString(2).split(",");
        clstmt.close();
        clstmt.close();
        conn.close();
        return modelCategory;
    }

    private String[] getModelCode(String tempCode) throws SQLException {
        Connection conn = getConnectionObject();
        String query = "{call ModelCode(?,?)}";
        CallableStatement clstmt = conn.prepareCall(query);
        clstmt.setString(1, tempCode);
        clstmt.registerOutParameter(2, Types.VARCHAR);
        clstmt.executeQuery();
        String[] modelCode = clstmt.getString(2).split(",");
        clstmt.close();
        clstmt.close();
        conn.close();
        return modelCode;
    }

    private String[] getProfilename(String tempCode, String modelCategory, String modelCode) throws SQLException {
        Connection conn = getConnectionObject();
        String query = "{call ProfileName(?,?,?,?)}";
        CallableStatement clstmt = conn.prepareCall(query);
        clstmt.setString(1, tempCode);
        clstmt.setString(2, modelCategory);
        clstmt.setString(3, modelCode);
        clstmt.registerOutParameter(4, Types.VARCHAR);
        clstmt.executeQuery();
        String[] profileName = clstmt.getString(4).split(",");
        clstmt.close();
        clstmt.close();
        conn.close();
        return profileName;
    }
}
