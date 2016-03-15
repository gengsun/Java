package sun.test.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 15/03/16.
 */

@Aspect
@Component
public class Logger
{
    @Before("execution(* sun.test.spring.service.Performer.perform(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("Logging before: " + joinPoint.getSignature().getDeclaringTypeName());
    }
}
