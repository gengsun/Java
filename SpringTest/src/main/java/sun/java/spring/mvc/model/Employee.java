package sun.java.spring.mvc.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by sun on 12/11/15.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "JOINING_DATE", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    @NotEmpty
    @Column(name = "NATIONAL_INSURANCE_NUMBER", unique = true, nullable = false)
    private String nin;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate)
    {
        this.joiningDate = joiningDate;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public String getNin()
    {
        return nin;
    }

    public void setNin(String nin)
    {
        this.nin = nin;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Employee))
            return false;

        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (nin == null) {
            if (other.nin != null)
                return false;
        } else if (!nin.equals(other.nin))
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nin == null) ? 0 : nin.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        return "Employee[id=" + id + ", name=" + name + ", joiningDate="
                + joiningDate + ", salary=" + salary + ", NINumber=" + nin + "]";
    }
}
