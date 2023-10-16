package spring.impl;

import org.springframework.stereotype.Component;
import spring.Person;
import spring.Transportation;

@Component("bus")
public class Bus implements Transportation {
    @Override
    public void transport(Person p) {
        System.out.println("person " + p + " is being transported by BUS");
    }

}
