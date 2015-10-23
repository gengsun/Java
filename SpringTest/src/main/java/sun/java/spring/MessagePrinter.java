package sun.java.spring;

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
        System.out.println("TutorialsPoint Annotation Configuration...");
    }
}
