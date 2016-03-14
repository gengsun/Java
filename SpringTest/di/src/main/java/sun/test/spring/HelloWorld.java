package sun.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 14/03/16.
 */
@Component
public class HelloWorld
{
    @Autowired
    @Qualifier("AppImpl2")
    private AppService appService;

    @Value("${name.wife:Geng Sun}")
    private String name;

    public void print()
    {
        appService.print();
        System.out.println(name);
    }
}
