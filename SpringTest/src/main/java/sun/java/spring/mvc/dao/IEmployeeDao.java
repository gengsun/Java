package sun.java.spring.mvc.dao;

import sun.java.spring.mvc.model.Employee;

import java.util.List;

/**
 * Created by sun on 16/11/15.
 */
public interface IEmployeeDao
{
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeByNin(String nin);

    List<Employee> listEmployees();

    Employee findEmployeeByNin(String nin);
}
