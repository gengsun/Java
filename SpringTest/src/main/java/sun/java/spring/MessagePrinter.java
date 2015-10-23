package sun.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 22/10/15.
 */
public class MessagePrinter
{
    private String message;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void printMessage()
    {
        System.out.println(message);
    }

    public void init()
    {
        System.out.println("Initialising...");
    }

    public void destroy()
    {
        System.out.println("Destroying...");
    }
}
