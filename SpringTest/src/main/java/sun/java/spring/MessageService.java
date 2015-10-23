package sun.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 22/10/15.
 */
@Configuration
public class MessageService
{
    @Bean
    public MessagePrinter messageSerive()
    {
        return new MessagePrinter();
    }
}
