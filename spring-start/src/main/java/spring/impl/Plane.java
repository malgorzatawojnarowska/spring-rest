package spring.impl;

import org.springframework.stereotype.Component;
import spring.Air;
import spring.Person;
import spring.Transportation;

@Component
@Air
public class Plane implements Transportation {

    @Override
    public void transport(Person p) {
        System.out.println("Person " + p + " is being transported by plane");
    }

    public void postConstruct(){
        System.out.println("plane: post construct");
    }

}
