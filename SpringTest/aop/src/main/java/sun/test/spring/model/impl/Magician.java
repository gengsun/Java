package sun.test.spring.model.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import sun.test.spring.model.MindReader;

/**
 * Created by sun on 16/03/16.
 */

@Aspect
@Component
public class Magician implements MindReader
{
    private String thoughts;

    @Pointcut("execution(* sun.test.spring.model.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {}

    @Override
    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts)
    {
        System.out.println("Intercepting volunteer's thoughts: " + thoughts);
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts()
    {
        return thoughts;
    }
}
