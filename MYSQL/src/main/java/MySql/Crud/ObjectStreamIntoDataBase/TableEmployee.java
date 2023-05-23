package MySql.Crud.ObjectStreamIntoDataBase;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;
import java.util.*;

public class TableEmployee {
    static Employee emp1 = new Employee(1, "sagar", 24, 12789l, "chikodi", "MySql");
    static Employee emp2 = new Employee(2, "prapulla", 23, 234501l, "blg", "Sql");
    static Employee emp3 = new Employee(3, "suraj", 25, 345612l, "ck", "java");
    static Employee emp4 = new Employee(4, "pavan", 24, 45123l, "dk", "Sql");
    static Employee emp5 = new Employee(5, "divya", 23, 51234l, "ch", "html");
    static Employee emp6 = new Employee(6, "raj", 27, 67345l, "goa", "css");
    static Employee emp7 = new Employee(7, "deepak", 23, 123456l, "kerala", "mongoDb");
    static Employee emp8 = new Employee(8, "pavanK", 26, 834567l, "chikodi", "jsp");
    static Employee emp9 = new Employee(9, "soundarya", 23, 522234l, "ch", "html");
    static Employee emp10 = new Employee(10, "pooja", 27, 69345l, "goa", "css");
    static Employee emp11 = new Employee(11, "manju", 23, 12456l, "kerala", "mongoDb");
    static Employee emp12 = new Employee(12, "sanju", 26, 83467l, "chikodi", "jsp");
    static String INSERT_data = "INSERT INTO employee" + "  (ID,NAME,AGE,PHONE,ADDRESS,SKILL,EMP_BLOB) VALUES " +
            " (?, ?, ?, ?, ?, ?,?);";


    public static void main(String[] args) throws Exception {
        //insertData();
        Map<Integer, Employee> listMap= readEmployeeTable();
        System.out.println(listMap);

    }

    public static Connection getConnectionObject() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/MYSQLDATABASE", "root", "sagar123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertData() throws Exception {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);
        list.add(emp8);
        list.add(emp9);
        list.add(emp10);
        list.add(emp11);
        list.add(emp12);
        Connection conn = getConnectionObject();
        PreparedStatement preparedStatement = conn.prepareStatement(INSERT_data);
        conn.setAutoCommit(false);
        for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext(); ) {
            Employee employee = (Employee) iterator.next();
            preparedStatement.setInt(1, employee.getID());
            preparedStatement.setString(2, employee.getNAME());
            preparedStatement.setInt(3, employee.getAGE());
            preparedStatement.setLong(4, employee.getPHONE());
            preparedStatement.setString(5, employee.getADDRESS());
            preparedStatement.setString(6, employee.getSKILLS());
            preparedStatement.setBlob(7, convertToBytes(list));
            preparedStatement.addBatch();
        }
        int[] updateCounts = preparedStatement.executeBatch();
        System.out.println(Arrays.toString(updateCounts));
        conn.commit();
        conn.setAutoCommit(true);
        conn.close();
    }


    public static Blob convertToBytes(ArrayList<Employee> employees) throws Exception {

        Blob blob = null;
        for (Employee emp : employees) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objStream = new ObjectOutputStream(outputStream);
            objStream.writeObject(emp);
            blob = new SerialBlob(outputStream.toByteArray());
        }
        return blob;
    }

    public static Object deserialize(Blob blob) throws Exception {
        int blobLength = (int) blob.length();
        byte[] bytes = blob.getBytes(1, blobLength);
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try (ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            return stream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public static Map<Integer, Employee> readEmployeeTable() throws Exception {
        var con = getConnectionObject();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from employee");
        Map<Integer, Employee> listMap = new LinkedHashMap<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            Employee employees = (Employee) deserialize(rs.getBlob("EMP_BLOB"));
            listMap.put(id, employees);
        }
        con.close();
        return listMap;
    }
}
