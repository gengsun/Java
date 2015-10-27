package sun.java.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by sun on 27/10/15.
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware
{
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher)
    {
        publisher = applicationEventPublisher;
    }

    public void publish()
    {
        CustomEvent customEvent = new CustomEvent(this);
        publisher.publishEvent(customEvent);
    }
}
