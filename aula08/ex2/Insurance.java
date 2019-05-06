package aula08.ex2;

import java.util.ArrayList;
import java.util.List;

public class Insurance {

    private static List<Person> persons = new ArrayList<>();

    public static void regist(Person person){
        persons.add(person);
    }
}
