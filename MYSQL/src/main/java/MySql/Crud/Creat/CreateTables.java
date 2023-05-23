package MySql.Crud.Creat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
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
        Connection conn =getConnectionObject();
            Statement stmt = conn.createStatement();

            String LIB_Model_Type="CREATE TABLE IF NOT EXISTS lib_model_type " +
                    " (ID INT  not NULL auto_increment, " +
                    " CODE VARCHAR (50) NOT NULL unique, " +
                    " NAME VARCHAR (50) NOT NULL UNIQUE, " +
                    " DEFAULT_ATTRIBUTE VARCHAR(50), " +
                    " ICONID INT," +
                    " IS_SYSTEM INT,"+
                    " PRIMARY KEY ( ID )) ";
            stmt.executeUpdate(LIB_Model_Type);

            String LIB_Template = "CREATE TABLE IF NOT EXISTS lib_template " +
                    "(ID INT  not NULL auto_increment, " +
                    " CODE VARCHAR (50) NOT NULL unique, " +
                    " NAME VARCHAR (50) NOT NULL UNIQUE, " +
                    " DESCRIPTION VARCHAR (50), " +
                    " PARENT INT,  "+
                    " MODEL_TYPE_ID INT, "+
                    " MODIFIED_DATE DATE, "+
                    " DEFAULT_PROPERTY VARCHAR (50), "+
                    " CREATED_BY VARCHAR (50), "+
                    " IS_VIEW INT, " +
                    " IS_ABSTRACT INT, " +
                    " PRIMARY KEY ( ID ), " +
                    " foreign key(MODEL_TYPE_ID) REFERENCES lib_model_type(ID) "+
                    ")";
            stmt.executeUpdate(LIB_Template);

            String LIB_MODEL="CREATE TABLE IF NOT EXISTS lib_model " +
                    "(ID INT  not NULL auto_increment, " +
                    " NAME VARCHAR (50) NOT NULL UNIQUE, " +
                    " DESCRIPTION VARCHAR (50), " +
                    " MODEL_TYPE_ID INT, "+
                    " CATEGORY VARCHAR (50) NOT NULL UNIQUE, " +
                    " CODE VARCHAR (50) NOT NULL UNIQUE, " +
                    " DEFAULT_ATTRIBUTE VARCHAR (50), "+
                    " IS_TEMPLATE INT, " +
                    " TEMPLATE_ID INT, " +
                    " STATUS INT, " +
                    " DATASET_PACKAGE_ID INT, " +
                    " URI VARCHAR (50), "+
                    " PRIMARY KEY ( ID ), " +
                    " foreign key(MODEL_TYPE_ID) REFERENCES lib_model_type(ID), "+
                    " foreign key(TEMPLATE_ID) REFERENCES lib_template(ID) "+
                    ")";
            stmt.executeUpdate(LIB_MODEL);

            String LIB_PROFILE = "CREATE TABLE IF NOT EXISTS lib_profile " +
                    "(ID INT not NULL auto_increment, " +
                    " DATATYPE INT NOT NULL , " +
                    " NAME VARCHAR (50) NOT NULL UNIQUE, " +
                    " MODEL_ID INT NOT NULL UNIQUE, " +
                    " DEFAULT_VERSION VARCHAR (50), " +
                    " PROVIDER VARCHAR (50), " +
                    " CURRENCY VARCHAR (50), " +
                    " TIMEZONE VARCHAR (50), " +
                    " UNIT VARCHAR (50), " +
                    " PRIMARY KEY ( ID ), " +
                    " foreign key(MODEL_ID) REFERENCES lib_model(ID) "+
                    ")";
            stmt.executeUpdate(LIB_PROFILE);

        String LIB_TEMPLATE_PROPERTY = "CREATE TABLE IF NOT EXISTS lib_template_property " +
                "(ID INT not NULL auto_increment, " +
                " TEMPLATE_ID INT default null, " +
                " NAME VARCHAR (50) default null, " +
                " LIB_DATATYPE_ID INT default null, " +
                " DESCRIPTION VARCHAR (50) default null, " +
                " SHOW_IN_LISTS int (11) default null, " +
                " VERSION_TYPE int (11) default null, " +
                " VERSION_PURGING_TYPE int (11) default null, " +
                " VERSION_PURGE int (11) default null, " +
                " PRIMARY KEY ( ID ), " +
                " foreign key(TEMPLATE_ID) REFERENCES lib_template(ID) "+
                ")";
        stmt.executeUpdate(LIB_TEMPLATE_PROPERTY);

        String LIB_VERSION = "CREATE TABLE IF NOT EXISTS lib_VERSION " +
                "(ID INT not NULL auto_increment, " +
                " PROFILE_ID INT default null, " +
                " VERSION_PURGE int (11) default null, " +
                " PRIMARY KEY ( ID ), " +
                " foreign key(PROFILE_ID) REFERENCES lib_PROFILE(ID) "+
                ")";
        stmt.executeUpdate(LIB_VERSION);

        String employee = "CREATE TABLE IF NOT EXISTS STUDENT " +
                "(ID SMALLINT UNSIGNED NOT NULL, " +
                " NAME VARCHAR(30) NOT NULL, " +
                " AGE INT (3), " +
                " PHONE INT(10), " +
                " SKILL VARCHAR (30), " +
                " EMP_BLOB BLOB, " +
                " PRIMARY KEY ( ID ) " +
                ")";
        stmt.executeUpdate(employee);

        conn.close();

            System.out.println("Created table in given database...");


    }
}
