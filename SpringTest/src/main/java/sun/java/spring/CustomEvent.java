package sun.java.spring;

import org.springframework.context.ApplicationEvent;

/**
 * Created by sun on 27/10/15.
 */
public class CustomEvent extends ApplicationEvent
{
    public CustomEvent(Object source)
    {
        super(source);
    }

    public String toString()
    {
        return "My custom event...";
    }
}
