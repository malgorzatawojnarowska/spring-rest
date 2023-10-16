package spring.impl;

import spring.Person;
import spring.Transportation;


public class Bus implements Transportation {
    @Override
    public void transport(Person p) {
        System.out.println("person " + p + " is being transported by BUS");
    }

}
