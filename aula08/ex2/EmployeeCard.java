package aula08.ex2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCard {


    private static List<Person> persons = new ArrayList<>();
    private int id;

    public EmployeeCard(Person person){
        persons.add(person);
        this.id = persons.indexOf(person);
    }

    //id correspond to index of array
    private int getId(Person person){
        return persons.indexOf(person);
    }

}
