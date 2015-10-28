package sun.java.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by sun on 28/10/15.
 */
public class StudentMapper implements RowMapper<Student>
{
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
