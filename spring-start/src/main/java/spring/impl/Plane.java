package spring.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.Person;
import spring.Transportation;

@Component("plane")
@Qualifier("air")
public class Plane implements Transportation {

    @Override
    public void transport(Person p) {
        System.out.println("Person " + p + " is being transported by plane");
    }

    public void postConstruct(){
        System.out.println("plane: post construct");
    }

}
