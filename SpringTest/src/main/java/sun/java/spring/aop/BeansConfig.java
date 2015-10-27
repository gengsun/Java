package sun.java.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by sun on 27/10/15.
 */
@Configuration
@EnableAspectJAutoProxy
public class BeansConfig
{
    @Bean
    public LoggingAspect loggingAspect()
    {
        return new LoggingAspect();
    }

    @Bean
    public CustomerService customerService()
    {
        return new CustomerService();
    }
}
