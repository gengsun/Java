package sun.java.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by sun on 26/10/15.
 */
public class StartEventHandler implements ApplicationListener<ContextStartedEvent>
{
    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent)
    {
        System.out.println("ContextStartedEvent Received");
    }
}
