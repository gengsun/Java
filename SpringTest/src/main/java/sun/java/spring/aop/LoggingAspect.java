package sun.java.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

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

    @After("execution(* sun.java.spring.aop.impl.CustomerService.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint)
    {
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @AfterReturning(pointcut = "execution(* sun.java.spring.aop.impl.CustomerService.addCustomerReturnValue(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result)
    {
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }

    @AfterThrowing(pointcut = "execution(* sun.java.spring.aop.impl.CustomerService.addCustomerThrowException(..))", throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error)
    {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
    }

    @Around("execution(* sun.java.spring.aop.impl.CustomerService.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
    }
}
