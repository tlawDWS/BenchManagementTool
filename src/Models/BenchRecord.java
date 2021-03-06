package Models;

import DAL.DatabaseOperations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BenchRecord {
    private int benchRecordID;
    private int employeeID;
    private Date recordDate;
    private int benchHours;
    private String benchActivity;

    public BenchRecord(int employeeID, Date recordDate, String benchActivity)
    {
        setEmployeeID(employeeID);
        setRecordDate(recordDate);
        //setBenchHours(benchHours);
        setBenchActivity(benchActivity);
    }

    public int getEmployeeID()
    {
        return this.employeeID;
    }

    public void setEmployeeID(int value)
    {
        this.employeeID = value;
    }

    public Date getRecordDate()
    {
        return this.recordDate;
    }

    public String getFormattedRecordDate()
    {
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");

        return formattedDate.format(getRecordDate());
    }

    public void setRecordDate(Date value)
    {
        this.recordDate = value;
    }

    public int getBenchHours()
    {
        return this.benchHours;
    }

    public void setBenchHours(int value)
    {
        this.benchHours = value;
    }

    public String getBenchActivity()
    {
        return this.benchActivity;
    }

    public void setBenchActivity(String value)
    {
        this.benchActivity = value;
    }

    public String getEmployeeName(int id){
        return DatabaseOperations.getEmployeeName(id);

//        Employee e = new Employee("Tony", "Law", "Sydney", "blah@blah.com");
//        if (id == e.getEmployeeID())
//            return e.getFirstName() + " " + e.getLastName();
//        else
//            return "John Doe";
    }
}