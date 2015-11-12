package sun.java.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by sun on 11/11/15.
 */
public class EmployeeDAO implements IEmployeeDAO
{
    private static final SessionFactory SESSION_FACTORY;

    static
    {
        try {
            SESSION_FACTORY = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public Integer addEmployee(String fname, String lname, int salary)
    {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();
        Employee employee = new Employee(fname, lname, salary);
        Integer employeeId = (Integer) session.save(employee);
        session.getTransaction().commit();
        session.close();

        return employeeId;
    }

    @Override
    public void listEmployees()
    {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();

        List<Employee> employees = session.createQuery("FROM Employee").list();
        for (Employee employee : employees) {
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName());
            System.out.println("  Salary: " + employee.getSalary());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateSalary(Integer employeeID, int salary)
    {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, employeeID);
        employee.setSalary(salary);
        session.update(employee);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void deleteEmployee(Integer employeeID)
    {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, employeeID);
        session.delete(employee);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void shutDown()
    {
        SESSION_FACTORY.close();
    }
}
