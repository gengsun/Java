package sun.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 23/10/15.
 */
@Configuration
public class BeansConfig
{
    @Bean
    public CustomEventPublisher customEventPublisher()
    {
        return new CustomEventPublisher();
    }

    @Bean
    public CustomEventHandler customEventHandler()
    {
        return new CustomEventHandler();
    }
}
