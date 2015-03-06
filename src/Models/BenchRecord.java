package Models;

import java.util.Date;

public class BenchRecord {
    private int benchRecordID;
    private int employeeID;
    private Date currentDate;
    private int benchHours;
    private String benchActivity;

    public BenchRecord(int employeeID, Date currentDate, int benchHours, String benchActivity)
    {
        setEmployeeID(employeeID);
        setCurrentDate(currentDate);
        setBenchHours(benchHours);
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

    public Date getCurrentDate()
    {
        return this.currentDate;
    }

    public void setCurrentDate(Date value)
    {
        this.currentDate = value;
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
        Employee e = new Employee(1, "Tony", "Law", "Sydney");
        if (id == e.getEmployeeID())
            return e.getFirstName() + " " + e.getLastName();
        else
            return "John Doe";
    }
}