package DAL;

import Models.BenchRecord;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlaw on 20/03/2015.
 */
public final class DBConnection {

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

    public static void getConnection() throws Exception {
        Statement stmt = null;
        String sql = "select * from TEST";
        ResultSet set;
        int id = 0;
        String name = "";

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "p@ssw0rd");

        stmt = conn.createStatement();
        set = stmt.executeQuery(sql);

        while (set.next())
        {
            id = set.getInt("ID");
            name = set.getString("NAME");
        }

        conn.close();
    }

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

    //public static void addBenchRecord(BenchRecord br) {
    public static void addBenchRecord() {
        Statement stmt = null;
        String sql = "INSERT INTO BENCHRECORD(EMPLOYEEID, DAILYSUMMARY, BENCHRECORDDATE) VALUES(2, 'OH HAI', '2015-03-01')";

        try {
            try {
                conn = openConnection();
                stmt = conn.createStatement();
                stmt.execute(sql);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
