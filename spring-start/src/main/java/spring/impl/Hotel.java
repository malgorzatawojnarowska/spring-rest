package spring.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.Accomodation;
import spring.Person;


import java.util.List;

@Component
public class Hotel implements Accomodation {

    private String gratis;

    private List<String> meals;

    private void addGratis(){
        meals.add(gratis);
    }


    @Autowired
    public void setMeals( @Qualifier("meals") List<String> meals) {
        this.meals = meals;
    }

    @Override
    public void host(Person p) {
        System.out.println("person " + p + " is being hosted in hotel. meal: " + meals);
    }
}
