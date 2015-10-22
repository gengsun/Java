package sun.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sun on 22/10/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");

        textEditor.spellCheck();
    }
}
