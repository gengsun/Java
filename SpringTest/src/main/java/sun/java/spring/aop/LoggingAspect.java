package sun.java.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by sun on 27/10/15.
 */
@Aspect
public class LoggingAspect
{
    @Before("execution(* sun.java.spring.aop.impl.CustomerService.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("logBefore() is running...");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }
}
