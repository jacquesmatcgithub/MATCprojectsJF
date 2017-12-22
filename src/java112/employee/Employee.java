package java112.employee;


/**
 * @author Jacques Fourie
 * class Employee
 */
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String ssn;
    private String department;
    private String room;
    private String phone;

    /**
     * Constructor for Employee
     */
    public Employee() {

    }


    /**
     * Returns the value of employeeId.
     * @return employeeId The employee ID.
     */
    public String getEmployeeId() {
        return employeeId;
    }


    /**
     * Sets the value of employeeId.
     * @param employeeId The value to assign employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Returns the value of firstName.
     * @return firstName The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the value of firstName.
     * @param firstName The value to assign firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Returns the value of lastName.
     * @return lastName The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the value of lastName.
     * @param lastName The value to assign lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Returns the value of socialSecurityNumber.
     * @return ssn The employee's social security number.
     */
    public String getSsn() {
        return ssn;
    }


    /**
     * Sets the value of ssn.
     * @param ssn The value to assign ssn.
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


    /**
     * Returns the value of department.
     * @return department The department the employee works in.
     */
    public String getDepartment() {
        return department;
    }


    /**
     * Sets the value of department.
     * @param department The value to assign department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * Returns the value of room.
     * @return room The room number where the employee is located.
     */
    public String getRoom() {
        return room;
    }


    /**
     * Sets the value of room.
     * @param room The value to assign room.
     */
    public void setRoom(String room) {
        this.room = room;
    }


    /**
     * Returns the value of phone.
     * @return phone The employee's phone number.
     */
    public String getPhone() {
        return phone;
    }


    /**
     * Sets the value of phone.
     * @param phone The value to assign phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * The Employee class toString method.
     * @return String
     */
    public String toString() {
        return "EmployeeId : " + getEmployeeId() +
            "First Name : " + getFirstName() +
            "Last Name : " + getLastName() +
            "SSN : " + getSsn() +
            "Department : " + getDepartment() +
            "Room : " + getRoom() +
            "Phone : " + getPhone();
    }


}