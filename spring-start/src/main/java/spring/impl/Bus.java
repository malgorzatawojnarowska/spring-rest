package spring.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.Person;
import spring.Transportation;

@Component("bus")
public class Bus implements Transportation {

    @PostConstruct
    void init(){
        System.out.println("preparing bus for a journey");
    }

    @Override
    public void transport(Person p) {
        System.out.println("person " + p + " is being transported by BUS");
    }

}
