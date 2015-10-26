package sun.java.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 22/10/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        context.start();

        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        context.stop();
    }
}
