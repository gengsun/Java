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

        obj.getMessage();
        obj.setMessage("new message");
        obj.getMessage();

        context.registerShutdownHook();
    }
}
