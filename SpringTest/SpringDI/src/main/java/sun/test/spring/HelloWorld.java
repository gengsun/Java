package sun.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 14/03/16.
 */
@Component
public class HelloWorld
{
    @Autowired
    @Qualifier("AppImpl1")
    private AppService appService;

    public void print()
    {
        appService.print();
    }
}
