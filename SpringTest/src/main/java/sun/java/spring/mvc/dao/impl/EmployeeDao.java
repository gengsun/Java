package sun.java.spring.mvc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sun.java.spring.mvc.dao.IEmployeeDao;
import sun.java.spring.mvc.model.Employee;

import java.util.List;

/**
 * Created by sun on 16/11/15.
 */
@Repository("employeeDao")
public class EmployeeDao extends AbstractDao<Integer, Employee> implements IEmployeeDao
{
    @Override
    public Employee findById(int id)
    {
        return getByKey(id);
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        persist(employee);
    }

    @Override
    public void deleteEmployeeByNin(String nin)
    {
        Query query = getSession().createSQLQuery("delete from EMPLOYEE where nin = :nin");
        query.setString("nin", nin);
        query.executeUpdate();
    }

    @Override
    public List<Employee> listEmployees()
    {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>) criteria.list();
    }

    @Override
    public Employee findEmployeeByNin(String nin)
    {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nin", nin));
        return (Employee) criteria.uniqueResult();
    }
}
