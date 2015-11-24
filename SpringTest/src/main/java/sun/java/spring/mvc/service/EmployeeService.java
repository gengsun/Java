package sun.java.spring.mvc.service;

import sun.java.spring.mvc.model.Employee;

import java.util.List;

/**
 * Created by sun on 12/11/15.
 */
public interface EmployeeService
{
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeByNin(String nin);

    List<Employee> listEmployees();

    Employee findEmployeeByNin(String nin);

    boolean isEmployeeNinUnique(Integer id, String nin);
}
