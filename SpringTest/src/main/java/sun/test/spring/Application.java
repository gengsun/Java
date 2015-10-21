package sun.test.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class Application
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloChina objChina = (HelloChina) context.getBean("helloChina");

        objChina.getMessage1();
        objChina.getMessage2();
        objChina.getMessage3();
    }
}
