package sun.java.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by sun on 28/10/15.
 */

@Component
public class StudentDAO implements IStudentDAO
{
    private JdbcTemplate jdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age)
    {
        String SQL = "insert into Student (name, age) values (?, ?)";

        jdbcTemplate.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
    }

    @Override
    public Student getStudent(Integer id)
    {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> listStudents()
    {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id)
    {
        String SQL = "delete from Student where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
    }

    @Override
    public void update(Integer id, Integer age)
    {
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplate.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
    }

    @Override
    public void truncate()
    {
        String SQL = "truncate Student";
        jdbcTemplate.update(SQL);
        System.out.println("Table truncated.");
    }
}
