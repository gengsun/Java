package sun.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 15/03/16.
 */

@Component
@Aspect
public class Audience
{
    @Pointcut("execution(* sun.test.spring.model.Performer.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint)
    {
        System.out.println("The audience is taking their seats.");
        System.out.println("The audience is turning off their mobile phones.");

        Long start = System.currentTimeMillis();
        Long end = null;

        try {
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
        }
        catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
            throwable.printStackTrace();
        }
        finally {
            end = System.currentTimeMillis();
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        }
    }
}
