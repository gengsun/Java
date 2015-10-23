package sun.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 23/10/15.
 */
@Configuration
@ComponentScan
public class HelloWorld
{
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MessageService messageService()
    {
        return new MessageService()
        {
            @Override
            public String getMessage()
            {
                return "Hello World...";
            }

            @Override
            public void init()
            {
                System.out.println("Initialising...");
            }

            @Override
            public void destroy()
            {
                System.out.println("Destroying...");
            }
        };
    }
}
