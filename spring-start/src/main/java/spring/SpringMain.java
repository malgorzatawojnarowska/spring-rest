package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.config.SpringConfig;

import java.time.LocalDate;

public class SpringMain {

    public static void main(String[] args) {

        Person kowalski = new Person("Jan", "Kowalski", new Ticket(LocalDate.now().minusDays(1)));

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
                //new ClassPathXmlApplicationContext("classpath:/context.xml");
        Travel travel = context.getBean(Travel.class);

        travel.travel(kowalski);

        System.out.println("done.");
    }
}
