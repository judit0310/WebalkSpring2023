package hu.uni.miskolc.webalk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");*/
/*
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        HallgatoService service = (HallgatoService) context.getBean("hallgatoService");

        System.out.println( "Hello World!" );
        System.out.println(service.getHallgatok());

        Hallgato h = new Hallgato(2,"AAA111","Nagy Rózsa","nagy.rozsa@pelda.hu", LocalDate.now(),Nem.NO);
        service.addHallgato(h);
        System.out.println(service.getHallgatok());

*/
    }
}
