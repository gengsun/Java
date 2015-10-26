package sun.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 23/10/15.
 */
@Configuration
public class BeansConfig
{
    @Bean
    public MessagePrinter messagePrinter()
    {
        return new MessagePrinter();
    }

    @Bean
    public StartEventHandler startEventHandler()
    {
        return new StartEventHandler();
    }

    @Bean
    public StopEventHandler stopEventHandler()
    {
        return new StopEventHandler();
    }
}
