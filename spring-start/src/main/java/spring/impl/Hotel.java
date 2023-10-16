package spring.impl;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.Accomodation;
import spring.Person;

import java.util.List;

@Component
public class Hotel implements Accomodation {


    @Value("#{'${meals.gratis:paluszki}'.toUpperCase()}") // SpEL
    private String gratis;

    @Resource
    private List<String> meals;

    @Value("#{'${meals.menu}'.split(',')}")
    private List<String> menu;

    @PostConstruct
    private void addGratis(){
        System.out.println("hotel menu: " + menu);
        meals.add(gratis);
    }


    public void setMeals( List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void host(Person p) {
        System.out.println("person " + p + " is being hosted in hotel. meal: " + meals);
    }
}
