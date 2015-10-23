package sun.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 22/10/15.
 */
@Component
public class MessagePrinter
{
    private MessageService service;

    @Autowired
    public void setService(MessageService service)
    {
        this.service = service;
    }

    public void printMessage()
    {
        System.out.println(this.service.getMessage());
    }
}
