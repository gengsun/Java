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
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        MessagePrinter printer = context.getBean(MessagePrinter.class);
//        printer.printMessage();

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

//        handler.setMessage("I am bean A");
//        handler.getMessage();
//
//        BeansXMLHandler handler1 = (BeansXMLHandler) context.getBean("helloWorld");
//        handler1.setMessage("I am bean B");
//        handler1.getMessage();

        obj.getMessage();

        context.registerShutdownHook();
    }
}
