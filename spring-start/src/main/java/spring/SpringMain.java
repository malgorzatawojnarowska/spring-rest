package spring;

import spring.impl.Bus;
import spring.impl.Hotel;

import java.time.LocalDate;

public class SpringMain {

    public static void main(String[] args) {

        Person kowalski = new Person("Jan", "Kowalski", new Ticket(LocalDate.now().minusDays(1)));

        Transportation transportation = new Bus();
        Accomodation accomodation = new Hotel();
        String travelName = "Holiday 2023";

        Travel travel = new Travel();
        travel.setName(travelName);
        travel.setTransportation(transportation);
        travel.setAccomodation(accomodation);

        travel.travel(kowalski);

        System.out.println("done.");
    }
}
