package sun.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by sun on 21/10/15.
 */
public class InitHelloWorld implements BeanPostProcessor
{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException
    {
        System.out.println("Before Initialisation: " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException
    {
        System.out.println("After Initialisation: " + s);
        return o;
    }
}
