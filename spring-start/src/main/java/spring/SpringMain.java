package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.config.SpringConfig;
import spring.impl.Bus;
import spring.impl.Hotel;

import java.time.LocalDate;

public class SpringMain {

    public static void main(String[] args) {

        Person kowalski = new Person("Jan", "Kowalski", new Ticket(LocalDate.now().minusDays(1)));

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Travel travel = context.getBean(Travel.class);

        travel.travel(kowalski);

        String transportationId = "bus";
        if (args.length>0){
            transportationId = args[0];
        }

        Transportation transportation = (Transportation)context.getBean(transportationId);
        System.out.println("transporting kowalski directly");
        transportation.transport(kowalski);

        System.out.println("done.");
    }
}
