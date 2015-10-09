package sun.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sun on 09/10/15.
 */
public class SpringTest
{
    public static void print()
    {
        System.out.println("Spring Framework test...");
    }

    public static void main(String[] args)
    {
        print();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
}
