package sun.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 22/10/15.
 */
@Configuration
@ComponentScan
public class Main
{
    @Bean
    MessageService messageService()
    {
        return new MessageService()
        {
            public String getMessage()
            {
                return "Basic Annotation Configuration";
            }
        };
    }

    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        printer.printMessage();
    }
}
