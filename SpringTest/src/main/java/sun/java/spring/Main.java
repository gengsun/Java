package sun.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 22/10/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);

        printer.printMessage();
    }
}
