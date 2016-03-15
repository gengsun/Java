package sun.test.spring.model.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.test.spring.model.Performer;

/**
 * Created by sun on 15/03/16.
 */

@Component
public class Juggler implements Performer
{
    @Value("${juggler.name:Sun}")
    private String name;

    @Override
    public void perform()
    {
        System.out.println("Juggler: " + name + " is juggling...");
    }
}
