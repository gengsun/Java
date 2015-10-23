package sun.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 22/10/15.
 */
public interface MessageService
{
    String getMessage();
    void init();
    void destroy();
}
