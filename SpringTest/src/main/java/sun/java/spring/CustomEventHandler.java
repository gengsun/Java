package sun.java.spring;

import org.springframework.context.ApplicationListener;

/**
 * Created by sun on 27/10/15.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent>
{
    @Override
    public void onApplicationEvent(CustomEvent customEvent)
    {
        System.out.println(customEvent.toString());
    }
}
