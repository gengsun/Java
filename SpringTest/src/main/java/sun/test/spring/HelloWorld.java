package sun.test.spring;

/**
 * Created by sun on 14/10/15.
 */
public class HelloWorld
{
    private String message;

    public void getMessage()
    {
        System.out.println("message = " + message);
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    private void init()
    {
        System.out.println("Bean is being initialised...");
    }

    public void destroy()
    {
        System.out.println("Bean is being destroyed...");
    }
}
