package spring;

public class Travel {

    private String name;

    private Transportation transportation;

    private Accomodation accomodation;

    public Travel(Transportation transportation, Accomodation accomodation,  String name) {
        this.transportation = transportation;
        this.accomodation = accomodation;
        this.name = name;
        System.out.println("constructing trip with parametrized constructor...");
    }

    public Travel() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public void travel(Person p){
        System.out.println("started travel for a person " + p);
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
