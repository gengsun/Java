package sun.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import sun.test.spring.service.Juggler;
import sun.test.spring.service.Performer;

//@Configuration
//@ComponentScan(basePackages = "sun.test.spring.*")
//@PropertySource(value = "classpath:performer.properties")
public class AopMain
{
//    @Bean
//    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
//    {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    public static void main(String[] args)
    {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AopMain.class);
//        Performer performer = context.getBean(Juggler.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        Performer performer = (Performer) context.getBean("juggler");
        performer.perform();
    }
}
