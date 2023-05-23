package MySql.ResultSetMetaDataInterFace;

import java.sql.*;

public class MetaData {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void readingTableColumn() throws SQLException {
        Connection conn=getConnectionObject();
        Statement stmt = conn.createStatement();
        //Query to retrieve records
        String query = "Select * from employee";
        //Executing the query
        ResultSet rs = stmt.executeQuery(query);
        //Retrieving ResultSetMetaData object
        ResultSetMetaData resultSetMetaData = rs.getMetaData();//used when we dont know table details like column names ,data type etc
        //Current record details.
        for (int i = 1; i < resultSetMetaData.getColumnCount(); i++)
        {
            System.out.println("Table name: " + resultSetMetaData.getTableName(i));
            System.out.println("Column name: " + resultSetMetaData.getColumnName(i));
            System.out.println("Column type: " + resultSetMetaData.getColumnTypeName(i));
            System.out.println("SCHEMA NAME: " + resultSetMetaData.getSchemaName(i));
            System.out.println("IS AUTO_INCREMENT: " + resultSetMetaData.isAutoIncrement(i));
            System.out.println("IS CASE SENSITIVE: " + resultSetMetaData.isCaseSensitive(i));
            System.out.println("IS isSearchable: " + resultSetMetaData.isSearchable(i));
            System.out.println("IS isCurrency: " + resultSetMetaData.isCurrency(i));
            System.out.println("IS isNullable: " + resultSetMetaData.isNullable(i));
            System.out.println("IS isSigned: " + resultSetMetaData.isSigned(i));
            System.out.println("IS getColumnDisplaySize: " + resultSetMetaData.getColumnDisplaySize(i));
            System.out.println("IS getColumnLabel: " + resultSetMetaData.getColumnLabel(i));
            System.out.println("IS getPrecision: " + resultSetMetaData.getPrecision(i));
            System.out.println("IS getScale: " + resultSetMetaData.getScale(i));
            System.out.println("IS getCatalogName: " + resultSetMetaData.getCatalogName(i));
            System.out.println("IS isWritable: " + resultSetMetaData.isWritable(i));
            System.out.println("IS getColumnTypeName: " + resultSetMetaData.getColumnTypeName(i));
            System.out.println("IS isReadOnly: " + resultSetMetaData.isReadOnly(i));
            System.out.println("IS isDefinitelyWritable: " + resultSetMetaData.isDefinitelyWritable(i));
            System.out.println("IS getColumnClassName: " + resultSetMetaData.getColumnClassName(i));
            System.out.println("*******************************************************************");
        }
        System.out.println("COLUMN COUNTS: " + resultSetMetaData.getColumnCount());
    }
    public static void main(String[] args) throws SQLException {
    readingTableColumn();
    }
}
