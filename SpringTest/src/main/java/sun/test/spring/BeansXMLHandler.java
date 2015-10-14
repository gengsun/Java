package sun.test.spring;

/**
 * Created by sun on 14/10/15.
 */
public class BeansXMLHandler
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
}
