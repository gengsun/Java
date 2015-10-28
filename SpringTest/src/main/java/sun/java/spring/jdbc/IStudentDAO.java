package sun.java.spring.jdbc;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by sun on 28/10/15.
 */
public interface IStudentDAO
{
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource dataSource);

    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    void create(String name, Integer age);

    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    Student getStudent(Integer id);

    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    List<Student> listStudents();

    /**
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
     */
    void delete(Integer id);

    /**
     * This is the method to be used to update
     * a record into the Student table.
     */
    void update(Integer id, Integer age);

    /**
     * This is the method to truncate the table
     */
    void truncate();
}
