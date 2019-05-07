package aula08.ex2;

import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {

    private static List<Person> persons = new ArrayList<>();

    public static void regist(Person person){
        persons.add(person);
    }


    //check if regist the persons
    public static void checkRegist() {
        System.out.println("Number of  people regist in SocialSecurity "+persons.size());
    }

}
