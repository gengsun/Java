package sun.java.hibernate;

/**
 * Created by sun on 10/11/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Integer employeeId1 = employeeDAO.addEmployee("Geng", "Sun", 50000);
        Integer employeeId2 = employeeDAO.addEmployee("John", "Doe", 30000);
        Integer employeeId3 = employeeDAO.addEmployee("Jean", "Doe", 20000);

        employeeDAO.listEmployees();

        employeeDAO.updateSalary(employeeId1, 52000);
        employeeDAO.updateSalary(employeeId2, 32000);

        employeeDAO.deleteEmployee(employeeId3);

        employeeDAO.listEmployees();

        HibernateUtil.shutDown();
    }
}
