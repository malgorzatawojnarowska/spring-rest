package spring.impl;


import spring.Accomodation;
import spring.Person;


import java.util.List;


public class Hotel implements Accomodation {

    private String gratis;


    private List<String> meals;

    private void addGratis(){
        meals.add(gratis);
    }

    @Override
    public void host(Person p) {
        System.out.println("person " + p + " is being hosted in hotel. meal: " + meals);
    }
}
