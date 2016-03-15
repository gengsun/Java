package sun.test.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 15/03/16.
 */

@Component
@Aspect
public class Audience
{
    @Before("execution(* sun.test.spring.model.Performer.perform(..))")
    public void takeSeats()
    {
        System.out.println("The audience is taking their seats.");
    }

    @Before("execution(* sun.test.spring.model.Performer.perform(..))")
    public void turnOffCellPhones()
    {
        System.out.println("The audience is turning off their mobile phones");
    }

    @AfterReturning("execution(* sun.test.spring.model.Performer.perform(..))")
    public void applaud()
    {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("execution(* sun.test.spring.model.Performer.perform(..))")
    public void demandRefund()
    {
        System.out.println("Boo! We want our money back!");
    }
}
