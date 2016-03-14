package sun.test.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 14/03/16.
 */
@Component
@Qualifier("AppImpl1")
public class AppImpl1 implements AppService
{
    @Override
    public void print()
    {
        System.out.println("App Implementation 1...");
    }
}
