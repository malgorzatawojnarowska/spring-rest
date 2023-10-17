package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import spring.config.ExecutionTime;

@Component("travel")
// TODO elaborate on alias
public class Travel {

    private final String name;

    private final Transportation transportation;

    private final Accomodation accomodation;

    //@Autowired
    public Travel(@Air Transportation transportation, Accomodation accomodation,  String name) {
        this.transportation = transportation;
        this.accomodation = accomodation;
        this.name = name;
        System.out.println("constructing trip with parametrized constructor...");
    }

    /*public Travel() {
        System.out.println("default constructor of Travel class");
    }
*/

    @ExecutionTime
    public void travel(Person p){
        System.out.println("started travel " + name + " for a person " + p);
        transportation.transport(p);
        accomodation.host(p);
        transportation.transport(p);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "name='" + name + '\'' +
                ", transportation=" + transportation +
                ", accomodation=" + accomodation +
                '}';
    }
}
