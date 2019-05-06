package aula08.ex2;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private static List<Person> persons = new ArrayList<>();

    public static void allow(Person person){
        persons.add(person);
    }

}
