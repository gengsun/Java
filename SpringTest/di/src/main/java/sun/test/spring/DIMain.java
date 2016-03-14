package sun.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class DIMain
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-di.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.print();
    }
}