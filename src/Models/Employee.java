package Models;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String branch;

    public Employee(int id, String firstName, String lastName, String branch)
    {
        setEmployeeID(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBranch(branch);
    }

    public int getEmployeeID()
    {
        return this.employeeID;
    }

    public void setEmployeeID(int value) {
        this.employeeID = value;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String value)
    {
        this.firstName = value;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String value)
    {
        this.lastName = value;
    }

    public String getBranch()
    {
        return this.branch;
    }

    public void setBranch(String value)
    {
        this.branch = value;
    }

}