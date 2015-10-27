package sun.java.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 27/10/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        ICustomerService service = context.getBean(ICustomerService.class);

        service.addCustomer();

        service.addCustomerReturnValue();

        service.addCustomerThrowException();

        service.addCustomerAround("AOP");
    }
}
