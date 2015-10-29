package sun.java.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by sun on 28/10/15.
 */

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        System.out.println("------Records Creation--------");
        studentDAO.create("Zara", 11);
        studentDAO.create("Nuha", 2);
        studentDAO.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentDAO.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----");
        studentDAO.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----");
        Student student = studentDAO.getStudent(2);
        System.out.print("ID : " + student.getId());
        System.out.print(", Name : " + student.getName());
        System.out.println(", Age : " + student.getAge());

        System.out.println("----Deleting Record with ID = 2 -----");
        studentDAO.delete(2);

        students = studentDAO.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }

        studentDAO.truncate();
    }
}
