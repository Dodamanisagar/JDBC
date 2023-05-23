package MySql.Crud.Creat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InsertingMultipleRecordsInOneShot {

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
        List<TemplateDetails> list = new ArrayList<>();
//        list.add(new TemplateDetails(2,"silver","silver","silver",1,2,"2022-02-24"," ","sagar",0,0));
//        list.add(new TemplateDetails(3,"titan","titan","titan",2,3,"2022-02-01"," ","deepak",0,0));
//        list.add(new TemplateDetails(4,"diamand","diamand","diamand",3,4,"2023-02-14"," ","sagar",0,0));
//        list.add(new TemplateDetails(5,"soil","soil","soil",4,5,"2022-05-14"," ","sagar",0,0));
//        list.add(new TemplateDetails(6,"food","food","food",5,6,"1999-06-14"," ","deepak",0,0));
//        list.add(new TemplateDetails(7,"Steel","Steel","Steel",6,5,"2021-10-13"," ","sagar",0,0));
//        list.add(new TemplateDetails(8,"water","water","water",2,7,"1999-06-24"," ","sagar",0,0));
        list.add(new TemplateDetails(10, "wind", "wind", "solar", 7, 4, "1997-10-14", " ", "sagar", 0, 0));
        //query
        String INSERT_TemplateDetailsS_SQL = "INSERT INTO lib_template" + "  (ID, CODE, NAME, DESCRIPTION, PARENT,MODEL_TYPE_ID,MODIFIED_DATE,DEFAULT_PROPERTY,CREATED_BY,IS_VIEW,IS_ABSTRACT) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Connection connection = getConnectionObject();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TemplateDetailsS_SQL);
        connection.setAutoCommit(false);
        for (Iterator<TemplateDetails> iterator = list.iterator(); iterator.hasNext(); ) {
            TemplateDetails TemplateDetails = (TemplateDetails) iterator.next();
            preparedStatement.setInt(1, TemplateDetails.getID());
            preparedStatement.setString(2, TemplateDetails.getCODE());
            preparedStatement.setString(3, TemplateDetails.getNAME());
            preparedStatement.setString(4, TemplateDetails.getDESCRIPTION());
            preparedStatement.setInt(5, TemplateDetails.getPARENT());
            preparedStatement.setInt(6, TemplateDetails.getMODEL_TYPE_ID());
            preparedStatement.setString(7, TemplateDetails.getMODIFIED_DATE());
            preparedStatement.setString(8, TemplateDetails.getDEFAULT_PROPERTY());
            preparedStatement.setString(9, TemplateDetails.getCREATED_BY());
            preparedStatement.setInt(10, TemplateDetails.getIS_VIEW());
            preparedStatement.setInt(11, TemplateDetails.getIS_ABSTRACT());
            preparedStatement.addBatch();
        }

        int[] updateCounts = preparedStatement.executeBatch();
        System.out.println(Arrays.toString(updateCounts));
        connection.commit();
        connection.setAutoCommit(true);
        connection.close();
    }

}




