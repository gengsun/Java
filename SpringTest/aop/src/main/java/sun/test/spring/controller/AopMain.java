package sun.test.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.test.spring.model.Contestant;
import sun.test.spring.service.Stage;

public class AopMain
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        Stage stage = (Stage) context.getBean("stage");
        stage.startPlay();
        Contestant contestant = (Contestant) context.getBean("juggler");
        contestant.contest();
    }
}
