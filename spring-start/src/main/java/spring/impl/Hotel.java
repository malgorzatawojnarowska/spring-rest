package spring.impl;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.Accomodation;
import spring.Person;


import java.util.List;

@Component
public class Hotel implements Accomodation {

    private String gratis;

    //@Autowired
    //@Qualifier("meals")
    @Resource
    private List<String> meals;

    private void addGratis(){
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
