package sun.java.hibernate;

/**
 * Created by sun on 11/11/15.
 */
public interface IEmployeeDAO
{
    /**
     * Method to CREATE an employee in the database
     *
     * @param fname
     * @param lname
     * @param salary
     * @return
     */
    Integer addEmployee(String fname, String lname, int salary);

    /**
     * Method to READ all the employees
     */
    void listEmployees();

    /**
     * Method to UPDATE salary for an employee
     *
     * @param employeeID
     * @param salary
     */
    void updateSalary(Integer employeeID, int salary);

    /**
     * Method to DELETE an employee from the records
     *
     * @param employeeID
     */
    void deleteEmployee(Integer employeeID);
}
