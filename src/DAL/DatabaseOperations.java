package DAL;

import Models.BenchRecord;
import Models.Employee;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlaw on 20/03/2015.
 */
public final class DatabaseOperations {

    public static Connection conn;

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "p@ssw0rd");
    }

    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

//    public static void getConnection() throws Exception {
//        Statement stmt = null;
//        String sql = "select * from TEST";
//        ResultSet set;
//        int id = 0;
//        String name = "";
//
//        Class.forName("org.h2.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "p@ssw0rd");
//
//        stmt = conn.createStatement();
//        set = stmt.executeQuery(sql);
//
//        while (set.next())
//        {
//            id = set.getInt("ID");
//            name = set.getString("NAME");
//        }
//
//        conn.close();
//    }

    public static List<BenchRecord> getBenchRecords() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet set;
        String sql = "SELECT * FROM BENCHRECORD";
        int id;
        String summary;
        Date benchDate;
        List<BenchRecord> brL = new ArrayList<BenchRecord>();

        try {
            conn = openConnection();
            stmt = conn.createStatement();
            set = stmt.executeQuery(sql);

            while (set.next()) {
                id = set.getInt("EMPLOYEEID");
                summary = set.getString("DAILYSUMMARY");
                benchDate = set.getDate("BENCHRECORDDATE");
                brL.add(new BenchRecord(id, benchDate, summary));
            }
        }
        finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return brL;
    }

    public static List<Employee> getEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> emp = new ArrayList<Employee>();
        Statement stmt = null;
        String sql = "SELECT * FROM EMPLOYEE";
        String firstName, lastName, email, branch;
        Boolean hasLeftCompany;
        ResultSet set;
        int id;

        try
        {
            conn = openConnection();
            stmt = conn.createStatement();
            set = stmt.executeQuery(sql);

            while (set.next()) {
                id = set.getInt("ID");
                firstName = set.getString("FIRSTNAME");
                lastName = set.getString("LASTNAME");
                email = set.getString("EMAIL");
                branch = set.getString("BRANCH");
                hasLeftCompany = set.getBoolean("HASLEFTCOMPANY");
                emp.add(new Employee(id, firstName, lastName, branch, email));
            }
        }
        finally {
            closeConnection();
        }

        return emp;
    }

    public static void addBenchRecord(BenchRecord br) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO BENCHRECORD(EMPLOYEEID, DAILYSUMMARY, BENCHRECORDDATE) VALUES(?, ?, ?)";
        try {
            conn = openConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, br.getEmployeeID());
            stmt.setString(2, br.getBenchActivity());
            stmt.setString(3, br.getFormattedRecordDate());
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addEmployee(Employee emp) {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO EMPLOYEE(FIRSTNAME, LASTNAME, EMAIL, HASLEFTCOMPANY, BRANCH) VALUES(?, ?, ?, False, ?)";
        try
        {
            conn = openConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getEmail());
            stmt.setString(4, emp.getBranch());
            stmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getEmployeeName(int id) {
        String fullName = "";
        PreparedStatement stmt = null;
        ResultSet set;
        String sql = "SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE ID = ?";

        try {
            conn = openConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            set = stmt.executeQuery();

            while (set.next()) {
                fullName = set.getString("FIRSTNAME") + " " + set.getString("LASTNAME");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return fullName;
    }
}
