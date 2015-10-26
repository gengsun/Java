package sun.java.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Created by sun on 26/10/15.
 */
public class StopEventHandler implements ApplicationListener<ContextStoppedEvent>
{
    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent)
    {
        System.out.println("ContextStoppedEvent Received");
    }
}
