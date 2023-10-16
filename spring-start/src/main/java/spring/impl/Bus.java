package spring.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.Person;
import spring.Transportation;

@Component("bus")
@Primary
public class Bus implements Transportation {

    @PostConstruct
    void init(){
        System.out.println("preparing for a journey");
    }

    @Override
    public void transport(Person p) {
        System.out.println("person " + p + " is being transported by BUS");
    }

}
