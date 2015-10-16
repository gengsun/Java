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
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = applicationContext.getBean(MessagePrinter.class);
        printer.printMessage();

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

//        AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");
//        HelloWorld obj1 = (HelloWorld) context1.getBean("helloWorld");

        obj.getMessage();
//        obj1.setMessage("changed message...");
//        obj1.getMessage();
//        obj.getMessage();

        context.registerShutdownHook();
    }
}
