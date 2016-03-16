package sun.test.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.test.spring.model.Performer;
import sun.test.spring.model.Thinker;

/**
 * Created by sun on 15/03/16.
 */

@Component
public class Stage
{
    @Autowired
    private Performer performer;

    @Autowired
    private Thinker thinker;

    public void startPlay()
    {
//        thinker.thinkOfSomething("Queen of Hearts");
        performer.perform();
    }
}
