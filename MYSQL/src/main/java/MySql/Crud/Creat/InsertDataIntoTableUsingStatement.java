package MySql.Crud.Creat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDataIntoTableUsingStatement {
    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String args[])throws Exception {
        //Getting the connection
        Connection con = getConnectionObject();
        System.out.println("Connection established......");
        //Creating a Statement object
        Statement stmt = con.createStatement();
        //Setting auto-commit false
        con.setAutoCommit(false);
        //Statements to insert records into lib_model_type
        String insert1 = "INSERT INTO lib_model_type VALUES ( 3,'C', 'C', ' ', 3,0)";
        String insert2 = "INSERT INTO lib_model_type VALUES ( 4,'D', 'D', ' ', 3,0)";
        String insert3 = "INSERT INTO lib_model_type VALUES ( 5,'E', 'E', ' ', 3,0)";
        String insert4 = "INSERT INTO lib_model_type VALUES ( 6,'F', 'F', ' ', 3,0)";
        String insert5 = "INSERT INTO lib_model_type VALUES ( 7,'G', 'G', ' ', 3,0)";
        //Adding the statements to batch
        stmt.addBatch(insert1);
        stmt.addBatch(insert2);
        stmt.addBatch(insert3);
        stmt.addBatch(insert4);
        stmt.addBatch(insert5);

        //Executing the batch
        stmt.executeBatch();
        //Saving the changes
        con.commit();
        con.close();
        System.out.println("Records inserted......");
    }

}
