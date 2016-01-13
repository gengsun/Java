package sun.java.spring.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.java.spring.mvc.dao.EmployeeDao;
import sun.java.spring.mvc.model.Employee;
import sun.java.spring.mvc.service.EmployeeService;

import java.util.List;

/**
 * Created by sun on 16/11/15.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDao dao;

    @Override
    public Employee findById(int id)
    {
        return dao.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        dao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee)
    {
        Employee entity = dao.findById(employee.getId());

        if (entity == null)
            return;

        entity.setName(employee.getName());
        entity.setJoiningDate(employee.getJoiningDate());
        entity.setSalary(employee.getSalary());
        entity.setNin(employee.getNin());
    }

    @Override
    public void deleteEmployeeByNin(String nin)
    {
        dao.deleteEmployeeByNin(nin);
    }

    @Override
    public List<Employee> listEmployees()
    {
        return dao.listEmployees();
    }

    @Override
    public Employee findEmployeeByNin(String nin)
    {
        return dao.findEmployeeByNin(nin);
    }

    @Override
    public boolean isEmployeeNinUnique(Integer id, String nin)
    {
        Employee employee = findEmployeeByNin(nin);
        return (employee == null || (id != null && employee.getId() == id));
    }
}
