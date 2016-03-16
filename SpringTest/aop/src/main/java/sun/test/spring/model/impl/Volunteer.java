package sun.test.spring.model.impl;

import org.springframework.stereotype.Component;
import sun.test.spring.model.Thinker;

/**
 * Created by sun on 16/03/16.
 */

@Component
public class Volunteer implements Thinker
{
    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts)
    {
        this.thoughts = thoughts;
    }

    public String getThoughts()
    {
        return thoughts;
    }
}
