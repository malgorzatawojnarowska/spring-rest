package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class SpringMain {

    public static void main(String[] args) {

        Person kowalski = new Person("Jan", "Kowalski", new Ticket(LocalDate.now().minusDays(1)));

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
        Travel travel = context.getBean(Travel.class);
        Travel travel2 = (Travel)context.getBean("journey");

        travel.travel(kowalski);

        System.out.println("done.");
    }
}
