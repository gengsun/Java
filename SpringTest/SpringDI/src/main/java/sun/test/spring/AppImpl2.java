package sun.test.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 14/03/16.
 */
@Component
@Qualifier("AppImpl2")
public class AppImpl2 implements AppService
{
    @Override
    public void print()
    {
        System.out.println("App Implementation 2...");
    }
}
