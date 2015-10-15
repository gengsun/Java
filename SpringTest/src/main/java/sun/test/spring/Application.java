package sun.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        context = new ClassPathXmlApplicationContext("Beans.xml");
        BeansXMLHandler handler = (BeansXMLHandler) context.getBean("helloWorld");

        handler.setMessage("I am bean A");
        handler.getMessage();

        BeansXMLHandler handler1 = (BeansXMLHandler) context.getBean("helloWorld");
        handler1.setMessage("I am bean B");
        handler1.getMessage();

        handler.getMessage();
    }
}
