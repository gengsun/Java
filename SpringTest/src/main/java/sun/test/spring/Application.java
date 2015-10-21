package sun.test.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
public class Application
{
    @Bean
    MessageService mockMessageService()
    {
        return new MessageService()
        {
            public String getMessage()
            {
                return "Hello World...";
            }
        };
    }

    public static void main(String[] args)
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage1();
        obj.getMessage2();

        HelloChina objChina = (HelloChina) context.getBean("helloChina");
        objChina.getMessage1();
        objChina.getMessage2();
        objChina.getMessage3();
    }
}
