package sun.java.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by sun on 22/10/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MessageService.class);

        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.setMessage("Annotation lifecycle callbacks");
        printer.printMessage();

        context.registerShutdownHook();
    }
}
